package com.ivanov;


import com.ivanov.service.FileService;
import com.ivanov.service.GoogleParserService;
import com.ivanov.util.DateUtil;
import com.ivanov.util.StringUtils;

public class Main {
    public static void main(String[] args) {
        StringUtils utils = StringUtils.getInstance();
        FileService service = FileService.getInstance();
        GoogleParserService parserService = GoogleParserService.getInstance();

        service.createResultFile(
                utils.obtainFilePath(
                    utils.obtainFileName(
                            DateUtil.getInstance().getCurrentDate()
                    )
                )
        );

        String preparedQuery = utils.prepareQueryForGoogle(
                utils.argsToQuery(args)
        );

        service.writeResults(
                parserService
                        .setInterval(1, 10)
                        .setPreparedQuery(preparedQuery)
                        .execute()
                        .getResultLinks()
        );
    }
}
