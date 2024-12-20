package hometask2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] str = new String[]{"book", "pen", "ruler", "note", "laptop", "window"};

        Random random = new Random();

        try (
                FileWriter writer = new FileWriter("a.txt");
        ) {
            for (int i = 0; i < 1000; i++) {
                writer.write(str[random.nextInt(str.length)] + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            System.out.println("""
                    1 - Remove books
                    2 - Remove pens
                    """);

            switch (Input.num("Choose: ")) {
                case 1 -> removeBooks();
                case 2 -> removePens();
            }
        }
    }

    private static void removeBooks() {
        List<String> lines = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(new FileReader("a.txt"));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("book")) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("a.txt"))
        ) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void removePens() {

        List<String> lines = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(new FileReader("a.txt"));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("pen")) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("a.txt"))
        ) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
