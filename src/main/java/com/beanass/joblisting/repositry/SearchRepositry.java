package com.beanass.joblisting.repositry;

import com.beanass.joblisting.model.Post;

import java.util.List;

public interface SearchRepositry {
    List<Post>findByText(String text);

}
