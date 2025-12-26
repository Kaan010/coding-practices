package com.kaan.practice.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class InputReader {
    private InputReader() {}

    public static List<String> readLines(String resourcePath) {
        try (InputStream is = InputReader.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IllegalArgumentException("Resource not found: " + resourcePath);
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                return br.lines().toList();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read resource: " + resourcePath, e);
        }
    }

    public static String readString(String resourcePath) {
        return String.join("\n", readLines(resourcePath));
    }
}
