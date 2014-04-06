/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amil.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Orlando
 */
public class DataUtil {

    private final static SimpleDateFormat formatter;

    static {
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }

    public static Date stringToDate(String dataString) {
        Date date = null;
        try {
            date = formatter.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date) {
        return formatter.format(date);
    }
}
