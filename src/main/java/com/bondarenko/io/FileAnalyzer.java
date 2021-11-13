package com.bondarenko.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAnalyzer {
    public static void main(String[] args) throws FileNotFoundException {
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        String separator = File.separator;
        String path = "E:" + separator + "Робоча 2021" + separator + "Java" + separator + "datastructure" + separator + "src" + separator + "test" + separator + "java" + separator + "com" + separator + "bondarenko" + separator + "fileanalyzer" + separator + "story";

        fileAnalyzer.analyze(path, "duck");
    }

    private void analyze(String path, String word) throws FileNotFoundException {
        //Прочитати файл через scanner
        try {
            File file = new File(path);
            int count = 0;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();

                // пошук слова через
                // Pattern —  конструктор регулярных выражений.
                Pattern pattern = Pattern.compile(word);//метод compile вызывает закрытый конструктор класса Pattern для создания скомпилированного представления
                Matcher matcher = pattern.matcher(text);// Matcher сопоставляет его с каждым символом текста, начиная с нулевой позиции

                while (matcher.find())
                    count++;
                System.out.println(count);

                //Розділити текст на речення через split
                String[] sentences = text.split("\\.|!|\\?");

                //Виведення речень, які містять word з нового рядка
                for (String sentence : sentences) {
                    if (sentence.contains(word)) {
                        System.out.println(sentence);
                    }
                }
            }
            scanner.close();
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Path is not found");

        }
    }
}
