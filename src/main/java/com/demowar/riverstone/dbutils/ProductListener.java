package com.demowar.riverstone.dbutils;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


import com.demowar.riverstone.entity.DatabaseSequence;
import com.demowar.riverstone.entity.Product;
@Component
public class ProductListener extends AbstractMongoEventListener<Product> {
    @Autowired
    private MongoOperations mongoOperations;

    public long generateSequence(String seqName) {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq", 1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Product> event) {
        if (event.getSource().getProductId()==null || event.getSource().getProductId().isEmpty() ) {
            event.getSource().setProductId("P"+generateSequence(Product.Product_Seq_Name));
        }
    }

	
}
