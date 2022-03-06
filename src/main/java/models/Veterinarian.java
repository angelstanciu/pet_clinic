package models;

public class Veterinarian {
    private String firstName;
    private String lastName;
    private String address;
    private String speciality;

    public Veterinarian(String firstName, String lastName, String address, String speciality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.speciality = speciality;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "models.Veterinarian{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", speciality=" + speciality +
                '}';
    }
}
