package com.ivanov.service;

import com.ivanov.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.ivanov.util.Constant.ANCHOR_NESTED_SPAN;
import static com.ivanov.util.Constant.HYPER_REFERENCE;

public class GoogleParserService {

    private static GoogleParserService instance;

    private GoogleParserService() {
        resultLinks = new ArrayList<>();
    }

    public static GoogleParserService getInstance() {
        if (instance == null) {
            instance = new GoogleParserService();
        }
        return instance;
    }

    private int startPageIndex;
    private int endPageIndex;

    private List<String> resultLinks;
    private String preparedQuery;

    public GoogleParserService setInterval(int fromPage, int toPage) {
        this.startPageIndex = fromPage;
        this.endPageIndex = toPage;
        return this;
    }

    public GoogleParserService setPreparedQuery(String preparedQuery) {
        this.preparedQuery = preparedQuery;
        return this;
    }

    public GoogleParserService execute() {
        for (int index = startPageIndex; index < endPageIndex; index++) {
            String stringQuery = StringUtils.getInstance().obtainStringQuery(preparedQuery, index);
            try {
                parsing(Jsoup.connect(stringQuery).get());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }




    public List<String> getResultLinks() {
        return resultLinks;
    }

    private void parsing(Document doc) {
        Elements link = doc.select(ANCHOR_NESTED_SPAN);

        for (Element elem : link) {
            if (elem.hasAttr(HYPER_REFERENCE)) {
                if (!resultLinks.contains(elem.attr(HYPER_REFERENCE))) {
                    resultLinks.add(elem.attr(HYPER_REFERENCE));
                }
            }
        }
    }
}
