package com.csv.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;


@Component
public class CvsFileProcessor implements Observable {

    private static final Logger LOGGER = LoggerFactory.getLogger(CvsFileProcessor.class);

    private final String csvFileLocation;

    @Autowired
    public CvsFileProcessor(@Value("${csv.file.location:@null}") String csvFileLocation) {
        this.csvFileLocation = csvFileLocation;
    }

    @Override
    public void subscribe(Observer observer) {
        start(observer);
    }

    private void start(Observer observer) {
        try (final FileReader fileReader = new FileReader(csvFileLocation);
             final BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String nextLine = bufferedReader.readLine();
            LOGGER.debug("First line {}", nextLine);

            int lineCount = 0;
            // Read lines from the file, returns null when end of stream is reached
            while ((nextLine = bufferedReader.readLine()) != null) {
                observer.onEvent(nextLine);
                lineCount++;
            }
            LOGGER.debug("{} of lines processed", lineCount);
            observer.onComplete();

        } catch (Exception e) {
            LOGGER.debug("Error occurred while reading the file", e);
            observer.onError(e);
        }
    }

}
