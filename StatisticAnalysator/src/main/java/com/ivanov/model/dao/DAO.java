package com.ivanov.model.dao;

import java.io.FileNotFoundException;
import java.util.List;

public interface DAO {

    void addLine(String line) throws FileNotFoundException;

    List<String> getAllLines();

    void updateLine(String oldLine, String newLine);

}
