package com.csv.sample.repository;

import com.csv.sample.model.StoreOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository maintaining CRUD operations of store order
 * Spring Data JPA repository for the store order entity.
 *
 * @author Shehan
 */
@Repository
public interface StoreOrderRepository extends CrudRepository<StoreOrder, Long> {

}