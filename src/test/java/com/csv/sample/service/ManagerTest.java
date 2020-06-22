package com.csv.sample.service;

import com.csv.sample.model.StoreOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

import java.nio.file.Paths;
import java.util.List;

@SpringBootTest
@ActiveProfiles("integration-test")
@DirtiesContext
class ManagerTest {

    @Autowired
    StoreOrderManager manager;

    @Autowired
    StoreService storeService;

    @Autowired
    CvsFileProcessor cvsFileProcessor;

    @Test
    void start() {
        final String filePath = Paths.get("src", "test", "resources", "sales.csv").toString();
        ReflectionTestUtils.setField(cvsFileProcessor, "csvFileLocation", filePath);

        manager.start();
        final List<StoreOrder> storeList = storeService.getAllStoreDetails();
        Assertions.assertEquals(2, storeList.size());
    }
}