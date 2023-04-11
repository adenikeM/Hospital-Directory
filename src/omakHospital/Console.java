package omakHospital;

import static omakHospital.doctor.Utils.*;
import static omakHospital.message.displayWelcomeMessage;
import static omakHospital.message.selectOperation;
import static omakHospital.patient.PatientUtils.*;

public class Console {
    public static void main(String[] args) {
        if (AppConstant.FILE.exists()) {
            getDoctorFromFile();
        }
        displayWelcomeMessage();
        int Operation = selectOperation();
        while (Operation != 6) {
            if (Operation == 1) {
                getDoctorFromUser();
                saveToFile();
            } else if (Operation == 2) {
                if (AppConstant.PATIENTFILE.exists()) {
                    getPatientFromFile();
                }
                getPatientFromUser();
                saveToPatientFile();
            } else if (Operation == 3){
                viewDoctor();
            } else if (Operation == 4){
                viewPatient();
            }else if (Operation == 5){
               deletePatientByID();
            }
            Operation = selectOperation();
        }
    }
}
