package omakHospital.doctor;

import omakHospital.Gender;
import omakHospital.Person;

public class Doctor extends Person {
    private int doctorId;
    private String department;
    private boolean isDeleted = false;

    public Doctor(int doctorId, String firstName, String lastName, int age, String address, Gender gender, String department) {
        super(firstName, lastName, age, address, gender);
        this.doctorId = doctorId;
        this.department = department;
    }
    public boolean isDeleted() {return isDeleted;}

    public int getDoctorId() {return doctorId;}

    public void setDoctorId(int doctorId) {this.doctorId = doctorId;}

    public String getDepartment() {return department;}

    public void setDepartment(String department) {this.department = department;}

    public String getMessageDetails(){
        return doctorId +  "," + super.getFirstName() + "," + super.getLastName() + "," + super.getAge()
                + "," + super.getAddress() + "," + super.getGender() + "," + department;};


    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
    
}

