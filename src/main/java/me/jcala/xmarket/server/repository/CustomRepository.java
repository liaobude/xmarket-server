package me.jcala.xmarket.server.repository;

import me.jcala.xmarket.server.entity.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class CustomRepository {
    private MongoTemplate template;

    @Autowired
    public CustomRepository(MongoTemplate template) {
        this.template = template;
    }

    public void updateUserSchool(String username, String school){
        template.updateFirst(new Query(where("username").is(username)),
                new Update().set("school",school), User.class);
    }
}