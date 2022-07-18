package rbenitez.com.Customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rbenitez.com.Customer.entity.Operation;

@Repository
public interface OperationRepository extends MongoRepository<Operation, Integer> {
}
