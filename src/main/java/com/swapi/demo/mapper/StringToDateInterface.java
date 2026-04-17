package com.swapi.demo.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface StringToDateInterface {
    default Date convertDateFormat(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = formatter.parse(dateString);
            System.out.println("Converted Date: " + date);
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format");
            return null;
        }
    }
}
