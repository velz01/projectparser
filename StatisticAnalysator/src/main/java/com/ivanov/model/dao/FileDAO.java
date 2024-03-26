package com.ivanov.model.dao;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileDAO implements DAO {

    public FileDAO(Path path) {
        this.file = path;
    }

    private Path file;


    @Override
    public void addLine(String line) {
        try {
            FileInputStream fis = new FileInputStream(file.toFile());
            BufferedInputStream bis = new BufferedInputStream(fis);

            byte[] bytes = bis.readAllBytes();

            fis.close();
            bis.close();

            String content = new String(bytes, StandardCharsets.UTF_8);


            line = '\n' + line;

            String newContent = content.concat(line);

            RandomAccessFile file1 = new RandomAccessFile(file.toFile(), "rw");
            file1.seek(file1.length());
            file1.write(line.getBytes());
            /*FileOutputStream fos = new FileOutputStream(file.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            bos.write(newContent.getBytes(), 0, newContent.length());

            bos.flush();
            fos.flush();

            bos.close();
            fos.close();*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getAllLines() {
        List<String> readLines = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file.toFile());
            BufferedInputStream bis = new BufferedInputStream(fis)) {


            byte[] bytes = bis.readAllBytes();
            String fileContent = new String(bytes, StandardCharsets.UTF_8);


            readLines = Arrays.stream(fileContent.split("\n")).filter(s -> !s.isBlank()).map(String::strip).collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return readLines;
    }



    @Override
    public void updateLine(String oldLine, String newLine) {
        try {
            FileInputStream fis = new FileInputStream(file.toFile());
            BufferedInputStream bis = new BufferedInputStream(fis);

            byte[] bytes = bis.readAllBytes();

            fis.close();
            bis.close();


            String content = new String(bytes, StandardCharsets.UTF_8);


            int start = content.indexOf(oldLine);
            int end = newLine.length();

            RandomAccessFile file1 = new RandomAccessFile(file.toFile(), "rw");
            System.out.println(start);
            System.out.println(end);
            file1.seek(start);
            file1.write(newLine.getBytes());


//            if (start == -1) {
//                addLine(newLine);
//            } else {
//                String newContent = content.replace(oldLine, newLine);
//
//                bos.write(newContent.getBytes())


            /*
            *
            *
            * 5464654
            * 54123456789
            * 65494789
            * 213
            * 21321.87
            *
            *
            * */

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
