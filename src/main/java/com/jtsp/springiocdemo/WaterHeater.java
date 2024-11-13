package com.jtsp.springiocdemo;

import org.springframework.stereotype.Component;

@Component // This annotation registers the class as a Spring bean
public class WaterHeater {

    public String heatWater() {
        return "Water heated to 95°C.";
    }
}
