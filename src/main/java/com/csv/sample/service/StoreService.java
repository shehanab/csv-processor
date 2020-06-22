package com.csv.sample.service;

import com.csv.sample.repository.StoreOrderRepository;
import com.csv.sample.model.StoreOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class StoreService implements Observer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreService.class);

    private static final String SPLITTER = ",";
    private static final String STORE_ORDER_DATE_FORMAT = "dd.MM.yyyy";

    @Autowired
    private StoreOrderRepository storeOrderRepository;

    @Override
    public void onEvent(String string) {
        LOGGER.debug("Event received to process with content {}", string);
        processReadCsvRecord(string);
    }

    @Override
    public void onError(Throwable e) {
        LOGGER.error("Error occurred while processing read values", e);
    }

    @Override
    public void onComplete() {
        LOGGER.debug("File reading completed. Record count in the database {}", getAllStoreDetails().size());
    }

    public List<StoreOrder> getAllStoreDetails() {
        Iterable<StoreOrder> all = storeOrderRepository.findAll();
        List<StoreOrder> storeOrderBuilderList = (List<StoreOrder>) all;
        LOGGER.debug("Returning {} of store order details", storeOrderBuilderList.size());
        return storeOrderBuilderList;
    }

    public void processReadCsvRecord(String strLine) {
        LOGGER.debug("Line is - {}", strLine);

        String[] split = strLine.split(SPLITTER);

        if (split.length != 21) {
            LOGGER.debug("Invalid store order record");
            return;
        }

        try {
            StoreOrder storeOrder = new StoreOrder()
                    .setOrderId(split[1])
                    .setOrderDate(new SimpleDateFormat(STORE_ORDER_DATE_FORMAT).parse(split[2]))
                    .setShipDate(new SimpleDateFormat(STORE_ORDER_DATE_FORMAT).parse(split[3]))
                    .setShipMode(split[4])
                    .setCustomerId(split[5])
                    .setCustomerName(split[6])
                    .setProductId(split[13])
                    .setCategory(split[14])
                    .setProductName(split[16])
                    .setQuantity(Integer.valueOf(split[18]))
                    .setDiscount(new BigDecimal(split[19]))
                    .setProfit(new BigDecimal(split[20]));
            saveStoreOrder(storeOrder);
        } catch (Exception e) {
            LOGGER.debug("Exception occurred while processing", e);
        }

    }

    public void saveStoreOrder(StoreOrder storeOder) {
        LOGGER.debug("Saving a new store order {}", storeOder);
        if (storeOder != null) {
            StoreOrder savedStoreOrder = storeOrderRepository.save(storeOder);
            LOGGER.info("Saved store order {}", savedStoreOrder);
        } else {
            LOGGER.debug("Invalid store order");
        }

    }

    public Optional<StoreOrder> getStoreOrderById(Long id) {
        return storeOrderRepository.findById(id);
    }

}
