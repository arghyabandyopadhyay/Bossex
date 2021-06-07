package BusinessGenie.app.Bossex.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeesTemplate {
    private final IntegerProperty Employee_ID_Number = new SimpleIntegerProperty(this, "Employee_ID_Number");
    private final StringProperty Personal_ID_Number = new SimpleStringProperty(this, "Personal_ID_Number");
    private final StringProperty First_Name = new SimpleStringProperty(this, "First_Name");
    private final StringProperty Middle_Name = new SimpleStringProperty(this, "Middle_Name");
    private final StringProperty Last_Name = new SimpleStringProperty(this, "Last_Name");
    private final StringProperty Date_of_Birth = new SimpleStringProperty(this, "Date_of_Birth");
    private final StringProperty Mobile = new SimpleStringProperty(this, "Mobile");
    private final StringProperty Alternate_Mobile = new SimpleStringProperty(this, "Alternate_Mobile");
    private final StringProperty City = new SimpleStringProperty(this, "City");
    private final StringProperty Address = new SimpleStringProperty(this, "Address");
    private final StringProperty Postal_Code = new SimpleStringProperty(this, "Postal_Code");
    private final StringProperty Qualification = new SimpleStringProperty(this, "Qualification");
    private final StringProperty Current_Experience = new SimpleStringProperty(this, "Current_Experience");
    private final StringProperty Start_Date = new SimpleStringProperty(this, "Start_Date");
    private final StringProperty End_Date = new SimpleStringProperty(this, "End_Date");
    private final StringProperty Type_Employee = new SimpleStringProperty(this, "Type_Employee");
    private final StringProperty Designation_Id = new SimpleStringProperty(this, "Designation_Id");

    public IntegerProperty Employee_ID_NumberProperty() {
        return Employee_ID_Number ;
    }
    public StringProperty Personal_ID_NumberProperty() {
        return Personal_ID_Number ;
    }
    public StringProperty First_NameProperty() {
        return First_Name ;
    }
    public StringProperty Middle_NameProperty() {
        return Middle_Name ;
    }
    public StringProperty Last_NameProperty() {
        return Last_Name ;
    }
    public StringProperty Date_of_BirthProperty() {
        return Date_of_Birth ;
    }

    public StringProperty MobileProperty() {
        return Mobile ;
    }
    public StringProperty Alternate_MobileProperty() {
        return Alternate_Mobile ;
    }
    public StringProperty CityProperty() {
        return City ;
    }
    public StringProperty AddressProperty() {
        return Address ;
    }
    public StringProperty Postal_CodeProperty() {
        return Postal_Code ;
    }
    public StringProperty QualificationProperty() {
        return Qualification ;
    }
    public StringProperty Current_ExperienceProperty() {
        return Current_Experience ;
    }
    public StringProperty Start_DateProperty() {
        return Start_Date ;
    }
    public StringProperty End_DateProperty() {
        return End_Date ;
    }
    public StringProperty Type_EmployeeProperty() {
        return Type_Employee ;
    }
    public StringProperty Designation_IdProperty() {
        return Designation_Id ;
    }



    public final int getEmployee_ID_Number() {return Employee_ID_NumberProperty().get();}
    public final String getLast_Name() {
        return Last_NameProperty().get();
    }
    public final String getMiddle_Name() {
        return Middle_NameProperty().get();
    }
    public final String getFirst_Name() {
        return First_NameProperty().get();
    }
    public final String getPersonal_ID_Number() {
        return Personal_ID_NumberProperty().get();
    }
    public final String getDate_of_Birth() {
        return Date_of_BirthProperty().get();
    }
    public final String getMobile() {
        return MobileProperty().get();
    }
    public final String getAlternate_Mobile() {
        return Alternate_MobileProperty().get();
    }
    public final String getCity() {
        return CityProperty().get();
    }
    public final String getAddress() {
        return AddressProperty().get();
    }
    public final String getPostal_Code() {
        return Postal_CodeProperty().get();
    }
    public final String getQualification() {
        return QualificationProperty().get();
    }
    public final String getCurrent_Experience() {
        return Current_ExperienceProperty().get();
    }
    public final String getStart_Date() {
        return Start_DateProperty().get();
    }
    public final String getEnd_Date() {
        return End_DateProperty().get();
    }
    public final String getType_Employee() {
        return Type_EmployeeProperty().get();
    }
    public final String getDesignation_Id() {
        return Designation_IdProperty().get();
    }


    public final void setEmployee_ID_Number(int Employee_ID_Number) {
        Employee_ID_NumberProperty().set(Employee_ID_Number);
    }
    public final void setPersonal_ID_Number(String Personal_ID_Number) {
        Personal_ID_NumberProperty().set(Personal_ID_Number);
    }
    public final void setFirst_Name(String First_Name) {
        First_NameProperty().set(First_Name);
    }
    public final void setMiddle_Name(String Middle_Name) {Middle_NameProperty().set(Middle_Name);}
    public final void setLast_Name(String Last_Name) {
        Last_NameProperty().set(Last_Name);
    }
    public final void setDate_of_Birth(String Date_of_Birth) {
        Date_of_BirthProperty().set(Date_of_Birth);
    }
    public final void setMobile(String Mobile) {
        MobileProperty().set(Mobile);
    }
    public final void setAlternate_Mobile(String Alternate_Mobile) {
        Alternate_MobileProperty().set(Alternate_Mobile);
    }
    public final void setCity(String City) {
        CityProperty().set(City);
    }
    public final void setAddress(String Address) {
        AddressProperty().set(Address);
    }
    public final void setPostal_Code(String Postal_Code) {
        Postal_CodeProperty().set(Postal_Code);
    }
    public final void setQualification(String Qualification) {
        QualificationProperty().set(Qualification);
    }
    public final void setCurrent_Experience(String Current_Experience) {
        Current_ExperienceProperty().set(Current_Experience);
    }
    public final void setStart_Date(String Start_Date) {
        Start_DateProperty().set(Start_Date);
    }
    public final void setEnd_Date(String End_Date) {
        End_DateProperty().set(End_Date);
    }
    public final void setType_Employee(String Type_Employee) {
        Type_EmployeeProperty().set(Type_Employee);
    }
    public final void setDesignation_Id(String Designation_Id) {
        Designation_IdProperty().set(Designation_Id);
    }


    public EmployeesTemplate(int Employee_ID_Number, String Personal_ID_Number, String First_Name, String Middle_Name, String Last_Name, String Date_of_Birth, String Mobile, String Alternate_Mobile, String City , String Address, String Postal_Code, String Qualification, String Current_Experience, String Start_Date, String End_Date, String Type_Employee, String Designation_Id) {
        setEmployee_ID_Number(Employee_ID_Number);
        setPersonal_ID_Number(Personal_ID_Number);
        setFirst_Name(First_Name);
        setMiddle_Name(Middle_Name);
        setLast_Name(Last_Name);
        setDate_of_Birth(Date_of_Birth);
        setMobile(Mobile);
        setAlternate_Mobile(Alternate_Mobile);
        setCity(City);
        setAddress(Address);
        setPostal_Code(Postal_Code);
        setQualification(Qualification);
        setCurrent_Experience(Current_Experience);
        setStart_Date(Start_Date);
        setEnd_Date(End_Date);
        setType_Employee(Type_Employee);
        setDesignation_Id(Designation_Id);
    }

}
