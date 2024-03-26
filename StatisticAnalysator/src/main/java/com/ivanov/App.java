package com.ivanov;

import com.ivanov.model.dao.DAO;
import com.ivanov.model.dao.DAOFactory;
import com.ivanov.model.dao.FileDAO;
import com.ivanov.model.dao.IOFactory;
import com.ivanov.model.service.StatisticsService;
import com.ivanov.model.util.ArgsParser;
import com.ivanov.model.util.StringUtil;

import java.io.*;
import java.util.Scanner;

import static com.ivanov.model.util.Constant.*;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        String searchResultFileName = ArgsParser.getInstance().getSearchResultFile(args);
        String category = ArgsParser.getInstance().getCategory(args);

        DAOFactory daoFactory = DAOFactory.getInstance();

        DAO srcDao = daoFactory.createDao(PATH_DIRECTORY_SEARCH, searchResultFileName);
        DAO outDao = daoFactory.createDao(PATH_DIRECTORY_CATEGORY, category);

        //System.out.println(outDao.getAllLines());
//        outDao.updateLine("\"lenardi.ru\"=\"2\"", "\"ozon.ru\"=\"3\"");
        outDao.updateLine("\"ozon.ru\"=\"3\"", "\"lenasdrdi.ru\"=\"2\"");


        StringUtil stringUtil = StringUtil.getInstance();
/*
        //SearchResult file
        final String srcFile = stringUtil.obtainFilePath(PATH_DIRECTORY_SEARCH, args);
        DAO srcDao = FileDAO.getInstance(srcFile);

        final String category = stringUtil.obtainCategoryName(args);

        StatisticsService statisticsService = StatisticsService.getInstance(srcDao, category);



        final String filePath = stringUtil.obtainFilePath(args, PATH_DIRECTORY_SEARCH);
        final File read = ioFactory.obtainFile(filePath);
        final Scanner reader = ioFactory.obtainReader(read);

        statisticsService.addDomainsWithoutQuantity(reader);

        statisticsService.addDomainsWithQuantity(
                ioFactory.obtainReader(
                        ioFactory.obtainFile(PATH_FILE_COMMON)
                )
        );


        statisticsService.increaseQuantityOfDomain();


        statisticsService.writeDomainsToFile(
                ioFactory.obtainWriter(
                        ioFactory.obtainFile(PATH_FILE_COMMON)
                )
        );

        statisticsService.createCategoryFile(stringUtil.obtainCategoryPath(args));
        statisticsService.clearAllDomains();
        statisticsService.addDomainsWithQuantity(
                ioFactory.obtainReader(
                        ioFactory.obtainFile(stringUtil.obtainCategoryPath(args))
                )
        );
        statisticsService.increaseQuantityOfDomain();

        statisticsService.writeDomainsToFile(
                ioFactory.obtainWriter(
                        ioFactory.obtainFile(stringUtil.obtainCategoryPath(args))
                )
        );
*/
    }
}

