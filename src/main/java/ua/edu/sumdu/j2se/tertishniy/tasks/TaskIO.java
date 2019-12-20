package ua.edu.sumdu.j2se.tertishniy.tasks;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.google.gson.Gson;


public class TaskIO {
    public static void write(AbstractTaskList tasks, OutputStream out) throws IOException {

        try (DataOutputStream dataOutputStream = new DataOutputStream(out)) {
            dataOutputStream.writeInt(tasks.size());
            tasks.getStream().forEach(task -> {
                try {
                    dataOutputStream.writeInt(task.getTitle().length());
                    for (int i = 0; i < task.getTitle().length(); i++) {
                        dataOutputStream.writeChar(task.getTitle().charAt(i));
                    }
                    dataOutputStream.writeBoolean(task.isActive());
                    dataOutputStream.writeInt(task.getRepeatInterval());
                    if (task.isRepeated()) {
                        String ldtStart = task.getStartTime().format(DateTimeFormatter.ISO_DATE_TIME);
                        dataOutputStream.writeInt(ldtStart.getBytes().length);
                        dataOutputStream.writeBytes(ldtStart);
                        String ldtEnd = task.getEndTime().format(DateTimeFormatter.ISO_DATE_TIME);
                        dataOutputStream.writeInt(ldtEnd.getBytes().length);
                        dataOutputStream.writeBytes(ldtEnd);
                    } else {
                        String ldtTime = task.getTime().format(DateTimeFormatter.ISO_DATE_TIME);
                        dataOutputStream.writeInt(ldtTime.getBytes().length);
                        dataOutputStream.writeBytes(ldtTime);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void read(AbstractTaskList tasks, InputStream in) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(in)) {
            int amOfTasks = dataInputStream.readInt();
            for (int i = 0; i < amOfTasks; i++) {
                int titleLenght = dataInputStream.readInt();
                StringBuilder title = new StringBuilder();
                for (int j = 0; j < titleLenght; j++) {
                    title.append(dataInputStream.readChar());
                }
                boolean isActive = dataInputStream.readBoolean();
                int repeatInterval = dataInputStream.readInt();
                if (repeatInterval != 0) {
                    LocalDateTime start = LocalDateTime.parse(new String(dataInputStream.readNBytes(dataInputStream.readInt())), DateTimeFormatter.ISO_DATE_TIME);
                    LocalDateTime end = LocalDateTime.parse(new String(dataInputStream.readNBytes(dataInputStream.readInt())), DateTimeFormatter.ISO_DATE_TIME);
                    Task task = new Task(title.toString(), start, end, repeatInterval);
                    task.setActive(isActive);
                    tasks.add(task);
                } else {
                    LocalDateTime time = LocalDateTime.parse(new String(dataInputStream.readNBytes(dataInputStream.readInt())), DateTimeFormatter.ISO_DATE_TIME);
                    Task task = new Task(title.toString(), time);
                    task.setActive(isActive);
                    tasks.add(task);
                }
            }
        }
    }

    public void writeBinary(AbstractTaskList tasks, File file) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            write(tasks, bufferedOutputStream);
        }
    }

    public void readBinary(AbstractTaskList tasks, File file) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            read(tasks, bufferedInputStream);
        }
    }

    public static void write (AbstractTaskList tasks, Writer out) throws IOException {
        /*String baseFile = "tasks.json";
        ObjectMapper mapper = new ObjectMapper();
        tasks.getStream().forEach(task -> {
                    try {
                        mapper.writeValue(new File(baseFile), task);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );*/

        /*JsonWriter writer;
        writer = new JsonWriter(new FileWriter("tasks.json"));
        writer.beginObject();
        tasks.getStream().forEach(task ->{
            try {
                writer.name("title").value(task.getTitle());
                writer.name("time").value()
            } catch (IOException e) {
                e.printStackTrace();
            }
        });*/

        /*StringBuilder stringBuilder = new StringBuilder();
        Gson gson = new Gson();
        JsonWriter jsonWriter = new Gson().newJsonWriter(out);
        tasks.getStream().forEach(task ->{
            stringBuilder.append(gson.toJson(task));
        });
        try (BufferedWriter bufferedWriter = new BufferedWriter(out)) {
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }*/

        /*JsonWriter writer = new JsonWriter(out);
        writer.beginObject();
        tasks.getStream().forEach(task -> {
            try {
                writer.beginArray();
                writer.name("tasks");
                writer.value(task.getTitle());
                writer.value(task.isActive());
                writer.value(task.getRepeatInterval());
                writer.value(task.isRepeated());
                if (task.isRepeated()) {
                    String ldtStart = task.getStartTime().format(DateTimeFormatter.ISO_DATE_TIME);
                    writer.value(ldtStart);
                    String ldtEnd = task.getEndTime().format(DateTimeFormatter.ISO_DATE_TIME);
                    writer.value(ldtEnd);
                } else {
                    String ldtTime = task.getTime().format(DateTimeFormatter.ISO_DATE_TIME);
                    writer.value(ldtTime);
                }
                writer.endArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.endObject();
        writer.close();*/
        Gson gson = new Gson();
        String line = gson.toJson(tasks);
        out.write(line);
        out.flush();
    }

    public static void read (AbstractTaskList tasks, Reader in) throws IOException {
        /*try (JsonReader jsonReader = new JsonReader(in)) {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String string = jsonReader.nextName();
                if (string.equals("tasks")) {
                    jsonReader.beginArray();
                    String title = jsonReader.nextString();
                    boolean active = jsonReader.nextBoolean();
                    int interval = jsonReader.nextInt();
                    boolean isRepeated = jsonReader.nextBoolean();
                    if (isRepeated) {
                        String ldtStart = jsonReader.nextString();
                        LocalDateTime start = LocalDateTime.parse(ldtStart, DateTimeFormatter.ISO_DATE_TIME);
                        String ldtEnd = jsonReader.nextString();
                        LocalDateTime end = LocalDateTime.parse(ldtEnd, DateTimeFormatter.ISO_DATE_TIME);
                        Task task = new Task(title, start, end, interval);
                        task.setActive(active);
                        tasks.add(task);
                    } else {
                        String ldtTime = jsonReader.nextString();
                        LocalDateTime time = LocalDateTime.parse(ldtTime, DateTimeFormatter.ISO_DATE_TIME);
                        Task task = new Task(title, time);
                        task.setActive(active);
                        tasks.add(task);
                    }
                    jsonReader.endArray();
                }
            }
            jsonReader.endObject();
        }*/
        BufferedReader reader = new BufferedReader(in);
        String line = reader.readLine();
        AbstractTaskList list = new Gson().fromJson(line, tasks.getClass());
        for(Task task: list) {
            tasks.add(task);
        }
    }

    public static void writeText (AbstractTaskList tasks, File file) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            write(tasks, bufferedWriter);
        }
    }

    public static void readText (AbstractTaskList tasks, File file) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            read(tasks, bufferedReader);
        }
    }
}
