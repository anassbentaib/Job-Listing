package com.beanass.joblisting.controller;

import com.beanass.joblisting.repositry.PostRespositry;
import com.beanass.joblisting.model.Post;
import com.beanass.joblisting.repositry.SearchRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
@CrossOrigin(origins = "http://localhost:3000")

public class PostController {

    @Autowired
    PostRespositry repo;
    @Autowired
    SearchRepositry srepo;
    @GetMapping("/posts")
    @CrossOrigin(origins = "http://localhost:3000")

    public List<Post> getAllPosts(){
return repo.findAll();


    }

    @GetMapping("/posts/{text}")
    @CrossOrigin(origins = "http://localhost:3000")

    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin(origins = "http://localhost:3000")

    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
}

}
