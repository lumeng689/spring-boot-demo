package org.luapp.es.repository;

import org.luapp.es.domain.SipBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SipRepository extends ElasticsearchRepository<SipBean, Integer> {
    /**
     * 自己定义的，按照sn查询
     */
    @Query("{\"bool\" : {\"must\" : {\"term\" : {\"sn\" : \"?0\"}}}}")
    Page<SipBean> findBySn(String sn, Pageable pageable);
}
