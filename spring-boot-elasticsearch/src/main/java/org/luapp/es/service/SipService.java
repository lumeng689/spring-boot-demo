package org.luapp.es.service;

import com.google.common.collect.Lists;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.luapp.es.domain.SipBean;
import org.luapp.es.repository.SipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SipService {

    @Autowired
    private SipRepository sipRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 添加sip
     *
     * @param sipBean
     */
    public SipBean addSip(SipBean sipBean) {
        if (sipBean.getId() == null) {
            sipBean.setId(new Date().getTime());
        }
        return sipRepository.save(sipBean);
    }

    /**
     * 按照id查询
     */
    public SipBean findSip(Integer id) {
        Optional<SipBean> opt = sipRepository.findById(id);
        return opt.get();
    }

    /**
     * 查询所有记录
     */
    public List<SipBean> findSipList() {
        Iterable<SipBean> elements = sipRepository.findAll();
        List<SipBean> list = Lists.newArrayList(elements);
        return list;
    }

    /**
     * 分页， 带条件
     */
    public Page<SipBean> findBySn(String sn, Integer pageNumber, Integer pageSize) {

        // TODO Auto-generated method stub
        QueryBuilder query = QueryBuilders.matchQuery("sn", sn);
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sipRepository.search(query, pageable);
    }

    /**
     * 分页
     */
    public Page<SipBean> findAll(Integer pageNumber, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sipRepository.findAll(pageable);
    }

    /**
     * 分页 模糊查询
     */
    public Page<SipBean> findByFuzzyQuery(String field, String value, Integer pageNumber, Integer pageSize) {
        QueryBuilder query = QueryBuilders.fuzzyQuery(field, value);
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sipRepository.search(query, pageable);
    }

    /**
     * 分页 时间排序
     */
    public Page<SipBean> findByMutliQuery(String start, String end, String field, String value, Integer pageNumber,
                                          Integer pageSize) {
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        long istart = format.parseDateTime(start).getMillis();
        long iend = format.parseDateTime(end).getMillis();
        BoolQueryBuilder query = QueryBuilders.boolQuery()
                .must(QueryBuilders.rangeQuery("time").lte(iend).gte(istart));
        if (field != null && !"".equals(field)) {
            query.must(QueryBuilders.fuzzyQuery(field, value));
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("sn"));
        //Pageable pageable2 = PageRequest.of(pageNumber, pageSize,Direction.ASC,"sn","time");

        return sipRepository.search(query, pageable);
    }

    public Page search(String q, Integer pageNumber, Integer pageSize) {
        BoolQueryBuilder query = QueryBuilders.boolQuery().should(
                QueryBuilders.termQuery("statusmsg", q)
        );
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        //Pageable pageable2 = PageRequest.of(pageNumber, pageSize,Direction.ASC,"sn","time");

        return sipRepository.search(query, pageable);
    }
}
