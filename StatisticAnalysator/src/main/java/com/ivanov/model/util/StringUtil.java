package com.ivanov.model.util;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.ivanov.model.util.Constant.*;

public class StringUtil {
    private static StringUtil instance;

    public StringUtil() {
    }

    public static StringUtil getInstance() {
        if (instance == null) {
            instance = new StringUtil();
        }
        return instance;
    }

    public Path obtainFilePath(String pathDirectory, String file) {
        return Paths.get(pathDirectory.concat(file));
    }


    public String obtainDomain(String lineWithDomain) {
        return lineWithDomain.substring(lineWithDomain.lastIndexOf(EQUAL) + 1);
    }

    public String obtainLink(String[] arrayWithDomainAndQuantity) {
        return arrayWithDomainAndQuantity[INDEX_OF_DOMAIN];
    }

    public int obtainQuantity(String[] arrayWithDomainAndQuantity) {
        return Integer.parseInt(arrayWithDomainAndQuantity[INDEX_OF_QUANTITY].substring(0, arrayWithDomainAndQuantity[INDEX_OF_QUANTITY].lastIndexOf(QUOTATION_MARK)));
    }




    public String obtainResultRow(String categoryName, int categoryQuantity) {
        return String.format(RESULT_ROW_PATTERN, categoryName, categoryQuantity);
    }

}
