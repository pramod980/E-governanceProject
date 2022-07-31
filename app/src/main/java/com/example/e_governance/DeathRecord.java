package com.example.e_governance;

public class DeathRecord {
    public String Name_Devanagari;
    public String Name_english;
    public String Date_of_Birth;
    public String Date_of_Demise;
    public  String Birth_Registration_Number;
    public String Birth_District;
    public String Birth_VDC;
    public String Birth_ward;
    public String Demise_District;
    public String Demise_VDC;
    public String Demise_Ward;
    public String Citizenship_Number;
    public String Issue_District;
    public String Issue_date;
    public String Mother_name;
    public String Father_name;
    public String GrandFather_name;

    public DeathRecord(String name_Devanagari, String name_english, String date_of_Birth, String date_of_Demise, String birth_Registration_Number, String birth_District, String birth_VDC, String birth_ward, String demise_District, String demise_VDC, String demise_Ward, String citizenship_Number, String issue_District, String issue_date, String mother_name, String father_name, String grandFather_name) {
        Name_Devanagari = name_Devanagari;
        Name_english = name_english;
        Date_of_Birth = date_of_Birth;
        Date_of_Demise = date_of_Demise;
        Birth_Registration_Number = birth_Registration_Number;
        Birth_District = birth_District;
        Birth_VDC = birth_VDC;
        Birth_ward = birth_ward;
        Demise_District = demise_District;
        Demise_VDC = demise_VDC;
        Demise_Ward = demise_Ward;
        Citizenship_Number = citizenship_Number;
        Issue_District = issue_District;
        Issue_date = issue_date;
        Mother_name = mother_name;
        Father_name = father_name;
        GrandFather_name = grandFather_name;
    }
}
