package com.epam.techtalk.spring.integration.planet.express.common;

/**
 * @TODO write class description
 */
public class MessagePreparer {
    public static String prepare(int indentation, String message) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < indentation * 2; i++) {
            builder.append(" ");
        }
        builder.append(message);
        return builder.toString();
    }
}
