package com.beanass.joblisting.repositry;

import com.beanass.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRespositry extends MongoRepository<Post,String>
{

}
