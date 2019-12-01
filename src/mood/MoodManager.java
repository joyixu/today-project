package mood;

import java.io.*;
import java.util.ArrayList;

public class MoodManager implements Serializable {

    private final String key;
    private String date; // TODO may change to something not a string
    private String mood;

    public MoodManager (String date, String mood) {
        this.key = date + "::" + mood;
        this.date = date;
        this.mood = mood;
    }

    private void saveMood() {
        ObjectConverter.save(new MoodManager(this.date, this.mood));
    }

    private ArrayList load() {
        return ObjectConverter.loadAll();
    }

    private static class ObjectConverter {
        private static String fileName = "datastore.txt";

        private static void save(MoodManager moodManager) {

            FileOutputStream fileOutputStream = null;
            ObjectOutputStream objectOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(fileName);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(moodManager);

                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static ArrayList loadAll() {

            FileInputStream fileInputStream = null;
            ObjectInputStream objectInputStream = null;
            ArrayList moods = new ArrayList<>();

            try {
                fileInputStream = new FileInputStream(fileName);
                objectInputStream = new ObjectInputStream(fileInputStream);
                int result = objectInputStream.readInt();
                for (int i = 0; i < result; ++i) {
                    moods.add(objectInputStream.readObject());
                }
                objectInputStream.close();

            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

            return moods;
        }
    }
}
