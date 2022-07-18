package rbenitez.com.Customer.repository;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.repository.MongoRepository;
import rbenitez.com.Customer.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}*/

@Repository
public  interface CustomerRepository extends MongoRepository<Customer,String> {


}

