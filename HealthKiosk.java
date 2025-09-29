
import java.util.Scanner;
import java.util.Random;
public class HealthKiosk{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        // Task 1:

        System.out.print("Enter service code (P/L/T/C): ");
        char service_code = input.next().charAt(0);
        service_code = Character.toUpperCase(service_code);
        String go_to = "";

        switch (service_code) {
            case 'P' -> go_to = "PHARMACY";
            case 'L' -> go_to =  "LAB";
            case 'T' -> go_to = "TRIAGE";
            case 'C' -> go_to = "COUNSELING";

        }

        // Task 2
        System.out.print("""
                                         Enter the health metric code:
                                         1. for BMI
                                         2. for Dosage round-up
                                         3. for simple trig helper.
                """);
        int metric_code = input.nextInt();

        int rounded_integer = 0;

        if (metric_code == 1) {
            System.out.print("Enter weight in kgs: ");
            double weight_kg = input.nextDouble();
            System.out.print("Enter height in metres: ");
            double height_m = input.nextDouble();
            double bmi = (weight_kg) / (height_m * height_m);
            rounded_integer = (int) (Math.round(bmi * 10) /10);
            double rounded_bmi = Math.round(bmi * 10) / 10.0;

            String category;
            if (rounded_bmi < 18.5) {
                category = "Underweight";
            } else if (rounded_bmi >= 18.5 && rounded_bmi <= 24.9) {
                category = "Normal";
            } else if (rounded_bmi >= 25.0 && rounded_bmi <= 29.9) {
                category = "Overweight";
            } else {
                category = "Obese";
            }
            System.out.println("BMI: " + rounded_bmi + " Category: " + category);
        } else if (metric_code == 2) {
            System.out.print("Enter the required dosage (mg): ");
            double dosage = input.nextDouble();
            int num_pills = (int) Math.ceil(dosage / 250);
            rounded_integer = num_pills;
        } else if (metric_code == 3) {
            System.out.print("Enter an angle in degress: ");
            double angle = input.nextDouble();
            double radian_angle = Math.toRadians(angle);
            double sin_angle = Math.sin(radian_angle);
            double rounded_sin = Math.round(sin_angle * 1000) / 1000.0;
            rounded_integer = (int) (sin_angle*100);
            double cos_angle = Math.cos(radian_angle);
            double rounded_cos = Math.round(cos_angle * 1000) / 1000.0;
            System.out.println("Cos: " + rounded_cos + " Sin: " + rounded_sin);
        } else {
            System.out.println("Enter a valid input!");
        }

        // Task 3
        char first_letter = (char) ('A' + random.nextInt(26));
        int num1 = random.nextInt(3, 10);
        int num2 = random.nextInt(3, 10);
        int num3 = random.nextInt(3, 10);
        int num4 = random.nextInt(3, 10);
        String id = first_letter + "" + num1 + num2 + num3 + num4;

        if (Character.isLetter(id.charAt(0))) {
            System.out.println("Character 1 Ok");
        } else {
            System.out.println("Invalid: first character must be a letter");
        }

        if (Character.isDigit(id.charAt(1))) {
            System.out.println("Character 2 Ok");
        } else {
            System.out.println("Invalid: second character must be digit");
        }
        if (Character.isDigit(id.charAt(2))) {
            System.out.println("Character 3 Ok");
        } else {
            System.out.println("Invalid: third character must be digit");
        }

        if (Character.isDigit(id.charAt(3))) {
            System.out.println("Character 4 ok");
        } else {
            System.out.println("Invalid: fourth character must be digit");
        }
        if (Character.isDigit(id.charAt(4))) {
            System.out.println("Character 5 Ok");
        } else {
            System.out.println("Invalid: fifth character must be digit");
        }



        // task 4
        String empty = input.nextLine();
        System.out.print("Enter your first name: ");
        String name = input.nextLine();
        char base = name.charAt(0);
        char shifted_letter = (char) ('A' + (base - 'A' + 2) % 26);
        String last_characters = id.substring(3);

        String Code = shifted_letter+""+last_characters+ "-"+rounded_integer;
        System.out.print("Summary: " + go_to + " | ID="+id+ " | Code=" +  Code);




        input.close();
    }
}
