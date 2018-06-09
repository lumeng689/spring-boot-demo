package com.nw.syn.repository;

import com.nw.syn.model.OrgPublicView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgPublicViewRepository extends PagingAndSortingRepository<OrgPublicView, Long> {
}
