package com.pnonyusa.shared.dto.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

// it generate random public ids for security purpose
@Component
public class Utils {

    private final Random RANDOM=new SecureRandom();

    private final String ALPHABETS="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateId(int length){
        return generateRandomKey(length);
    }


    //it appends random character from ALPHABETS reference
    private String generateRandomKey(int len){
        StringBuilder value =new StringBuilder();
        for(int x=0;x<len;x++){
            value.append(ALPHABETS.charAt(RANDOM.nextInt(ALPHABETS.length())));
        }

        //it reverse the key to be returned

        value.reverse();
        return value.toString();
    }

}
