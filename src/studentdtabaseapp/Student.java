package studentdtabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses =  "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id= 1000;

    // Constructor: prompt user to enter student's name and year
    public Student(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.println("Enter student class level: \n" +
                "1 - Freshmen \n" +
                "2 - Sophmore \n" +
                "3 - Junior \n" +
                "4 - Senior");
        this.gradeYear = in.nextInt();
        setStudentID();

//        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);


    }



    // Generate an ID
    private void setStudentID(){
        // Grade Level + ID
        id++;
        this.studentID =  gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll(){
        // Get inside a loop, user hits 0
        do {
            System.out.print("Enter course to enroll ( Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
//        System.out.println(course);
            if (!course.equals("Q")) {
                this.courses = this.courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else {
                // System.out.println("BREAK!");
                break;
            }
        } while(true);

//        System.out.println("ENROLLED IN : " + courses);
//        System.out.println("TUITION BALALCE: " + tuitionBalance);
    }

    // View balance
    public void viewBalance(){
        System.out.println("Your balance is : $" + tuitionBalance);
    }
    // Pay Tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: ");
        Scanner in = new Scanner(System.in);
        int payment =  in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();

    }



    // Show status
    @Override
    public String toString(){
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudente ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;

    }

}
