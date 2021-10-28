package com.bondarenko.fileanalyzer;

import java.io.File;

public class FileManager {

    // public static int countFiles(String path) - принимает путь к папке,
    // возвращает количество файлов в папке и всех подпапках по пути
    public static int countFiles(String path) {
        File file = new File(path);
        int countFiles = 0;
        for (File item : file.listFiles()) {
            if (item.isFile()) {
                countFiles++;
            } else {
                int count = countFiles(item.toString());
                if (count != 0) {
                    countFiles = countFiles + count;
                }
            }
        }
        return countFiles;
    }

    //public static int countDirs(String path) - принимает путь к папке,
    // возвращает количество папок в папке и всех подпапках по пути
    public static int countDirs(String path) {
        File folder = new File(path);
        int countDirs = 0;
        for (File item : folder.listFiles()) {
            if (item.isDirectory()) {
                countDirs++;
                int count = countDirs(item.toString());
                if (count != 0) {
                    countDirs = countDirs + count;
                }
            }
        }
        return countDirs;
    }

    //public static void copy(String from, String to) - метод по копированию папок и файлов.
    // Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
    public static void copy(String from, String to) {
    //    InputStream input = null;
      //  OutputStream output = null
    }








}
//4.public static void move(String from, String to) - метод по перемещению папок и файлов.
//Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование


//https://metanit.com/java/tutorial/6.11.php
//https://metanit.com/java/tutorial/6.11.php
//http://proglang.su/java/io-and-files-and-directories-file-class



    /*    if(file.isDirectory())
        {
            // получаем все вложенные объекты в каталоге
            for(File item : file.listFiles()){

                if(item.isDirectory()){

                    System.out.println(item.getName() + "  \t folder");
                }
                else{

                    System.out.println(item.getName() + "\t file");
                }
            }
        }

        return 0;

        //boolean exists(): проверяет, существует ли по указанному в конструкторе пути файл или каталог.
        // И если файл или каталог существует, то возвращает true, иначе возвращает false
        //boolean isDirectory(): возвращает значение true, если по указанному пути располагается каталог
    }
*/