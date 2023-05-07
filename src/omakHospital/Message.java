package omakHospital;

import java.util.Scanner;

public class Message {
    public static void displayWelcomeMessage() {
        System.out.println("Welcome to OMAK HOSPITAL");
        System.out.println("MOTTO: ALLAH'S HEAL");
    }

    public static int selectOperation() {
        return selectOperation("Press 1 to create a new Doctor\nPress 2 to create a Patient\nPress 3 to view Doctor\nPress 4 to view Patient\nPress 5 to discharge Patients by ID\nPress 6 to leave " +
                "application");
    }

    private static int selectOperation(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static int collectIntegerInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }

}
