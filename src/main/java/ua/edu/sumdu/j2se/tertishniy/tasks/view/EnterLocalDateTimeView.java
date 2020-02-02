package ua.edu.sumdu.j2se.tertishniy.tasks.view;


import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.tertishniy.tasks.controller.Controller;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EnterLocalDateTimeView extends Controller {

    int year;
    int month;
    final static Logger logger = Logger.getLogger(EnterLocalDateTimeView.class);

    public LocalDateTime getDate(String enterSomethings) {
        logger.info("Get date operation started.");
        System.out.println(enterSomethings);
        try {
            logger.info("Get date operation finished.");
            return LocalDateTime.of(enterYear(), Month.of(enterMonth()), enterDay(), enterHour(), enterMinute());
        } catch (DateTimeException e) {
            System.out.println("Incorrect value!");
            logger.info("User enter incorrect value.");
            return getDate(enterSomethings);
        }
    }

    private int enterYear () {
        logger.info("Enter year operation started.");
        int year;
        System.out.println("Year:");
        Scanner scanner = new Scanner(System.in);
        try {
            year = scanner.nextInt();
            if (year < 0) {
                System.out.println("Incorrect value!");
                logger.info("User enter incorrect value.");
                return enterYear();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect value!");
            logger.info("User enter incorrect value.");
            return enterYear();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            logger.info("Error: " + e.getMessage());
            return enterYear();
        }
        this.year = year;
        logger.info("Enter year operation finished.");
        return year;
    }

    private int enterMonth () {
        logger.info("Enter month operation started.");
        int month;
        System.out.println("Month:");
        Scanner scanner = new Scanner(System.in);
        try {
            month = scanner.nextInt();
            if (month <= 0 || month > 12) {
                System.out.println("Incorrect value!");
                logger.info("User enter incorrect value.");
                return enterMonth();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect value!");
            return enterMonth();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            logger.info("Error: " + e.getMessage());
            return enterMonth();
        }
        this.month = month;
        logger.info("Enter month operation finished.");
        return month;
    }

    private int enterDay () {
        logger.info("Enter day operation started.");
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
                logger.info("User enter incorrect value.");
                return enterDay();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect value!");
            logger.info("User enter incorrect value.");
            return enterDay();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            logger.info("Error: " + e.getMessage());
            return enterDay();
        }
        logger.info("Enter day operation finished.");
        return day;
    }

    private int enterHour () {
        logger.info("Enter hour operation started.");
        int hour;
        System.out.println("Hour:");
        Scanner scanner = new Scanner(System.in);
        try {
            hour = scanner.nextInt();
            if (hour < 0 || hour > 24) {
                System.out.println("Incorrect value!");
                logger.info("User enter incorrect value.");
                return enterHour();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect value!");
            logger.info("User enter incorrect value.");
            return enterHour();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            logger.info("Error: " + e.getMessage());
            return enterHour();
        }
        logger.info("Enter hour operation finished.");
        return hour;
    }

    private int enterMinute () {
        logger.info("Enter minute operation started.");
        int minute;
        System.out.println("Minutes");
        Scanner scanner = new Scanner(System.in);
        try {
            minute = scanner.nextInt();
            if (minute < 0 || minute >= 60) {
                System.out.println("Incorrect value!");
                logger.info("User enter incorrect value.");
                return enterMinute();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect value!");
            logger.info("User enter incorrect value.");
            return enterMinute();
        }
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error! Please, try again.");
            logger.info("Error: " + e.getMessage());
            return enterMinute();
        }
        logger.info("Enter minute operation finished.");
        return minute;
    }
}
