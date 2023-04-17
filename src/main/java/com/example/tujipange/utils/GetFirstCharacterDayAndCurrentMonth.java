package com.example.tujipange.utils;

import org.w3c.dom.ls.LSOutput;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

/**
 * @author Nicholas Nzovia
 * @On 17/04/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

public class GetFirstCharacterDayAndCurrentMonth {
   public static  String getCurrentDayAndMonth(){
       Format format = new SimpleDateFormat("EEEE");
       String dayOfWeek = format.format(new Date());
       LocalDate today = LocalDate.now();
       Month presentMonth = today.getMonth();

       //getting the first two characters of both day and month consecutively
       var charMonth = presentMonth.toString().substring(0,2).toUpperCase();
       var charDay = dayOfWeek.substring(0,2);

       String dayMonth = charMonth+charDay;

       return  dayMonth;
   }

}
