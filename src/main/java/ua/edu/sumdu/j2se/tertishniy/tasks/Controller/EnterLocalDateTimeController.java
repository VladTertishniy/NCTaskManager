package ua.edu.sumdu.j2se.tertishniy.tasks.Controller;


import ua.edu.sumdu.j2se.tertishniy.tasks.View.AddTaskView;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

public class EnterLocalDateTimeController extends Controller {
    public static LocalDateTime getDate() {
        System.out.println("Date format: YYYY.MM.DD.HH.MM ");
        Scanner dateScanner = new Scanner(System.in);
        System.out.println("Year:");
        int year = dateScanner.nextInt();
        System.out.println("Month:");
        int month = dateScanner.nextInt();
        System.out.println("Day:");
        int day = dateScanner.nextInt();
        System.out.println("Hour:");
        int hour = dateScanner.nextInt();
        System.out.println("Minutes");
        int minutes = dateScanner.nextInt();
        return LocalDateTime.of(year, Month.of(month), day, hour, minutes);
    }
}
