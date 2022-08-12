package com.example;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<String> list = Arrays.asList("Gowse","Vishnu","Yovel","LokeshN");
        list.forEach(System.out::println);
    }
}
