package com.cjc.ims.app.client;

import java.util.Scanner;

import com.cjc.ims.app.serviceimpl.KarveNagar;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        KarveNagar karveNagar = new KarveNagar();

        while (true) {

            System.out.println("Welcome to....");
            System.out.println("1. Add Course");
            System.out.println("2. View Course");
            System.out.println("3. Add Faculty");
            System.out.println("4. View Faculty");
            System.out.println("5. Add Batch");
            System.out.println("6. View Batch");
            System.out.println("7. Add Student");
            System.out.println("8. View Student");
            System.out.println("9. Exit");

            System.out.println("Please Enter Your Choice:");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    karveNagar.addCourse();
                    break;
                case 2:
                    karveNagar.viewCourse();
                    break;
                case 3:
                    karveNagar.addFaculty();
                    break;
                case 4:
                    karveNagar.viewFaculty();
                    break;
                case 5:
                    karveNagar.addBatch();
                    break;
                case 6:
                    karveNagar.viewBatch();
                    break;
                case 7:
                    karveNagar.addStudent();
                    break;
                case 8:
                    karveNagar.viewStudent();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return; // exits the main method
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
