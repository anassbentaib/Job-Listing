package com.beanass.joblisting.repositry;

import com.beanass.joblisting.model.Post;
import com.mongodb.client.MongoClient;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoCollection;

import com.mongodb.client.AggregateIterable;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Component
public class SearchRepositryImplimentaion implements SearchRepositry {
    @Autowired
    private MongoClient client; // Autowire MongoClient

    @Autowired
    private MongoConverter converter; // Autowire MongoConverter


    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts = new ArrayList<>();
        MongoDatabase database = client.getDatabase("fiverr");
        MongoCollection<Document> collection = database.getCollection("jobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));
result.forEach(doc -> posts.add(converter.read(Post.class, doc)));

        return posts;
    }
}
