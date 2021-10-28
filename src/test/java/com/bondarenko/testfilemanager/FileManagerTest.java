package com.bondarenko.testfilemanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileManagerTest {
    private File dir;
    @Before
    public void before() throws IOException {
        //create file tree
    //   String path = Files.createTempDirectory(null).toFile();
        }


    @Test
    public void testCountFiles() {


     //   File file = new File(path);
       // File file = new File(dir);
     // int countFiles =  ViewFileSystem.countFiles("C://SomeDir");

    }

    @After
    public void after() {
        //destroy file tree
    //    public static void afterClass() throws IOException {
            if (dir == null) {
                return;
            }
        //    deleteRecursive(dir);
            System.out.println(dir.exists());
        }
    }



