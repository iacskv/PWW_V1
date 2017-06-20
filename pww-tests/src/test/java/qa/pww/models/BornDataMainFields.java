package qa.pww.models;

/**
 * Created by k.smotrov on 02.06.2017.
 */
public class BornDataMainFields {
    //поля данных об а/з
    public String agsNum;
    public String liter;
    public String agsDd;
    public String agsMm;
    public String agsYyyy;
    public String agsDate;
    public String zagsAgsName;
    public String agsCopy;

    //поля сведения о ребенке (1-8)
    public String childSex;
    public String childLastName;
    public String childFirstName;
    public String childMiddleName;
    public String childDdBorn;
    public String childMmBorn;
    public String childYyyyBorn;
    public String childDateBorn;
    public String childCountryNoClass;
    public String childRegionNoClass;
    public String childCountry;
    public String childRegion;
    public String childDisnrict;
    public String childTown;
    public String childPunkt;
    public String childBirthCond;

    //основание восстановления а/з (10)
    public String vosstDd;
    public String vosstMm;
    public String vosstYyyy;
    public String vosstDate;
    public String vosstOrg;

    //сведения об отце (11-17)
    public String fatherLastName;
    public String fatherFirstName;
    public String fatherMiddleName;
    public String fatherDdBorn;
    public String fatherMmBorn;
    public String fatherYyyyBorn;
    public String fatherDateBorn;
    public String fatherCountryNoClass;
    public String fatherRegionNoClass;
    public String fatherCountry;
    public String fatherRegion;
    public String fatherDistrict;
    public String fatherTown;
    public String fatherPunkt;
    public String fatherCitizenshipNoClass;
    public String fatherCitizenship;
    public String fatherNationalNoClass;
    public String fatherNational;

    //сведения о матери (11-17)
    public String matherLastName;
    public String matherFirstName;
    public String matherMiddleName;
    public String matherDdBorn;
    public String matherMmBorn;
    public String matherYyyyBorn;
    public String matherDateBorn;
    public String matherCountryNoClass;
    public String matherRegionNoClass;
    public String matherCountry;
    public String matherRegion;
    public String matherDistrict;
    public String matherTown;
    public String matherPunkt;
    public String matherCitizenshipNoClass;
    public String matherCitizenship;
    public String matherNationalNoClass;
    public String matherNational;


    //основание сведений об отце (19)

    public String baseTypeDoc;
    public String baseNumDoc;
    public String baseDdDoc;
    public String baseMmDoc;
    public String baseYyyyDoc;
    public String baseDateDoc;
    public String baseOrgDoc;

    //выдано свидетельство (21)

    public String certSeria;
    public String certNum;
    public String certDd;
    public String certMm;
    public String certYyyy;
    public String certDate;

    //есть Изменения?
    public String moreStage;


    public BornDataMainFields() {

    }
}
