package com.learnkafkastreams.utils;

import org.apache.kafka.common.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
public class TestUtils {

    public static File tempDirectory() {
        final File file;
        try {
            file = Files.createTempDirectory("blip").toFile();
        } catch (final IOException ex) {
            throw new RuntimeException("Failed to create a temp dir", ex);
        }
        file.deleteOnExit();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    Utils.delete(file);
                } catch (IOException e) {
                    System.out.println("Error deleting " + file.getAbsolutePath());
                }
            }
        });

        return file;
    }
}
