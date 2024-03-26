package com.ivanov.model.dao;

import com.ivanov.model.util.StringUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public final class DAOFactory {

    private static DAOFactory instance;

    private DAOFactory() {
        this.util = StringUtil.getInstance();
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    private final StringUtil util;


    public DAO createDao(String path, String file) {
        Path filePath = util.obtainFilePath(path, file);
        try {
            filePath = Files.exists(filePath) ? filePath : Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new FileDAO(filePath);
    }


}
