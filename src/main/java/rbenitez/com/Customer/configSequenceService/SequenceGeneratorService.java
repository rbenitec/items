package rbenitez.com.Customer.configSequenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import java.util.Objects;
import rbenitez.com.Customer.entity.DbSequence;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public int getSecuenceNumber(String sequeName){
        //Obtener el nro de secuencia
        Query query = new Query(Criteria.where("idOperation").is(sequeName));

        //Update del nro de secuencia
        Update update = new Update().inc("seq", 1);
        //modificar en documento
        DbSequence counter = mongoOperations
                .findAndModify(query,update,FindAndModifyOptions.options().returnNew(true).upsert(true),
                        DbSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

}
