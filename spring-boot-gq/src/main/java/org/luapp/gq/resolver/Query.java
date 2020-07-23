package org.luapp.gq.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.luapp.gq.dao.AuthorDao;
import org.luapp.gq.dao.PostDao;
import org.luapp.gq.entity.Author;
import org.luapp.gq.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author: 86150
 * @create: 2020/07/22
 **/
@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private PostDao postDao;

    @Autowired
    private AuthorDao authorDao;

//    public List<Post> getRecentPosts(int count, int offset) {
//        return postDao.getRecentPosts(count, offset);
//    }

    /**
     *
     *    测试代码
     *
     *     {
     *         getRecentPosts(count: 3, offset: 0){
     *           id
     *           title
     *         }
     *     }
     *
     *
     * @param count
     * @param offset
     * @return
     */
    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }


    /**
     *  测试代码
     *  <code>
     *  {
     *    findOneAuthor(id: "Author1"){
     *      id
     *    }
     *  }</code>
     *
     * @param id
     * @return
     */
    public Author findOneAuthor(String id) {
        Optional<Author> opt = authorDao.getAuthor(id);

        if (opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }
}
