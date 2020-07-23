package org.luapp.gq.cfg;

import org.luapp.gq.dao.AuthorDao;
import org.luapp.gq.dao.PostDao;
import org.luapp.gq.entity.Author;
import org.luapp.gq.entity.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2020/07/22
 **/
@Configuration
public class GraphqlConfiguration {
    @Bean
    public PostDao postDao() {
        List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Post post = new Post();
                post.setId("Post" + authorId + postId);
                post.setTitle("Post " + authorId + ":" + postId);
                post.setText("Post " + postId + " + by author " + authorId);
                post.setAuthorId("Author" + authorId);
                posts.add(post);
            }
        }
        return new PostDao(posts);
    }

    @Bean
    public AuthorDao authorDao() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author();
            author.setId("Author" + authorId);
            author.setName("Author " + authorId);
            author.setThumbnail("http://example.com/authors/" + authorId);
            authors.add(author);
        }
        return new AuthorDao(authors);
    }
}
