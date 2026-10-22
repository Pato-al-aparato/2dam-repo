package ExProccesBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Scanner;

public class SumaNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextDouble()) {
            System.out.println("Error: introduce un número.");
            return;
        }
        double num1 = sc.nextDouble();

        if (!sc.hasNextDouble()) {
            System.out.println("Error: introduce un número.");
            return;
        }
        double num2 = sc.nextDouble();

        System.out.println("Suma: " + (num1 + num2));
    }
}
