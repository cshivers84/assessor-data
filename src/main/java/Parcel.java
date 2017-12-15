package org.assessordata.batch.assessordata_batch;

public class Parcel {
	private int polkCountyId;
	private String jurisdiction;
	private String nbhd;
	private long dp;
	private long gp;
	private int house;
	private String dir;
	private String street;
	private String suffix;
	private String suffixDir;
	private String fullStreet;
	private String apt;
	private String city;
	private String state;
	private String zip;
	private String zip4;
	private String classification;
	private int landFull;
	private int bldgFull;
	private int totalFull;
	private int landAdj;
	private int bldgAdj;
	private int totalAdj;
	private int landSF;
	private double landAcres;
	private String occupancy;
	private String residenceType;
	private String bldgStyle;
	private String exteriorWallType;
	private int percentBrick;
	private String roofType;
	private String roofMaterial;
	private int mainLivingArea;
	private int upperLivingArea;
	private int finAtticArea;
	private int totalLivingArea;
	private int unfinAtticArea;
	private String foundation;
	private int basementArea;
	private int finBsmtAreaTot;
	private int bsmtWalkout;
	private int bsmtGarCapacity;
	private int attGarageArea;
	private int garageBrick;
	private int openPorchArea;
	private int enclosePorchArea;
	private int patioArea;
	private int deckArea;
	private int canopyArea;
	private int veneerArea;
	private int carportArea;
	private int bathrooms;
	private int toiletRooms;
	private int extraFixtures;
	private int whirlpools;
	private int hottubs;
	private int saunas;
	private int fireplaces;
	private int bedrooms;
	private int rooms;
	private int families;
	private int yearBuilt;
	private int yearRemodel;
	private int effYearBuilt;
	private String condition;
	private String heating;
	private int airConditioning;
	private String percentComplete;
	private String detachedStructs;
	private String lnameTH1;
	private String fnameTH1;
	private String initialTH1;
	private java.sql.Timestamp transferTH1;
	private int bookTH1;
	private int pgTH1;
	private String lnameTH2;
	private String fnameTH2;
	private String initialTH2;
	private String lnameCB1;
	private String fnameCB1;
	private String initialCB1;
	private java.sql.Timestamp transferCB1;
	private int bookCB1;
	private int pgCB1;
	private String lnameCB2;
	private String fnameCB2;
	private String initialCB2;
	private int mailHouse;
	private String mailDir;
	private String mailStreet;
	private String mailSuffix;
	private String mailSuffixDir;
	private String mailUnitType;
	private String mailUnitNumber;
	private String mailCity;
	private String mailState;
	private String mailZip;
	private String mailZip4;
	private String mailZip2;
	private String mailCounty;
	private String mailLname;
	private String mailFname;
	private String mailInitial;
	private String mailBusiness;
	private java.math.BigDecimal revenueStamps;
	private java.math.BigDecimal xCoord;
	private java.math.BigDecimal yCoord;
	private int tif;
	private String tifDescr;
	private String condoUnitAddress;
	private String condoFinLivArea;
	private String condoYearBuilt;
	private String platname;
	private String schoolDistrict;
	private double frontage;
	private double depth;
	private int finBsmtArea1;
	private String finBsmtQual1;
	private int finBsmtArea2;
	private int finBsmtQual2;
	
	public Parcel() {
		
	}
	
