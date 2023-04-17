package com.example.tujipange.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.example.tujipange.utils.GetFirstCharacterDayAndCurrentMonth.getCurrentDayAndMonth;

/**
 * @author Nicholas Nzovia
 * @On 26/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Component
public class GenerateRandomNumberService {
    public  String generateRandomNumber(){
        var randomNumber = UUID.randomUUID().toString();
        var generatedString = randomNumber.substring(0,5).toUpperCase();

        //Complete random number = 4character for day and month plus random number
        var dayMonth = getCurrentDayAndMonth();
        return  dayMonth+generatedString;
    }
}
