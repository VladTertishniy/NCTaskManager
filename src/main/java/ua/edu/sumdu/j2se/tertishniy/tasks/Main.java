package ua.edu.sumdu.j2se.tertishniy.tasks;


import ua.edu.sumdu.j2se.tertishniy.tasks.Controller.MainController;
import ua.edu.sumdu.j2se.tertishniy.tasks.Controller.UserNotificationsController;
import ua.edu.sumdu.j2se.tertishniy.tasks.Model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.Model.TaskIO;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayTaskList arrayTaskList = new ArrayTaskList();

		File dir = new File(".\\src\\main\\java\\ua\\edu\\sumdu\\j2se\\tertishniy\\tasks\\saved");

		if (!dir.exists()) {
			System.out.println("Creating directory " + dir.getAbsolutePath());
			dir.mkdir();
			System.out.println("Created directory " + dir.getAbsolutePath());
		}

		File file = new File(".\\src\\main\\java\\ua\\edu\\sumdu\\j2se\\tertishniy\\tasks\\saved\\CollectionOfTasks.bin");
		if(!file.exists()){
			System.out.println("Creating file " + file.getAbsolutePath());
			file.createNewFile();
			System.out.println("Created file " + file.getAbsolutePath());
		}

		TaskIO.readBinary(arrayTaskList, file);

		UserNotificationsController thread = new UserNotificationsController(arrayTaskList);
		thread.setDaemon(true);
		thread.start();

		MainController mainController = new MainController();
		mainController.run(arrayTaskList);

		if(file.exists()) {
			String pathName = file.getAbsolutePath();
			file.delete();
			File newFile = new File(pathName);
			newFile.createNewFile();
			TaskIO.writeBinary(arrayTaskList, file);
		}
	}
}
