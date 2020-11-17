package org.luapp.xunwu.repository;

import org.luapp.xunwu.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
