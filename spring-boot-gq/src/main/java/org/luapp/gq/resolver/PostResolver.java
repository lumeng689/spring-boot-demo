package org.luapp.gq.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.luapp.gq.dao.AuthorDao;
import org.luapp.gq.entity.Author;
import org.luapp.gq.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author: 86150
 * @create: 2020/07/21
 **/
@Component
public class PostResolver implements GraphQLResolver<Post> {

    @Autowired
    private AuthorDao authorDao;

    public Optional<Author> getAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }
}