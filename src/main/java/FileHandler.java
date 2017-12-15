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
			long date = httpCon.getLastModified();
			File file = new File("src/main/resources/POLKCOUNTY.txt");
			/* Use for testing
			file.setLastModified(date-100);
			*/
			if (file == null || date > file.lastModified()) {
				try {
			        java.io.BufferedInputStream in = new java.io.BufferedInputStream(new java.net.URL("http://www.assess.co.polk.ia.us/web/exports/resA/inven/POLKCOUNTY.txt").openStream());
			        java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
			        java.io.BufferedOutputStream bout = new BufferedOutputStream(fos);
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
			}
		}
		httpCon.disconnect();
		return isUpdated;
	}
	
	public static void updateData() {
		String file = "src/main/resources/POLKCOUNTY.txt";
		String url = "jdbc:mysql://localhost:3306/assessor";
		String username = "java";
		String password = "jtl4hp2w";
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
		insert.append("insert into polk_county values (");
							insert.append(id + ",");
							insert.append("'" + st[0] + "'" + ",");
							insert.append("'" + st[1] + "'" + ",");
							insert.append(dp + ",");
							insert.append(gp + ",");
							insert.append(NumberUtils.toInt(st[4], 0) + ",");
							insert.append("'" + st[5] + "'" + ",");
							insert.append("'" + st[6] + "'" + ",");
							insert.append("'" + st[7] + "'" + ",");
							insert.append("'" + st[8] + "'" + ",");
							insert.append("'" + st[4] + " " + st[5] + " " + st[6] + " " + st[7] + " " + st[8] + "'" + ",");
							insert.append("'" + st[9] + "'" + ",");
							insert.append("'" + st[10] + "'" + ",");
							insert.append("'" + st[11] + "'" + ",");
							insert.append("'" + st[12] + "'" + ",");
							insert.append("'" + st[13] + "'" + ",");
							insert.append("'" + st[14] + "'" + ",");
							insert.append(NumberUtils.toInt(st[15], 0) + ",");
							insert.append(NumberUtils.toInt(st[16], 0) + ",");
							insert.append(NumberUtils.toInt(st[17], 0) + ",");
							insert.append(NumberUtils.toInt(st[18], 0) + ",");
							insert.append(NumberUtils.toInt(st[19], 0) + ",");
							insert.append(NumberUtils.toInt(st[20], 0) + ",");
							insert.append(NumberUtils.toInt(st[21], 0) + ",");
							insert.append(NumberUtils.toDouble(st[22], 0.0) + ",");
							insert.append("'" + st[23] + "'" + ",");
							insert.append("'" + st[24] + "'" + ",");
							insert.append("'" + st[25] + "'" + ",");
							insert.append("'" + st[26] + "'" + ",");
							insert.append(NumberUtils.toInt(st[27], 0) + ",");
							insert.append("'" + st[28] + "'" + ",");
							insert.append("'" + st[29] + "'" + ",");
							insert.append(NumberUtils.toInt(st[30], 0) + ",");
							insert.append(NumberUtils.toInt(st[31], 0) + ",");
							insert.append(NumberUtils.toInt(st[32], 0) + ",");
							insert.append(NumberUtils.toInt(st[33], 0) + ",");
							insert.append(NumberUtils.toInt(st[34], 0) + ",");
							insert.append("'" + st[35] + "'" + ",");
							insert.append(NumberUtils.toInt(st[36], 0) + ",");
							insert.append(NumberUtils.toInt(st[37], 0) + ",");
							insert.append(NumberUtils.toInt(st[38], 0) + ",");
							insert.append(NumberUtils.toInt(st[39], 0) + ",");
							insert.append(NumberUtils.toInt(st[40], 0) + ",");
							insert.append(NumberUtils.toInt(st[41], 0) + ",");
							insert.append(NumberUtils.toInt(st[42], 0) + ",");
							insert.append(NumberUtils.toInt(st[43], 0) + ",");
							insert.append(NumberUtils.toInt(st[44], 0) + ",");
							insert.append(NumberUtils.toInt(st[45], 0) + ",");
							insert.append(NumberUtils.toInt(st[46], 0) + ",");
							insert.append(NumberUtils.toInt(st[47], 0) + ",");
							insert.append(NumberUtils.toInt(st[48], 0) + ",");
							insert.append(NumberUtils.toInt(st[49], 0) + ",");
							insert.append(NumberUtils.toInt(st[50], 0) + ",");
							insert.append(NumberUtils.toInt(st[51], 0) + ",");
							insert.append(NumberUtils.toInt(st[52], 0) + ",");
							insert.append(NumberUtils.toInt(st[53], 0) + ",");
							insert.append(NumberUtils.toInt(st[54], 0) + ",");
							insert.append(NumberUtils.toInt(st[55], 0) + ",");
							insert.append(NumberUtils.toInt(st[56], 0) + ",");
							insert.append(NumberUtils.toInt(st[57], 0) + ",");
							insert.append(NumberUtils.toInt(st[58], 0) + ",");
							insert.append(NumberUtils.toInt(st[59], 0) + ",");
							insert.append(NumberUtils.toInt(st[60], 0) + ",");
							insert.append(NumberUtils.toInt(st[61], 0) + ",");
							insert.append("'" + st[62] + "'" + ",");
							insert.append("'" + st[64] + "'" + ",");
							insert.append(NumberUtils.toInt(st[65], 0) + ",");
							insert.append("'" + st[66] + "'" + ",");
							insert.append("'" + st[67] + "'" + ",");
							insert.append("'" + st[68] + "'" + ",");
							insert.append("'" + st[69] + "'" + ",");
							insert.append("'" + st[70] + "'" + ",");
							if (date != null) {
								insert.append("'" + date.toString() + "'" + ",");
							} else {
								insert.append("null" + ",");
							}
							insert.append(NumberUtils.toInt(st[72], 0) + ",");
							insert.append(NumberUtils.toInt(st[73], 0) + ",");
							insert.append("'" + st[74] + "'" + ",");
							insert.append("'" + st[75] + "'" + ",");
							insert.append("'" + st[76] + "'" + ",");
							insert.append("'" + st[77] + "'" + ",");
							insert.append("'" + st[78] + "'" + ",");
							insert.append("'" + st[79] + "'" + ",");
							if (date2 != null) {
								insert.append("'" + date2.toString() + "'" + ",");
							} else {
								insert.append("null" + ",");
							}
							insert.append(NumberUtils.toInt(st[81], 0) + ",");
							insert.append(NumberUtils.toInt(st[82], 0) + ",");
							insert.append("'" + st[83] + "'" + ",");
							insert.append("'" + st[84] + "'" + ",");
							insert.append("'" + st[85] + "'" + ",");
							insert.append(NumberUtils.toInt(st[86], 0) + ",");
							insert.append("'" + st[88] + "'" + ",");
							insert.append("'" + st[89] + "'" + ",");
							insert.append("'" + st[90] + "'" + ",");
							insert.append("'" + st[91] + "'" + ",");
							insert.append("'" + st[92] + "'" + ",");
							insert.append("'" + st[93] + "'" + ",");
							insert.append("'" + st[94] + "'" + ",");
							insert.append("'" + st[95] + "'" + ",");
							insert.append("'" + st[96] + "'" + ",");
							insert.append("'" + st[97] + "'" + ",");
							insert.append("'" + st[98] + "'" + ",");
							insert.append("'" + st[99] + "'" + ",");
							insert.append("'" + st[100] + "'" + ",");
							insert.append("'" + st[101] + "'" + ",");
							insert.append("'" + st[102] + "'" + ",");
							insert.append("'" + st[103] + "'" + ",");
							insert.append(revenueStamps + ",");
							insert.append(xCoord + ",");
							insert.append(yCoord + ",");
							insert.append(NumberUtils.toInt(st[107], 0) + ",");
							insert.append("'" + st[108] + "'" + ",");
							insert.append("'" + st[109] + "'" + ",");
							insert.append("'" + st[110] + "'" + ",");
							insert.append("'" + st[111] + "'" + ",");
							insert.append("'" + st[112] + "'" + ",");
							insert.append("'" + st[113] + "'" + ",");
							insert.append(NumberUtils.toDouble(st[114], 0) + ",");
							insert.append(NumberUtils.toDouble(st[115], 0) + ",");
							insert.append(NumberUtils.toInt(st[116], 0) + ",");
							insert.append("'" + st[117] + "'" + ",");
							insert.append(NumberUtils.toInt(st[118], 0) + ",");
							insert.append(NumberUtils.toInt(st[119], 0) + ")");
							
		try {
			Statement stmt = connection.createStatement();
			String insertStmt = insert.toString();
			stmt.execute(insertStmt);
		} catch (SQLException e) {
			System.out.println("id: " + id);
			e.printStackTrace();
		}
	}
}
