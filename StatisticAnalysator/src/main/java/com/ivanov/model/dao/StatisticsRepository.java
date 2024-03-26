package com.ivanov.model.dao;

import com.ivanov.model.entity.Statistics;

import java.util.List;

public interface StatisticsRepository {

    //CRUD

    List<Statistics> getAll();

    Statistics findByDomain(String domain);

    void save(Statistics statistics);

    void delete(Statistics statistics);

    void update(Statistics statistics);

    boolean exists(String domain);

}
