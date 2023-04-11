package omakHospital;

import omakHospital.doctor.Doctor;
import omakHospital.patient.Patient;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppConstant {
    public static final String FILE_NAME = "omakHospital.doctor.txt";
    public static final File FILE = new File(FILE_NAME);
    public static List<Doctor> DOCTOR_LIST = new ArrayList<>();
    public static final String FILE_NAME2 = "omakHospital.patient.txt";
    public static final File PATIENTFILE = new File(FILE_NAME2);
    public static List<Patient> PATIENT_LIST = new ArrayList<>();
}
