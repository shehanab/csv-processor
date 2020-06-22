package com.csv.sample;

import com.csv.sample.service.StoreOrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsvDataLoaderApplication implements CommandLineRunner {

    @Autowired
    private StoreOrderManager manager;

    public static void main(String[] args) {
        SpringApplication.run(CsvDataLoaderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        manager.start();
    }
}
