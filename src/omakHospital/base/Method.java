package omakHospital.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static omakHospital.AppConstant.FILE;

public class Method {
    public static String getString() {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(FILE)) {
            int i;
            while ((i = fileReader.read()) != -1) {
                sb.append((char) i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    public static int collectIntegerInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }
   }


