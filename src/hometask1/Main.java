package hometask1;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        File file = new File("files");
        File writer = new File("all.txt");


        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(writer))
        ) {
            if (file.isDirectory()) {
                readFile(file, bw);
            } else {
                System.out.println("File not found");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFile(File file, BufferedWriter bw) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    readFile(f, bw);
                } else if (f.getName().endsWith(".txt")) {
                    readText(f, bw);
                }
            }
        }
    }

    private static void readText(File f, BufferedWriter bw) {
        try (
                BufferedReader br = new BufferedReader(new FileReader(f))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
