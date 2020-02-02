package ua.edu.sumdu.j2se.tertishniy.tasks;


import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.tertishniy.tasks.controller.MainController;
import ua.edu.sumdu.j2se.tertishniy.tasks.view.UserNotificationsView;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.TaskIO;

import java.io.*;

public class Main {

	final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws Exception {

		logger.info("Program started.");
		ArrayTaskList arrayTaskList = new ArrayTaskList();

		File dir = new File(".\\src\\main\\java\\ua\\edu\\sumdu\\j2se\\tertishniy\\tasks\\saved");

		if (!dir.exists()) {
			try {
				dir.mkdir();
				logger.info("Created directory " + dir.getAbsolutePath());
			}
			catch (SecurityException e) {
				System.out.println("Security error!");
				logger.info("Security error! ");
			}
		}

		File file = new File(".\\src\\main\\java\\ua\\edu\\sumdu\\j2se\\tertishniy\\tasks\\saved\\CollectionOfTasks.bin");
		if(!file.exists()){
			try {
				file.createNewFile();
				logger.info("Created file " + dir.getAbsolutePath());
			}
			catch (SecurityException e) {
				System.out.println("Security error!");
				logger.info("Security error! ");
			}
		}

		TaskIO.readBinary(arrayTaskList, file);

		UserNotificationsView thread = new UserNotificationsView(arrayTaskList);
		thread.setDaemon(true);
		thread.start();

		MainController mainController = new MainController();
		mainController.run(arrayTaskList);

		if(file.exists()) {
			String pathName = file.getAbsolutePath();
			if (file.delete()) {
				logger.info("File " + pathName + " deleted.");
			}
			File newFile = new File(pathName);
			if (newFile.createNewFile()) {
				logger.info("New file " + newFile.getAbsolutePath() + " created.");
			}
			TaskIO.writeBinary(arrayTaskList, file);
			logger.info("Information was written.");
		}
		logger.info("Program stoped.");
	}
}
