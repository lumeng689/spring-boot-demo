package org.luapp.gq.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.luapp.gq.dao.PostDao;
import org.luapp.gq.entity.Author;
import org.luapp.gq.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: 86150
 * @create: 2020/07/21
 **/
@Component
public class AuthorResolver implements GraphQLResolver<Author> {

    @Autowired
    private PostDao postDao;

    public List<Post> getPosts(Author author) {
        return postDao.getAuthorPosts(author.getId());
    }
}
