package omakHospital.patient;

import omakHospital.Gender;
import omakHospital.Person;

public class Patient extends Person {
    private int patientId;
    private boolean isDeleted = false;

    public Patient(int patientId, String firstName, String lastName, int age, String address, Gender gender) {
        super(firstName,lastName,age,address,gender);
        this.patientId = patientId;
    }
    public boolean isDeleted() { return isDeleted;}
    public int getPatientId() {return patientId;}

    public void setPatientId(int patientId) {this.patientId = patientId;}

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                '}';
    }

    public String getMessageDetails() {
        return patientId + "," +super.getFirstName() + "," + super.getLastName() + "," + super.getAge()
                + "," + super.getAddress() + "," + super.getGender();};

    public void delete() {
        this.isDeleted = true;
    }


}

