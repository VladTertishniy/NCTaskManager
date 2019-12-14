package ua.edu.sumdu.j2se.tertishniy.tasks;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		/*Task task1 = new Task("Пробежка", 10, 20, 5);
		task1.setTime(1000);
		task1.setActive(true);
		task1.setTime(10,20,5);
		Task task2 = new Task("Пробежка", 10, 20, 5);
		task2.setActive(true);
		System.out.println(task1.equals(task2));*/

		/*Task task1 = new Task("Пробежка", 10, 20, 5);
		Task task2 = task1.clone();
		task2.setTitle("dsdfsd");
		task2.setTime(121);
		System.out.println(task1.toString());
		System.out.println(task2.toString());
		System.out.println(task1.clone().equals(task1));*/

		/*Reader reader = new FileReader("C:\\Users\\Влад\\Desktop\\HelloWorld.txt");
		int a = 0;
		StringBuilder s = new StringBuilder();
		while ((a = reader.read()) != -1) {
			s.append((char)a);
		}
		System.out.println(s);*/

		/*try (ServerSocket serverSocket = new ServerSocket(1711)) {
			Socket socket = serverSocket.accept();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
			while (socket.isConnected()) {
				System.out.println(new String (bufferedInputStream.readAllBytes()));
			}
		}*/

		/*Task task1 = new Task("Пробежка", 10, 20, 5);
		try (Socket socket = new Socket("93.79.11.150", 1711)) {
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
			System.out.println("Connected to " + socket.getRemoteSocketAddress());
			bufferedOutputStream.write(new Task("tit", 123).toString().getBytes());
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
		}*/

		/*try (ServerSocket serverSocket = new ServerSocket(1711)) {
			Socket socket = serverSocket.accept();
			System.out.println("Incoming connection from " + socket.getRemoteSocketAddress());

			while (socket.isConnected()) {
				System.out.println(new Scanner(socket.getInputStream()).nextLine());
			}
		}*/

		Task task1 = new Task("Пробежка1", LocalDateTime.now().minusDays(3L), LocalDateTime.now().plusDays(3L), 100);
		Task task2 = new Task("Пробежка2", LocalDateTime.now().minusDays(2L), LocalDateTime.now().plusDays(2L), 50);
		Task task3 = new Task("Пробежка3", LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L), 25);
		ArrayList<Task> arrayList = new ArrayList<>();
		arrayList.add(task1);
		arrayList.add(task2);
		arrayList.add(task3);

		Tasks.incoming(arrayList, LocalDateTime.now().minusDays(4L), LocalDateTime.now().plusDays(4L));

	}
}
