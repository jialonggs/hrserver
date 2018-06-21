package org.sang.utils;

import java.text.DecimalFormat;

public class DoubleUtil {
    public static Double m2(Double number) {
        if(null == number){
            return 0.00;
        }
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(number));
}
}
