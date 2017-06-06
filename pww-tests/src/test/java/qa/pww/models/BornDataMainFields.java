package qa.pww.models;

/**
 * Created by k.smotrov on 02.06.2017.
 */
public class BornDataMainFields {
    //поля данных об а/з
    String agsNum;
    String liter;
    String agsDd;
    String agsmm;
    String agsYyyy;
    String zagsAgsName;
    String agsCopy;

    //поля сведения о ребенке (1-8)
    String childSex;
    String childLastName;
    String childFirstName;
    String childMiddleName;
    String childDdBorn;
    String childMmBorn;
    String childYyyyBorn;
    String childCountryNoClass;
    String childRegionNoClass;
    String childCountry;
    String childRegion;
    String childDisnrict;
    String childPunkt;
    String childBirthCond;

    //основание восстановления а/з (10)
    String vosstDd;
    String vosstMm;
    String vosstYyyy;
    String vosstOrg;

    //сведения об отце (11-17)
    String fatherLastName;
    String fatherFirstName;
    String fatherMiddleName;
    String fatherDdBorn;
    String fatherMmBorn;
    String fatherYyyyBorn;
    String fatherCountryNoClass;
    String fatherRegionNoClass;
    String fatherCountry;
    String fatherRegion;
    String fatherDistrict;
    String fatherPunkt;
    String fatherCitizenshipNoClass;
    String fatherCitizenship;
    String fatherNationalNoClass;
    String fatherNational;

    //сведения о матери (11-17)
    String matherLastName;
    String matherFirstName;
    String matherMiddleName;
    String matherDdBorn;
    String matherMmBorn;
    String matherYyyyBorn;
    String matherCountryNoClass;
    String matherRegionNoClass;
    String matherCountry;
    String matherRegion;
    String matherDistrict;
    String matherPunkt;
    String matherCitizenshipNoClass;
    String matherCitizenship;
    String matherNationalNoClass;
    String matherNational;

    //основание сведений об отце (19)

    String baseTypeDoc;
    String baseNumDoc;
    String baseDdDoc;
    String baseMmDoc;
    String baseYyyyDoc;

    //выдано свидетельство (21)

    String certSeria;
    String certNum;
    String certDd;
    String certMm;
    String certYyyy;

    //есть Изменения?
    String moreStage;


    public BornDataMainFields(String agsNum, String liter, String agsDd, String agsmm, String agsYyyy, String zagsAgsName, String agsCopy,
                              String childSex, String childLastName, String childFirstName, String childMiddleName, String childDdBorn, String childMmBorn, String childYyyyBorn,
                              String childCountryNoClass, String childRegionNoClass, String childCountry, String childRegion, String childDisnrict, String childPunkt, String childBirthCond,
                              String vosstDd, String vosstMm, String vosstYyyy, String vosstOrg,
                              String fatherLastName, String fatherFirstName, String fatherMiddleName, String fatherDdBorn, String fatherMmBorn, String fatherYyyyBorn,
                              String fatherCountryNoClass, String fatherRegionNoClass, String fatherCountry, String fatherRegion, String fatherDistrict, String fatherPunkt, String fatherCitizenshipNoClass, String fatherCitizenship, String fatherNationalNoClass, String fatherNational,
                              String matherLastName, String matherFirstName, String matherMiddleName, String matherDdBorn, String matherMmBorn, String matherYyyyBorn,
                              String matherCountryNoClass, String matherRegionNoClass, String matherCountry, String matherRegion, String matherDistrict, String matherPunkt, String matherCitizenshipNoClass, String matherCitizenship, String matherNationalNoClass, String matherNational,
                              String baseTypeDoc, String baseNumDoc, String baseDdDoc, String baseMmDoc, String baseYyyyDoc,
                              String certSeria, String certNum, String certDd, String certMm, String certYyyy, String moreStage) {
        this.agsNum = agsNum;
        this.liter = liter;
        this.agsDd = agsDd;
        this.agsmm = agsmm;
        this.agsYyyy = agsYyyy;
        this.zagsAgsName = zagsAgsName;
        this.agsCopy = agsCopy;

        this.childSex = childSex;
        this.childLastName = childLastName;
        this.childFirstName = childFirstName;
        this.childMiddleName = childMiddleName;
        this.childDdBorn = childDdBorn;
        this.childMmBorn = childMmBorn;
        this.childYyyyBorn = childYyyyBorn;
        this.childCountryNoClass = childCountryNoClass;
        this.childRegionNoClass = childRegionNoClass;
        this.childCountry = childCountry;
        this.childRegion = childRegion;
        this.childDisnrict = childDisnrict;
        this.childPunkt = childPunkt;
        this.childBirthCond = childBirthCond;

        this.vosstDd = vosstDd;
        this.vosstMm = vosstMm;
        this.vosstYyyy = vosstYyyy;
        this.vosstOrg = vosstOrg;

        this.fatherLastName = fatherLastName;
        this.fatherFirstName = fatherFirstName;
        this.fatherMiddleName = fatherMiddleName;
        this.fatherDdBorn = fatherDdBorn;
        this.fatherMmBorn = fatherMmBorn;
        this.fatherYyyyBorn = fatherYyyyBorn;
        this.fatherCountryNoClass = fatherCountryNoClass;
        this.fatherRegionNoClass = fatherRegionNoClass;
        this.fatherCountry = fatherCountry;
        this.fatherRegion = fatherRegion;
        this.fatherDistrict = fatherDistrict;
        this.fatherPunkt = fatherPunkt;
        this.fatherCitizenshipNoClass = fatherCitizenshipNoClass;
        this.fatherCitizenship = fatherCitizenship;
        this.fatherNationalNoClass = fatherNationalNoClass;
        this.fatherNational = fatherNational;

        this.matherLastName = matherLastName;
        this.matherFirstName = matherFirstName;
        this.matherMiddleName = matherMiddleName;
        this.matherDdBorn = matherDdBorn;
        this.matherMmBorn = matherMmBorn;
        this.matherYyyyBorn = matherYyyyBorn;
        this.matherCountryNoClass = matherCountryNoClass;
        this.matherRegionNoClass = matherRegionNoClass;
        this.matherCountry = matherCountry;
        this.matherRegion = matherRegion;
        this.matherDistrict = matherDistrict;
        this.matherPunkt = matherPunkt;
        this.matherCitizenshipNoClass = matherCitizenshipNoClass;
        this.matherCitizenship = matherCitizenship;
        this.matherNationalNoClass = matherNationalNoClass;
        this.matherNational = matherNational;

        this.baseTypeDoc = baseTypeDoc;
        this.baseNumDoc = baseNumDoc;
        this.baseDdDoc = baseDdDoc;
        this.baseMmDoc = baseMmDoc;
        this.baseYyyyDoc = baseYyyyDoc;

        this.certSeria = certSeria;
        this.certNum = certNum;
        this.certDd = certDd;
        this.certMm = certMm;
        this.certYyyy = certYyyy;
        this.moreStage = moreStage;
    }
}
