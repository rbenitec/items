package rbenitez.com.Customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rbenitez.com.Customer.entity.Item;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findByDniCustomer(@Param("dniCustomer") String dniCustomer);
}
