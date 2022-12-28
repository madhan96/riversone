package com.demowar.riverstone.dbutils;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.demowar.riverstone.entity.Category;
import com.demowar.riverstone.entity.DatabaseSequence;
@Component
public class CategoryListener extends AbstractMongoEventListener<Category>{
	 @Autowired
	    private MongoOperations mongoOperations;

	    public long generateSequence(String seqName) {
	        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
	                new Update().inc("seq", 1), options().returnNew(true).upsert(true),
	                DatabaseSequence.class);
	        return !Objects.isNull(counter) ? counter.getSeq() : 1;
	    }

	    @Override
	    public void onBeforeConvert(BeforeConvertEvent<Category> event) {
	        if ( event.getSource().getCategoryId()==null || event.getSource().getCategoryId().isEmpty()) {
	            event.getSource().setCategoryId("C"+generateSequence(Category.Category_Seq_Name));
	        }
	    }
}
