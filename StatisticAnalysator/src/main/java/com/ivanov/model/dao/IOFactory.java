package com.ivanov.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOFactory {

    private static IOFactory instance;
    public IOFactory() {}

    public static IOFactory getInstance() {
        if (instance == null) {
            instance = new IOFactory();
        }
        return instance;
    }

    public File obtainFile(String path) {
        return new File(path);
    }

    public Scanner obtainReader(File file) throws FileNotFoundException {
        return new Scanner(file);
    }

    public PrintWriter obtainWriter(File file) throws FileNotFoundException {
        return new PrintWriter(file);
    }


}
