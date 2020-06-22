package com.csv.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreOrderManager {

    private final CvsFileProcessor cvsFileProcessor;
    private final StoreService storeService;

    @Autowired
    public StoreOrderManager(CvsFileProcessor cvsFileProcessor, StoreService storeService) {
        this.cvsFileProcessor = cvsFileProcessor;
        this.storeService = storeService;
    }

    public void start() {
        cvsFileProcessor.subscribe(storeService);
    }
}
