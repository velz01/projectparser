package com.ivanov.model.util;

import static com.ivanov.model.util.Constant.INDEX_OF_SEARCH_RESULT_FILE;
import static com.ivanov.model.util.Constant.SPACE;

public class ArgsParser {

    private static ArgsParser instance;

    private ArgsParser() {}

    public static ArgsParser getInstance() {
        if (instance == null) {
            instance = new ArgsParser();
        }
        return instance;
    }

    public String getSearchResultFile(String[] args) {
        return args[INDEX_OF_SEARCH_RESULT_FILE];
    }

    public String getCategory(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            if (i + 1 < args.length) {
                sb.append(args[i]).append(SPACE);
            } else {
                sb.append(args[i]);
            }
        }

        return String.format("%s.txt", sb);
    }

}
