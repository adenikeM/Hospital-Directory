package omakHospital;

import static omakHospital.doctor.Utils.*;
import static omakHospital.Message.selectOperation;
import static omakHospital.patient.PatientUtils.*;

public class Console {
    public static void main(String[] args) {
        if (AppConstant.FILE.exists()) {
            getDoctorsFromFile();
        }
        Message.displayWelcomeMessage();
        int Operation = Message.selectOperation();
        while (Operation != 6) {
            if (Operation == 1) {
                getDoctorFromUser();
                saveToFile();
            } else if (Operation == 2) {
                if (AppConstant.PATIENTFILE.exists()) {
                    getPatientsFromFile();
                }
                getPatientFromUser();
                saveToPatientFile();
            } else if (Operation == 3){
                viewDoctors();
            } else if (Operation == 4){
                viewPatients();
            }else if (Operation == 5){
               deletePatientByID();
            }
            Operation = selectOperation();
        }
    }
}
