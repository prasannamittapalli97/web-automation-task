package com.web.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestHelper {
    private static final Logger log = LoggerFactory.getLogger(TestHelper.class);

    public static String getOrderNumberFromConfirmation(String orderConfirmationContent) {
        Pattern regex = Pattern.compile("[A-Z]{9}");
        Matcher regexMatcher = regex.matcher(orderConfirmationContent);
        String orderNumber = null;
        while (regexMatcher.find()) {
            if (regexMatcher.group(0) != null) {
                orderNumber = regexMatcher.group(0);
            }
        }
        return orderNumber;
    }

    public static String randomAlphaNumeric(int count) {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
