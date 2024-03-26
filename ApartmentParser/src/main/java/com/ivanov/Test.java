package com.ivanov;


import com.ivanov.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        StringUtils util = StringUtils.getInstance();

        Document s = Jsoup.connect("https://ultra-details.ru/search/?search=iphone%207").get();
        System.out.println(s);

}}
//searchResult_2021-01-01_13:20:00.txt