package org.luapp.gq.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.luapp.gq.dao.PostDao;
import org.luapp.gq.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: 86150
 * @create: 2020/07/22
 **/
@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private PostDao postDao;

    public Post writePost(String title, String text, String category, String author) {
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthorId(author);
        postDao.savePost(post);

        return post;
    }
}