package org.sang.mapper;


import org.sang.bean.MainEngine;

import java.util.List;

public interface MainEngineMapper {

    MainEngine getByName(String name);

    int addMainEngine(MainEngine mainEngine);

    List<MainEngine> getEngineList();

    MainEngine getById(Long id);

    int updateEngine(MainEngine mainEngine);

    List<MainEngine> getAll();
}
