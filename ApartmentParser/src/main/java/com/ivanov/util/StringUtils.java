package com.ivanov.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.ivanov.util.Constant.*;

public class StringUtils {

    private static StringUtils instance;

    private StringUtils() {}

    public static StringUtils getInstance() {
        if (instance == null) {
            instance = new StringUtils();
        }

        return instance;
    }

    public String formatDateTime(LocalDateTime dateTime) {
        return DateTimeFormatter.ofPattern(DATE_FORMAT).format(dateTime);
    }


    public String extractDomain(String link) {
        return link.split(DELIMITER)[DOMAIN_INDEX];
    }



    public String prepareQueryForGoogle(String raw) {
        return raw
                .replace(COMMA, ENCODED_COMMA)
                .replace(SPACE, PLUS);
    }

    public String argsToQuery(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String arg : args) {
            builder.append(arg).append(SPACE);
        }
        return builder.toString();
    }

    public String obtainStringQuery(String preparedQuery, int pageIdx) {
        return String.format(GOOGLE_SEARCH_QUERY, preparedQuery, pageIdx);
    }

    public String obtainFileName(LocalDateTime dateTime) {
        return FILE_PREFIX + formatDateTime(dateTime) + FILE_EXTENSION;
    }

    public String obtainFilePath(String FileName) {
        return PATH_DIRECTORY + FileName;
    }
    public String obtainResultRow(String result) {
        return String.format(RESULT_PATTERN, result, extractDomain(result));
    }
}
