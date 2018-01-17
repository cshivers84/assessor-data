package org.assessordata.batch.assessordata_batch;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import org.apache.commons.lang3.math.NumberUtils;

public class FileHandler {
	private static int i = 1;
	
	public static boolean updateFile() {
		URL urlObject = null;
		boolean isUpdated = false;
		try {
			urlObject = new URL("http://www.assess.co.polk.ia.us/web/exports/basic/resAllI.html");
		} catch (MalformedURLException urlException) {
			System.out.println("Caught MalformedURLException in updateData()");
		}
		HttpURLConnection httpCon = null;
		try {
			if (urlObject != null) {
				httpCon = (HttpURLConnection) urlObject.openConnection();
			}
		} catch (IOException ioException) {
			System.out.println("Caught IOException getting http connection in updateData()");
		}
		if (httpCon != null) {
			//long date = httpCon.getLastModified();
			File file = new File("POLKCOUNTY.txt");
//			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//			File file = new File(classLoader.getResource("main/resources/file/POLKCOUNTY.txt").getFile());
			/* Use for testing
			file.setLastModified(date-100);
			*/
			//if (file == null || date > file.lastModified()) {
				try {
			        java.io.BufferedInputStream in = new java.io.BufferedInputStream(new java.net.URL("http://www.assess.co.polk.ia.us/web/exports/resA/inven/POLKCOUNTY.txt").openStream());
			        System.out.println("Opened new BufferedInputStream");
			        java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
			        System.out.println("Created new FileOutputStream");
			        java.io.BufferedOutputStream bout = new BufferedOutputStream(fos);
			        System.out.println("Created new BufferedOutputStream");
			        byte data[] = new byte[1024];
			        int read;
			        while ((read = in.read(data, 0, 1024)) >= 0) {
			            bout.write(data, 0, read);
			        }
			        System.out.println("New POLKCOUNTY file downloaded on " + Calendar.getInstance().toString());
			        bout.close();
			        in.close();
			        isUpdated = true;
				} catch (IOException e) {
					System.out.println("Unexpected IOException in updateData()");
				}
			//}
		}
		httpCon.disconnect();
		return isUpdated;
	}
	
