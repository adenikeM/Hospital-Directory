package omakHospital.patient;

import omakHospital.Gender;
import omakHospital.InvalidPatientIdException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static omakHospital.AppConstant.*;
import static omakHospital.Message.collectIntegerInput;
import static omakHospital.base.GetString.getString;

public class PatientUtils {
    private static final Object SPLIT_PATTERN = ";\n";
    public static void getPatientFromUser() {
        do {
            System.out.println("Enter your details First Name, Last Name, Age, Address, Gender or -1 to stop");
            Scanner scanner = new Scanner(System.in);
            String patientString = scanner.nextLine().trim();
            if (patientString.equals("-1")) {
                return;
            }
            String[] split = patientString.split(",");
            Patient patient = new Patient(PATIENT_LIST.size() + 1, split[0], String.valueOf(split[1]), Integer.parseInt(split[2]), String.valueOf(split[3]),
                    Gender.valueOf(split[4]));
            PATIENT_LIST.add(patient);
        } while (true);
    }

    public static void saveToPatientFile() {
        try(
                FileWriter fileWriter = new FileWriter(PATIENTFILE)){
            for(Patient patient : PATIENT_LIST) {
                System.out.println(patient.getMessageDetails());
                String message = patient.getMessageDetails() + SPLIT_PATTERN;
                fileWriter.write(message);
                fileWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getPatientsFromFile() {
        String stringFromFile = readFromFile();
        if (!stringFromFile.isEmpty()) {
            String[] split = stringFromFile.split((String) SPLIT_PATTERN);
            for (String patientString : split) {
                String[] patientStringSplits = patientString.split(",");
                Patient patient = new Patient(Integer.parseInt(patientStringSplits[0]), patientStringSplits[1], patientStringSplits[2], Integer.parseInt(patientStringSplits[3]),
                        patientStringSplits[4], Gender.valueOf(patientStringSplits[5].toUpperCase()));
                PATIENT_LIST.add(patient);
            }
        }
    }
    private static String readFromFile() {
        if (!PATIENTFILE.exists()) {
            return "";
        }
        return getString();
    }
    public static void viewPatients(){
        if (!PATIENT_LIST.isEmpty()) {
            String dashes = "________________________________________________________________________________________";
            String header = "LIST OF PATIENT AT OMAK HOSPITAL";
            System.out.printf("%s%n%60s%n%s%n", dashes, header,dashes);
            System.out.printf("| %-4s | %-20s | %-20S | %-5s | %-10s | %-10s | %n %s %n", "ID", "FIRST NAME", " LAST NAME","AGE","ADDRESS", "GENDER", dashes);

            for (Patient patient : PATIENT_LIST) {
                if (!patient.isDeleted()) {
                    System.out.printf("| %-4s | %-20s | %-20S | %-5s | %-10s | %-10s | %n", patient.getPatientId(), patient.getFirstName(), patient.getLastName(),patient.getAge(),patient.getAddress(), patient.getGender());
                }
            }
            System.out.println(dashes);
        } else {
            System.out.println("No patient record");
        }
    }
    public static void deletePatientByID(){
        viewPatients();
        int patientId = collectIntegerInput("Enter patient ID you want to delete");
        Patient patient = getPatient(patientId);
        patient.delete();
        saveToPatientFile();
        System.out.println("Patient with ID" + patientId + "is deleted");
    }
    private static Patient getPatient(int patientId) {
        if (patientId < 1 || patientId > PATIENT_LIST.size()) {
            try {
                throw new InvalidPatientIdException(String.format("patient with id %d is invalid", patientId));
            } catch (InvalidPatientIdException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        return PATIENT_LIST.get(patientId-1);
    }
    }


