package com.ivanov.service;

import com.ivanov.util.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private static FileService instance;

    private FileService() {}

    public static FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    private static File resultFile;

    public boolean createResultFile(String path) {
        resultFile = new File(path);
        writeResults(new ArrayList<>());
        try {
            return resultFile.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public void writeResults(List<String> results) {
        try (FileWriter writer = new FileWriter(resultFile)) {
            for (String result : results) {
                writer.write(
                        StringUtils.getInstance()
                                .obtainResultRow(result)
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
