package org.sang.bean.responseEntity;

import org.sang.bean.Car;
import org.sang.bean.MainEngine;

public class CarResp  extends Car{

    private MainEngine engine;

    public MainEngine getEngine() {
        return engine;
    }

    public void setEngine(MainEngine engine) {
        this.engine = engine;
    }
}
