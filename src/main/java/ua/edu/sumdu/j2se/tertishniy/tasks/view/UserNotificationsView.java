package ua.edu.sumdu.j2se.tertishniy.tasks.view;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.ArrayTaskList;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Task;
import ua.edu.sumdu.j2se.tertishniy.tasks.model.Tasks;

import java.time.LocalDateTime;

public class UserNotificationsView extends Thread {
    private ArrayTaskList taskList;
    final static Logger logger = Logger.getLogger(UserNotificationsView.class);
    public UserNotificationsView(ArrayTaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void run() {
        logger.info("Run thread");
        Iterable<Task> result;
        while (true) {
            result = Tasks.incoming(taskList, LocalDateTime.now(), LocalDateTime.now().plusMinutes(5));
            for (Task task: result
            ) {
                System.out.println("\n" + "NOTIFICATION: " + task.getTitle() );
                logger.info("New notification: " + task.getTitle());
            }
            try {
                sleep(60000);
            } catch (InterruptedException e) {
                logger.error("Interrupted Exception");
                currentThread().interrupt();
            }
        }
    }
}
