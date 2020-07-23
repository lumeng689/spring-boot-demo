package org.luapp.gq.dao;

import org.luapp.gq.entity.Author;

import java.util.List;
import java.util.Optional;

/**
 * @author: 86150
 * @create: 2020/07/21
 **/
public class AuthorDao {
    private List<Author> authors;

    public AuthorDao(List<Author> authors) {
        this.authors = authors;
    }

    public Optional<Author> getAuthor(String id) {
        return authors.stream().filter(author -> id.equals(author.getId())).findFirst();
    }
}
