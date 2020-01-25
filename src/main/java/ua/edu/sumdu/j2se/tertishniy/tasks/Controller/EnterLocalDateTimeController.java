package ua.edu.sumdu.j2se.tertishniy.tasks.Controller;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnterLocalDateTimeController extends Controller {

    int year;
    int month;

    public LocalDateTime getDate() {
        return LocalDateTime.of(enterYear(), Month.of(enterMonth()), enterDay(), enterHour(), enterMinute());
    }

    private int enterYear () {
        int year = 0;
        System.out.println("Year:");
        Scanner scanner = new Scanner(System.in);
        try {
            year = scanner.nextInt();
            if (year < 0) {
                System.out.println("Incorrect value!");
                return enterYear();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect value!");
            return enterYear();
        }
        this.year = year;
        return year;
    }

    private int enterMonth () {
        int month = 0;
        System.out.println("Month:");
        Scanner scanner = new Scanner(System.in);
        try {
            month = scanner.nextInt();
            if (month <= 0 || month > 12) {
                System.out.println("Incorrect value!");
                return enterMonth();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect value!");
            return enterMonth();
        }
        this.month = month;
        return month;
    }

    private int enterDay () {
        int day = 0;
        System.out.println("Day:");
        Scanner scanner = new Scanner(System.in);
        try {
            day = scanner.nextInt();
            Calendar myCalendar = (Calendar) Calendar.getInstance().clone();
            myCalendar.set(year, month - 1, 1);
            int max_date = myCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            if (day <= 0 || day > max_date) {
                System.out.println("Incorrect value!");
                return enterDay();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect value!");
            return enterDay();
        }
        return day;
    }

    private int enterHour () {
        int hour = 0;
        System.out.println("Hour:");
        Scanner scanner = new Scanner(System.in);
        try {
            hour = scanner.nextInt();
            if (hour < 0 || hour > 24) {
                System.out.println("Incorrect value!");
                return enterHour();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect value!");
            return enterHour();
        }
        return hour;
    }

    private int enterMinute () {
        int minute = 0;
        System.out.println("Minutes");
        Scanner scanner = new Scanner(System.in);
        try {
            minute = scanner.nextInt();
            if (minute < 0 || minute >= 60) {
                System.out.println("Incorrect value!");
                return enterMinute();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect value!");
            return enterMinute();
        }
        return minute;
    }

}
