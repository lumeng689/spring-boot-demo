package org.luapp.xunwu.repository;

import org.junit.jupiter.api.Test;
import org.luapp.xunwu.ApplicationTests;
import org.luapp.xunwu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: 86150
 * @create: 2020/11/14
 **/


public class UserRepositoryTest extends ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        User user = userRepository.findById(1L).get();

//        Asserts("waliwali", user.getName());
    }
}
