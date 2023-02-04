import java.sql.Date;

public class DoctorsDataTable extends DoctorsPanel {

    public int idDoctor, salary;
    public String firstName, surname,  birthPlace, adres, postcode, city, phoneNumber, email, pesel, birthDate;

    public DoctorsDataTable(int idDoctor, String firstName, String surname, String birthDate, String birthPlace, String pesel, String adres, String postcode, String city, String phoneNumber, String email, int salary){

        this.idDoctor=idDoctor;
        this.firstName =firstName;
        this.surname=surname;
        this.birthDate=birthDate;
        this.birthPlace=birthPlace;
        this.pesel=pesel;
        this.adres=adres;
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

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getAdres() {
        return adres;
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
