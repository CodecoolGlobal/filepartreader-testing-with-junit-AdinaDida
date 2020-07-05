package codecool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    String filePath;
    public void setup(String filePath, int fromLine, int toLine){
        this.filePath = filePath;
        if (toLine < fromLine) {
            throw new IllegalArgumentException("Value smaller than " + fromLine);
        }
        if (fromLine < 1) {
            throw new IllegalArgumentException("Value smaller than 1");
        }
    }

    public String read() {
        BufferedReader reader;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public String readLine(int fromLine, int toLine){
        String lines = read();
        String[] parts = lines.split(",");
        for (int i = 0; i <= toLine; i++) {
            if(i >= fromLine){
                return parts[i];
            }
        }
        return null;
    }

}