	public int getPolkCountyId() {
		return polkCountyId;
	}
	public void setPolkCountyId(int polkCountyId) {
		this.polkCountyId = polkCountyId;
	}
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public String getNbhd() {
		return nbhd;
	}
	public void setNbhd(String nbhd) {
		this.nbhd = nbhd;
	}
	public long getDp() {
		return dp;
	}
	public void setDp(long dp) {
		this.dp = dp;
	}
	public long getGp() {
		return gp;
	}
	public void setGp(long gp) {
		this.gp = gp;
	}
	public int getHouse() {
		return house;
	}
	public void setHouse(int house) {
		this.house = house;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getSuffixDir() {
		return suffixDir;
	}
	public void setSuffixDir(String suffixDir) {
		this.suffixDir = suffixDir;
	}
	public String getFullStreet() {
		return fullStreet;
	}
	public void setFullStreet(String fullStreet) {
		this.fullStreet = fullStreet;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		this.apt = apt;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getZip4() {
		return zip4;
	}
	public void setZip4(String zip4) {
		this.zip4 = zip4;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public int getLandFull() {
		return landFull;
	}
	public void setLandFull(int landFull) {
		this.landFull = landFull;
	}
	public int getBldgFull() {
		return bldgFull;
	}
	public void setBldgFull(int bldgFull) {
		this.bldgFull = bldgFull;
	}
	public int getTotalFull() {
		return totalFull;
	}
	public void setTotalFull(int totalFull) {
		this.totalFull = totalFull;
	}
	public int getLandAdj() {
		return landAdj;
	}
	public void setLandAdj(int landAdj) {
		this.landAdj = landAdj;
	}
	public int getBldgAdj() {
		return bldgAdj;
	}
	public void setBldgAdj(int bldgAdj) {
		this.bldgAdj = bldgAdj;
	}
	public int getTotalAdj() {
		return totalAdj;
	}
	public void setTotalAdj(int totalAdj) {
		this.totalAdj = totalAdj;
	}
	public int getLandSF() {
		return landSF;
	}
	public void setLandSF(int landSF) {
		this.landSF = landSF;
	}
	public double getLandAcres() {
		return landAcres;
	}
	public void setLandAcres(double landAcres) {
		this.landAcres = landAcres;
	}
	public String getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}
	public String getResidenceType() {
		return residenceType;
	}
	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}
	public String getBldgStyle() {
		return bldgStyle;
	}
	public void setBldgStyle(String bldgStyle) {
		this.bldgStyle = bldgStyle;
	}
	public String getExteriorWallType() {
		return exteriorWallType;
	}
	public void setExteriorWallType(String exteriorWallType) {
		this.exteriorWallType = exteriorWallType;
	}
	public int getPercentBrick() {
		return percentBrick;
	}
	public void setPercentBrick(int percentBrick) {
		this.percentBrick = percentBrick;
	}
	public String getRoofType() {
		return roofType;
	}
	public void setRoofType(String roofType) {
		this.roofType = roofType;
	}
	public String getRoofMaterial() {
		return roofMaterial;
	}
	public void setRoofMaterial(String roofMaterial) {
		this.roofMaterial = roofMaterial;
	}
	public int getMainLivingArea() {
		return mainLivingArea;
	}
	public void setMainLivingArea(int mainLivingArea) {
		this.mainLivingArea = mainLivingArea;
	}
	public int getUpperLivingArea() {
		return upperLivingArea;
	}
	public void setUpperLivingArea(int upperLivingArea) {
		this.upperLivingArea = upperLivingArea;
	}
	public int getFinAtticArea() {
		return finAtticArea;
	}
	public void setFinAtticArea(int finAtticArea) {
		this.finAtticArea = finAtticArea;
	}
	public int getTotalLivingArea() {
		return totalLivingArea;
	}
	public void setTotalLivingArea(int totalLivingArea) {
		this.totalLivingArea = totalLivingArea;
	}
	public int getUnfinAtticArea() {
		return unfinAtticArea;
	}
	public void setUnfinAtticArea(int unfinAtticArea) {
		this.unfinAtticArea = unfinAtticArea;
	}
	public String getFoundation() {
		return foundation;
	}
	public void setFoundation(String foundation) {
		this.foundation = foundation;
	}
	public int getBasementArea() {
		return basementArea;
	}
	public void setBasementArea(int basementArea) {
		this.basementArea = basementArea;
	}
	public int getFinBsmtAreaTot() {
		return finBsmtAreaTot;
	}
	public void setFinBsmtAreaTot(int finBsmtAreaTot) {
		this.finBsmtAreaTot = finBsmtAreaTot;
	}
	public int getBsmtWalkout() {
		return bsmtWalkout;
	}
	public void setBsmtWalkout(int bsmtWalkout) {
		this.bsmtWalkout = bsmtWalkout;
	}
	public int getBsmtGarCapacity() {
		return bsmtGarCapacity;
	}
	public void setBsmtGarCapacity(int bsmtGarCapacity) {
		this.bsmtGarCapacity = bsmtGarCapacity;
	}
	public int getAttGarageArea() {
		return attGarageArea;
	}
	public void setAttGarageArea(int attGarageArea) {
		this.attGarageArea = attGarageArea;
	}
	public int getGarageBrick() {
		return garageBrick;
	}
	public void setGarageBrick(int garageBrick) {
		this.garageBrick = garageBrick;
	}
	public int getOpenPorchArea() {
		return openPorchArea;
	}
	public void setOpenPorchArea(int openPorchArea) {
		this.openPorchArea = openPorchArea;
	}
	public int getEnclosePorchArea() {
		return enclosePorchArea;
	}
	public void setEnclosePorchArea(int enclosePorchArea) {
		this.enclosePorchArea = enclosePorchArea;
	}
	public int getPatioArea() {
		return patioArea;
	}
	public void setPatioArea(int patioArea) {
		this.patioArea = patioArea;
	}
	public int getDeckArea() {
		return deckArea;
	}
	public void setDeckArea(int deckArea) {
		this.deckArea = deckArea;
	}
	public int getCanopyArea() {
		return canopyArea;
	}
	public void setCanopyArea(int canopyArea) {
		this.canopyArea = canopyArea;
	}
	public int getVeneerArea() {
		return veneerArea;
	}
	public void setVeneerArea(int veneerArea) {
		this.veneerArea = veneerArea;
	}
	public int getCarportArea() {
		return carportArea;
	}
	public void setCarportArea(int carportArea) {
		this.carportArea = carportArea;
	}
	public int getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public int getToiletRooms() {
		return toiletRooms;
	}
	public void setToiletRooms(int toiletRooms) {
		this.toiletRooms = toiletRooms;
	}
	public int getExtraFixtures() {
		return extraFixtures;
	}
	public void setExtraFixtures(int extraFixtures) {
		this.extraFixtures = extraFixtures;
	}
	public int getWhirlpools() {
		return whirlpools;
	}
	public void setWhirlpools(int whirlpools) {
		this.whirlpools = whirlpools;
	}
	public int getHottubs() {
		return hottubs;
	}
	public void setHottubs(int hottubs) {
		this.hottubs = hottubs;
	}
	public int getSaunas() {
		return saunas;
	}
	public void setSaunas(int saunas) {
		this.saunas = saunas;
	}
	public int getFireplaces() {
		return fireplaces;
	}
	public void setFireplaces(int fireplaces) {
		this.fireplaces = fireplaces;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getFamilies() {
		return families;
	}
	public void setFamilies(int families) {
		this.families = families;
	}
	public int getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	public int getYearRemodel() {
		return yearRemodel;
	}
	public void setYearRemodel(int yearRemodel) {
		this.yearRemodel = yearRemodel;
	}
	public int getEffYearBuilt() {
		return effYearBuilt;
	}
	public void setEffYearBuilt(int effYearBuilt) {
		this.effYearBuilt = effYearBuilt;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getHeating() {
		return heating;
	}
	public void setHeating(String heating) {
		this.heating = heating;
	}
	public int getAirConditioning() {
		return airConditioning;
	}
	public void setAirConditioning(int airConditioning) {
		this.airConditioning = airConditioning;
	}
	public String getPercentComplete() {
		return percentComplete;
	}
	public void setPercentComplete(String percentComplete) {
		this.percentComplete = percentComplete;
	}
	public String getDetachedStructs() {
		return detachedStructs;
	}
	public void setDetachedStructs(String detachedStructs) {
		this.detachedStructs = detachedStructs;
	}
	public String getLnameTH1() {
		return lnameTH1;
	}
	public void setLnameTH1(String lnameTH1) {
		this.lnameTH1 = lnameTH1;
	}
	public String getFnameTH1() {
		return fnameTH1;
	}
	public void setFnameTH1(String fnameTH1) {
		this.fnameTH1 = fnameTH1;
	}
	public String getInitialTH1() {
		return initialTH1;
	}
	public void setInitialTH1(String initialTH1) {
		this.initialTH1 = initialTH1;
	}
	public java.sql.Timestamp getTransferTH1() {
		return transferTH1;
	}
	public void setTransferTH1(java.sql.Timestamp transferTH1) {
		this.transferTH1 = transferTH1;
	}
	public int getBookTH1() {
		return bookTH1;
	}
	public void setBookTH1(int bookTH1) {
		this.bookTH1 = bookTH1;
	}
	public int getPgTH1() {
		return pgTH1;
	}
	public void setPgTH1(int pgTH1) {
		this.pgTH1 = pgTH1;
	}
	public String getLnameTH2() {
		return lnameTH2;
	}
	public void setLnameTH2(String lnameTH2) {
		this.lnameTH2 = lnameTH2;
	}
	public String getFnameTH2() {
		return fnameTH2;
	}
	public void setFnameTH2(String fnameTH2) {
		this.fnameTH2 = fnameTH2;
	}
	public String getInitialTH2() {
		return initialTH2;
	}
	public void setInitialTH2(String initialTH2) {
		this.initialTH2 = initialTH2;
	}
	public String getLnameCB1() {
		return lnameCB1;
	}
	public void setLnameCB1(String lnameCB1) {
		this.lnameCB1 = lnameCB1;
	}
	public String getFnameCB1() {
		return fnameCB1;
	}
	public void setFnameCB1(String fnameCB1) {
		this.fnameCB1 = fnameCB1;
	}
	public String getInitialCB1() {
		return initialCB1;
	}
	public void setInitialCB1(String initialCB1) {
		this.initialCB1 = initialCB1;
	}
	public java.sql.Timestamp getTransferCB1() {
		return transferCB1;
	}
	public void setTransferCB1(java.sql.Timestamp transferCB1) {
		this.transferCB1 = transferCB1;
	}
	public int getBookCB1() {
		return bookCB1;
	}
	public void setBookCB1(int bookCB1) {
		this.bookCB1 = bookCB1;
	}
	public int getPgCB1() {
		return pgCB1;
	}
	public void setPgCB1(int pgCB1) {
		this.pgCB1 = pgCB1;
	}
	public String getLnameCB2() {
		return lnameCB2;
	}
	public void setLnameCB2(String lnameCB2) {
		this.lnameCB2 = lnameCB2;
	}
	public String getFnameCB2() {
		return fnameCB2;
	}
	public void setFnameCB2(String fnameCB2) {
		this.fnameCB2 = fnameCB2;
	}
	public String getInitialCB2() {
		return initialCB2;
	}
	public void setInitialCB2(String initialCB2) {
		this.initialCB2 = initialCB2;
	}
	public int getMailHouse() {
		return mailHouse;
	}
	public void setMailHouse(int mailHouse) {
		this.mailHouse = mailHouse;
	}
	public String getMailDir() {
		return mailDir;
	}
	public void setMailDir(String mailDir) {
		this.mailDir = mailDir;
	}
	public String getMailStreet() {
		return mailStreet;
	}
	public void setMailStreet(String mailStreet) {
		this.mailStreet = mailStreet;
	}
	public String getMailSuffix() {
		return mailSuffix;
	}
	public void setMailSuffix(String mailSuffix) {
		this.mailSuffix = mailSuffix;
	}
	public String getMailSuffixDir() {
		return mailSuffixDir;
	}
	public void setMailSuffixDir(String mailSuffixDir) {
		this.mailSuffixDir = mailSuffixDir;
	}
	public String getMailUnitType() {
		return mailUnitType;
	}
	public void setMailUnitType(String mailUnitType) {
		this.mailUnitType = mailUnitType;
	}
	public String getMailUnitNumber() {
		return mailUnitNumber;
	}
	public void setMailUnitNumber(String mailUnitNumber) {
		this.mailUnitNumber = mailUnitNumber;
	}
	public String getMailCity() {
		return mailCity;
	}
	public void setMailCity(String mailCity) {
		this.mailCity = mailCity;
	}
	public String getMailState() {
		return mailState;
	}
	public void setMailState(String mailState) {
		this.mailState = mailState;
	}
	public String getMailZip() {
		return mailZip;
	}
	public void setMailZip(String mailZip) {
		this.mailZip = mailZip;
	}
	public String getMailZip4() {
		return mailZip4;
	}
	public void setMailZip4(String mailZip4) {
		this.mailZip4 = mailZip4;
	}
	public String getMailZip2() {
		return mailZip2;
	}
	public void setMailZip2(String mailZip2) {
		this.mailZip2 = mailZip2;
	}
	public String getMailCounty() {
		return mailCounty;
	}
	public void setMailCounty(String mailCounty) {
		this.mailCounty = mailCounty;
	}
	public String getMailLname() {
		return mailLname;
	}
	public void setMailLname(String mailLname) {
		this.mailLname = mailLname;
	}
	public String getMailFname() {
		return mailFname;
	}
	public void setMailFname(String mailFname) {
		this.mailFname = mailFname;
	}
	public String getMailInitial() {
		return mailInitial;
	}
	public void setMailInitial(String mailInitial) {
		this.mailInitial = mailInitial;
	}
	public String getMailBusiness() {
		return mailBusiness;
	}
	public void setMailBusiness(String mailBusiness) {
		this.mailBusiness = mailBusiness;
	}
	public java.math.BigDecimal getRevenueStamps() {
		return revenueStamps;
	}
	public void setRevenueStamps(java.math.BigDecimal revenueStamps) {
		this.revenueStamps = revenueStamps;
	}
	public java.math.BigDecimal getxCoord() {
		return xCoord;
	}
	public void setxCoord(java.math.BigDecimal xCoord) {
		this.xCoord = xCoord;
	}
	public java.math.BigDecimal getyCoord() {
		return yCoord;
	}
	public void setyCoord(java.math.BigDecimal yCoord) {
		this.yCoord = yCoord;
	}
	public int getTif() {
		return tif;
	}
	public void setTif(int tif) {
		this.tif = tif;
	}
	public String getTifDescr() {
		return tifDescr;
	}
	public void setTifDescr(String tifDescr) {
		this.tifDescr = tifDescr;
	}
	public String getCondoUnitAddress() {
		return condoUnitAddress;
	}
	public void setCondoUnitAddress(String condoUnitAddress) {
		this.condoUnitAddress = condoUnitAddress;
	}
	public String getCondoFinLivArea() {
		return condoFinLivArea;
	}
	public void setCondoFinLivArea(String condoFinLivArea) {
		this.condoFinLivArea = condoFinLivArea;
	}
	public String getCondoYearBuilt() {
		return condoYearBuilt;
	}
	public void setCondoYearBuilt(String condoYearBuilt) {
		this.condoYearBuilt = condoYearBuilt;
	}
	public String getPlatname() {
		return platname;
	}
	public void setPlatname(String platname) {
		this.platname = platname;
	}
	public String getSchoolDistrict() {
		return schoolDistrict;
	}
	public void setSchoolDistrict(String schoolDistrict) {
		this.schoolDistrict = schoolDistrict;
	}
	public double getFrontage() {
		return frontage;
	}
	public void setFrontage(double frontage) {
		this.frontage = frontage;
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(double depth) {
		this.depth = depth;
	}
	public int getFinBsmtArea1() {
		return finBsmtArea1;
	}
	public void setFinBsmtArea1(int finBsmtArea1) {
		this.finBsmtArea1 = finBsmtArea1;
	}
	public String getFinBsmtQual1() {
		return finBsmtQual1;
	}
	public void setFinBsmtQual1(String finBsmtQual1) {
		this.finBsmtQual1 = finBsmtQual1;
	}
	public int getFinBsmtArea2() {
		return finBsmtArea2;
	}
	public void setFinBsmtArea2(int finBsmtArea2) {
		this.finBsmtArea2 = finBsmtArea2;
	}
	public int getFinBsmtQual2() {
		return finBsmtQual2;
	}
	public void setFinBsmtQual2(int finBsmtQual2) {
		this.finBsmtQual2 = finBsmtQual2;
	}
}