	public static void updateData() {
		String file = "POLKCOUNTY.txt";
		//String url = "jdbc:mysql://localhost:3306/assessor"; // local connection
		String url = "jdbc:mysql://cshivers84db.c5xxdigzjn7r.us-east-2.rds.amazonaws.com:3306/assessor"; 
//		String username = "java"; // local username
		String username = "cshivers84";
//		String password = "jtl4hp2w"; // local pw
		String password = "utl4hp2w";
		String truncateTable = "truncate table polk_county";
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Stream<String> stream = Files.lines(Paths.get(file))) {
			try {
				Statement stmt = connection.createStatement();
				stmt.execute(truncateTable);
			} catch (SQLException se) {
				System.out.println("Unable to truncate table");
			}
			stream.forEach(s -> {
				if (!s.startsWith("jurisdiction")) {
					String[] line = s.split("\t", -1);
					insertNewParcel(i, line, connection);
					i++;
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			throw new IllegalStateException("Cannot connect to the database!", se);
		}
	}

	private static void insertNewParcel(int id, String[] st, Connection connection) {
		st = Arrays.stream(st)
				.map(s -> s.replaceAll("'", "\\\\'"))
				.toArray(size -> new String[size]);
		String dpStr = st[2];
		long dp = NumberUtils.toLong(dpStr.substring(1, dpStr.length() - 1), 0);
		String gpStr = st[3];
		long gp = NumberUtils.toLong(gpStr.substring(1, gpStr.length() - 1), 0);
		String fullStreet = st[4] + " " + st[5] + " " + st[6] + " " + st[7] + " " + st[8];
		fullStreet = fullStreet.trim().replaceAll(" +", " ");
		String filePattern = "MM/dd/yyyy";
		String sqlPattern = "yyyy-MM-dd";
	    String date = null;
		if (st[71] != null && !st[71].isEmpty()) {
			try {
				Date initDate = new SimpleDateFormat(filePattern).parse(st[71]);
			    SimpleDateFormat formatter = new SimpleDateFormat(sqlPattern);
			    date = formatter.format(initDate);
			}  catch (ParseException e) {
				System.out.println("Unable to parse transferTH1 date for parcel: " + st[4] + " " + st[5] + " " + st[6] + " " + st[7]);
			}
		}
	    String date2 = null;
	    if (st[80] != null && !st[80].isEmpty()) {
			try {
				Date initDate = new SimpleDateFormat(filePattern).parse(st[80]);
			    SimpleDateFormat formatter = new SimpleDateFormat(sqlPattern);
			    date2 = formatter.format(initDate);
			}  catch (ParseException e) {
				System.out.println("Unable to parse transferCB1 date for parcel: " + st[4] + " " + st[5] + " " + st[6] + " " + st[7]);
			}
		}
		BigDecimal revenueStamps = new BigDecimal(0);
		BigDecimal xCoord = new BigDecimal(0);
		BigDecimal yCoord = new BigDecimal(0);
		if (!st[104].isEmpty()) {
			revenueStamps = NumberUtils.createBigDecimal(st[104]);
		}
		if (!st[105].isEmpty()) {
			xCoord = NumberUtils.createBigDecimal(st[105]);
		}
		if (!st[106].isEmpty()) {
			yCoord = NumberUtils.createBigDecimal(st[106]);
		}
		
		StringBuffer insert = new StringBuffer();
		
		insert.append(writeSql(st, id, dp, gp, fullStreet, date, date2, revenueStamps, xCoord, yCoord));
							
		try {
			Statement stmt = connection.createStatement();
			String insertStmt = insert.toString();
			stmt.execute(insertStmt);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("id: " + id);
			e.printStackTrace();
		}
	}
	
	private static String writeSql(String[] st, int id, long dp, long gp, String fullStreet, String date, String date2, 
			BigDecimal revenueStamps, BigDecimal xCoord, BigDecimal yCoord) {
		
		if (date != null) {
			date = format(date.toString());
		} else {
			date = "null,";
		}
		
		if (date2 != null) {
			date2 = format(date.toString());
		} else {
			date2 = "null,";
		}
		
		String sql = "insert into polk_county values (" + id + "," + 
			format(st[0]) + format(st[1]) + dp + "," + gp + "," + NumberUtils.toInt(st[4], 0) + "," + format(st[5]) +
			format(st[6]) + format(st[7]) + format(st[8]) + format(fullStreet) + format(st[9]) + format(st[10]) +
			format(st[9]) + format(st[10]) + format(st[11]) + format(st[12]) + format(st[13]) + format(st[14]) +
			NumberUtils.toInt(st[15], 0) + "," + NumberUtils.toInt(st[16], 0) + "," + NumberUtils.toInt(st[17], 0) + "," + 
			NumberUtils.toInt(st[18], 0) + "," + NumberUtils.toInt(st[19], 0) + "," + NumberUtils.toInt(st[20], 0) + "," +
			NumberUtils.toInt(st[21], 0) + "," + NumberUtils.toDouble(st[22], 0.0) + "," + format(st[23]) + format(st[24]) + 
			format(st[24]) + format(st[25]) + format(st[26]) + NumberUtils.toInt(st[27], 0) + "," + format(st[28]) +
			format(st[29]) + NumberUtils.toInt(st[30], 0) + "," + NumberUtils.toInt(st[31], 0) + "," + NumberUtils.toInt(st[32], 0) + "," +
			NumberUtils.toInt(st[33], 0) + "," + NumberUtils.toInt(st[34], 0) + "," + format(st[35]) + NumberUtils.toInt(st[36], 0) + "," +
			NumberUtils.toInt(st[37], 0) + "," + NumberUtils.toInt(st[38], 0) + "," + NumberUtils.toInt(st[39], 0) + "," + 
			NumberUtils.toInt(st[40], 0) + "," + NumberUtils.toInt(st[41], 0) + "," + NumberUtils.toInt(st[42], 0) + "," +
			NumberUtils.toInt(st[43], 0) + "," + NumberUtils.toInt(st[44], 0) + "," + NumberUtils.toInt(st[45], 0) + "," +
			NumberUtils.toInt(st[46], 0) + "," + NumberUtils.toInt(st[47], 0) + "," + NumberUtils.toInt(st[48], 0) + "," +
			NumberUtils.toInt(st[49], 0) + "," + NumberUtils.toInt(st[50], 0) + "," + NumberUtils.toInt(st[51], 0) + "," +
			NumberUtils.toInt(st[52], 0) + "," + NumberUtils.toInt(st[53], 0) + "," + NumberUtils.toInt(st[54], 0) + "," +
			NumberUtils.toInt(st[55], 0) + "," + NumberUtils.toInt(st[56], 0) + "," + NumberUtils.toInt(st[57], 0) + "," +
			NumberUtils.toInt(st[58], 0) + "," + NumberUtils.toInt(st[59], 0) + "," + NumberUtils.toInt(st[60], 0) + "," +
			NumberUtils.toInt(st[61], 0) + "," + format(st[62]) + format(st[64]) +  NumberUtils.toInt(st[65], 0) + "," +
			format(st[66]) + format(st[67]) + format(st[68]) + format(st[69]) + format(st[70]) + date + NumberUtils.toInt(st[72], 0) + "," +
			NumberUtils.toInt(st[73], 0) + "," + format(st[74]) + format(st[75]) + format(st[76]) + format(st[77]) + format(st[78]) +
			format(st[79]) + date2 + NumberUtils.toInt(st[81], 0) + "," + NumberUtils.toInt(st[82], 0) + "," + format(st[83]) +
			format(st[84]) + format(st[85]) + NumberUtils.toInt(st[86], 0) + "," + format(st[88]) + format(st[89]) + format(st[90]) +
			format(st[91]) + format(st[92]) + format(st[93]) + format(st[94]) + format(st[95]) + format(st[96]) + format(st[97]) +
			format(st[98]) + format(st[99]) + format(st[100]) + format(st[101]) + format(st[102]) + format(st[103]) + revenueStamps + "," +
			xCoord + "," + yCoord + "," + NumberUtils.toInt(st[107], 0) + "," + format(st[108]) + format(st[109]) + format(st[110]) +
			format(st[111]) + format(st[112]) + format(st[113]) + NumberUtils.toDouble(st[114], 0) + "," + NumberUtils.toDouble(st[115], 0) + "," +
			NumberUtils.toInt(st[116], 0) + "," + format(st[117]) + NumberUtils.toInt(st[118], 0) + "," + NumberUtils.toInt(st[119], 0) + ")";
		
		return sql;
	}
	
	private static String format(String s) {
		StringBuffer sb = new StringBuffer();
		sb.append("'");
		sb.append(s);
		sb.append("',");
		return sb.toString();
	}
}
