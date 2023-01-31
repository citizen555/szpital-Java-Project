import java.sql.Date;

public class DoctorsDataTable extends DoctorsPanel {

    private int idDoctor, salary;
    private String firstName, surname,  birthPlace, adress, postcode, city, phoneNumber, email, pesel;
    private Date birthDate;


    public DoctorsDataTable(int idDoctor, String firstName, String surname, Date birthDate, String birthPlace, String pesel, String adress, String postcode, String city, String phoneNumber, String email, int salary){

        this.idDoctor=idDoctor;
        this.firstName =firstName;
        this.surname=surname;
        this.birthDate=birthDate;
        this.birthPlace=birthPlace;
        this.pesel=pesel;
        this.adress=adress;
        this.postcode=postcode;
        this.city=city;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.salary=salary;

    }


    public int getIdDoctor() {
        return idDoctor;
    }

    public String getPesel() {
        return pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getAdress() {
        return adress;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }
}
