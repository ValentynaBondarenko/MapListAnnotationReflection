package com.bondarenko.io;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static final String FILE = "text.txt";
    public static final String REGEX_PATTERN = "[.,?!:;]";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(FILE));
        String line = " ";
        while (sc.hasNextLine()) {
            line = (sc.nextLine());
        }
        String input = line.replaceAll("\\W", " ");
        String[] words = input.split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)
        List<String> distinct = Arrays.asList(words).stream().map(String::toLowerCase).sorted().distinct().collect(Collectors.toList());
        for (String subStr : distinct) {
            System.out.println(subStr);
        }
    }
}
