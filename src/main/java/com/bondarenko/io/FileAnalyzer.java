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

/*
1: Написать программу FileAnalyzer, которая в консоли принимает 2 параметра:
1) путь к файлу
2) слово
Usage:
java FileAnalyzer C:/test/story.txt duck
Выводит:
1) Кол-во вхождений искомого слова в файле
2) Все предложения содержащие искомое слово(предложение заканчивается символами ".", "?", "!"), каждое преждложение с новой строки.
 */
//https://www.youtube.com/watch?v=j3I-jLGW8yU&ab_channel=alishev
//https://javarush.ru/groups/posts/regulyarnye-vyrazheniya-v-java

     /*
        analyze(String path, String word)
        String text = readFile(path);
        List<String> sentences = splitToSentences(text);
        int count = countWords(filteredSentences, word);
        */