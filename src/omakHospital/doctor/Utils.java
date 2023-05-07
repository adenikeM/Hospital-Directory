package omakHospital.doctor;

import omakHospital.AppConstant;
import omakHospital.Gender;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static omakHospital.AppConstant.DOCTOR_LIST;
import static omakHospital.AppConstant.FILE;
import static omakHospital.base.GetString.getString;

public class Utils {

    private static final Object SPLIT_PATTERN =";\n";

    public static void getDoctorsFromFile() {
        String stringFromFile = readFromFile();
        if(!stringFromFile.isEmpty()){
            String[] split = stringFromFile.split((String) SPLIT_PATTERN);
            for(String doctorString : split){
                String[] doctorStringSplits = doctorString.split(",");
                int doctorID = Integer.parseInt(doctorStringSplits[0]);
                String firstName = doctorStringSplits[1];
                String lastName = doctorStringSplits[2];
                int age = Integer.parseInt(doctorStringSplits[3]);
                String address = doctorStringSplits[4];
                String genderString = doctorStringSplits[5];
                Gender gender = Gender.valueOf(genderString.toUpperCase());
                String department = doctorStringSplits[6];
                Doctor doctor = new Doctor(doctorID,firstName,lastName,age,
                        address, gender,department);
                DOCTOR_LIST.add(doctor);
            }
        }
    }
    public static void getDoctorFromUser() {
        do {
            System.out.println("Enter your details First Name, Last Name, Age, Address, Gender, Department or -1 to stop");
            Scanner scanner = new Scanner(System.in);
            String doctorString = scanner.nextLine().trim();
            if(doctorString.equals("-1")){
                return;
            }
            String[] split = doctorString.split(",");
            Doctor doctor = new Doctor(DOCTOR_LIST.size() + 1, split[0], String.valueOf(split[1]),Integer.parseInt(split[2]),String.valueOf(split[3]),
                    Gender.valueOf(split[4]),String.valueOf(split[5]));
            DOCTOR_LIST.add(doctor);
        }while(true);
    }

    public static void saveToFile() {
        try(
                FileWriter fileWriter = new FileWriter(AppConstant.FILE)){
           for(Doctor doctor : DOCTOR_LIST) {
               System.out.println(doctor.getMessageDetails());
               String message = doctor.getMessageDetails() + SPLIT_PATTERN;
               fileWriter.write(message);
               fileWriter.flush();
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }
        private  static String readFromFile(){
                if (!FILE.exists()) {
                    return "";
                }
            return getString();
        }
        public static void viewDoctors(){
            if (!DOCTOR_LIST.isEmpty()) {
                String dashes = "_______________________________________________________________________________________________________";
                String header = "LIST OF DOCTOR AT OMAK HOSPITAL";
                System.out.printf("%s%n%50s%n%s%n", dashes, header, dashes);
                System.out.printf("| %-4s | %-20s | %-20S | %-5s | %-10s | %-10s | %-15s |%n %s %n", "ID", "FIRST NAME", " LAST NAME","AGE","ADDRESS", "GENDER", "DEPARTMENT", dashes);

                for (Doctor doctor : DOCTOR_LIST) {
                    if (!doctor.isDeleted()) {
                        System.out.printf("| %-4s | %-20s | %-20S | %-5s | %-10s | %-10s | %-15s | %n", doctor.getDoctorId(), doctor.getFirstName(), doctor.getLastName(),doctor.getAge(),doctor.getAddress(), doctor.getGender(), doctor.getDepartment());
                    }
                }
                System.out.println(dashes);
            } else {
                System.out.println("No doctor record");
            }
        }


}


