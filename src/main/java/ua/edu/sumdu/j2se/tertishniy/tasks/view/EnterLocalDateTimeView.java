package ua.edu.sumdu.j2se.tertishniy.tasks.view;


import ua.edu.sumdu.j2se.tertishniy.tasks.controller.Controller;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EnterLocalDateTimeView extends Controller {

    int year;
    int month;

    public LocalDateTime getDate(String enterSomethings) {
        System.out.println(enterSomethings);
        return LocalDateTime.of(enterYear(), Month.of(enterMonth()), enterDay(), enterHour(), enterMinute());
    }

    private int enterYear () {
        int year;
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
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return enterYear();
        }
        this.year = year;
        return year;
    }

    private int enterMonth () {
        int month;
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
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return enterMonth();
        }
        this.month = month;
        return month;
    }

    private int enterDay () {
        int day;
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
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return enterDay();
        }
        return day;
    }

    private int enterHour () {
        int hour;
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
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return enterHour();
        }
        return hour;
    }

    private int enterMinute () {
        int minute;
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
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            return enterMinute();
        }
        return minute;
    }
}
