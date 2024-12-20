package hometask1;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        File directory = new File(sourceDirectory);
        File[] files = directory.listFiles();


        if (files == null || files.length == 0) {
            System.out.println("No files found in directory");
            return;
        }


        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(writer))
        ) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try (
                            BufferedReader reader = new BufferedReader(new FileReader(file))
                    ) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            writer.write(line);
                            writer.newLine();
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + file.getName() + " - " + e.getMessage());
                    }
                }
                System.out.println("All files are written to " + outputFile);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
