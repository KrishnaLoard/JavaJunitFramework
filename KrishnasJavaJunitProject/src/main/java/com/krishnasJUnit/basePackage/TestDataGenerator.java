package com.krishnasJUnit.basePackage;

import java.util.Random;
import java.util.UUID;

public class TestDataGenerator {

    private static final String[] domains = {"example.com", "testmail.com", "mailinator.com"};
    private static final String[] phonePrefixes = {"416", "647", "905"};

    public static String generateEmail() {
        String Email = "user" + UUID.randomUUID().toString().substring(0, 8) + "@" + domains[new Random().nextInt(domains.length)];
        System.out.println("Email Generated --> " + Email);
        return Email;
    }
}
