package org.sang.common;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sang on 2018/1/13.
 */
public class DateConverter implements Converter<String,Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String s) {
        if ("".equals(s) || s == null) {
            return null;
        }
        try {
            if(s.length()< 12){
                return  simpleDateFormat2.parse(s);
            }
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}