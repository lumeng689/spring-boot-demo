package com.nw.syn.repository;

import com.nw.syn.model.UserPublicView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPublicViewRepository extends PagingAndSortingRepository<UserPublicView, Long> {
}
