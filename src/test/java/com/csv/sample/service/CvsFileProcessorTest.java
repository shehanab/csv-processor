package com.csv.sample.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CvsFileProcessorTest {

    @Test
    void subscribe() {
        final String filePath = Paths.get("src", "test", "resources", "sales.csv").toString();
        final CvsFileProcessor cvsFileProcessor = new CvsFileProcessor(filePath);

        final Observer observerMock = Mockito.mock(Observer.class);
        cvsFileProcessor.subscribe(observerMock);

        Mockito.verify(observerMock, Mockito.times(2)).onEvent(Mockito.anyString());
        Mockito.verify(observerMock, Mockito.times(1)).onComplete();
    }

}