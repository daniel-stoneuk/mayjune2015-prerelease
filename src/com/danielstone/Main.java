package com.danielstone;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static final int days = 30;
    public static final int recordsPerDay = 2;


    public static final double VALIDATION_MIN_TEMP = -10d;
    public static final double VALIDATION_MAX_TEMP = 40d;

    public static final double VALIDATION_ERROR_RESULT = 9999d;

    public static void main(String[] args) {


        double[] middayTemperatures = new double[days];
        double[] midnightTemperatures = new double[days];

        System.out.println("Data Logger");

        Scanner in = new Scanner(System.in);


        for (int i = 0; i < days; i++) {
            double middayTemperature = VALIDATION_ERROR_RESULT;
            while (middayTemperature == VALIDATION_ERROR_RESULT) {
                System.out.println("Day " + (i + 1) + " midday temperature: ");
//                middayTemperature = getValidValue(in.next());
                middayTemperature = getValidValue((Math.random() * (VALIDATION_MAX_TEMP - VALIDATION_MIN_TEMP)) + VALIDATION_MIN_TEMP + "");
                System.out.println(middayTemperature);
            }

            double midnightTemperature = VALIDATION_ERROR_RESULT;
            while (midnightTemperature == VALIDATION_ERROR_RESULT) {
                System.out.println("Day " + (i + 1) + " midnight temperature: ");
//                midnightTemperature = getValidValue(in.next());
                midnightTemperature = getValidValue((Math.random() * (VALIDATION_MAX_TEMP - VALIDATION_MIN_TEMP)) + VALIDATION_MIN_TEMP + "");
                System.out.println(midnightTemperature);
            }

            middayTemperatures[i] = middayTemperature;
            midnightTemperatures[i] = midnightTemperature;
        }

        double middaySum = 0f;
        double midnightSum = 0f;
        for (int i = 0; i < days; i++) {
            middaySum += middayTemperatures[i];
            midnightSum += midnightTemperatures[i];
        }
        double middayAverage = Math.round(middaySum / days * 10.0) / 10.0;
        double midnightAverage = Math.round(midnightSum / days * 10.0) / 10.0;
        System.out.println("Midday Average: " + middayAverage);
        System.out.println("Midnight Average: " + midnightAverage);

        double maxMiddayValue = VALIDATION_MIN_TEMP;
        double maxMiddayDay = 0f;
        double minMidnightValue = VALIDATION_MAX_TEMP;
        double minMidnightDay = 0f;
        for (int i = 0; i < days; i++) {
            if (middayTemperatures[i] > maxMiddayValue) {
                maxMiddayValue = middayTemperatures[i];
                maxMiddayDay = i + 1;
            }
            if (midnightTemperatures[i] < minMidnightValue) {
                minMidnightValue = midnightTemperatures[i];
                minMidnightDay = i + 1;
            }
        }
        System.out.println("Maximum midday temp: " + maxMiddayValue + " on day " + Math.round(maxMiddayDay));
        System.out.println("Minimum midnight temp: " + minMidnightValue + " on day " + Math.round(minMidnightDay));


    }

    private static double getValidValue(String input) {
        double result;
        try {
            result = Double.parseDouble(input);
            result = Math.round(result*10.0)/10.0;

            if (result < VALIDATION_MIN_TEMP || result > VALIDATION_MAX_TEMP) {
                System.out.println("Temperature must be between " + VALIDATION_MIN_TEMP + " and " + VALIDATION_MAX_TEMP + ".");
                return VALIDATION_ERROR_RESULT;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
            return VALIDATION_ERROR_RESULT;
        }
        return result;
    }
}
