package org.luapp.es.web;

import org.luapp.es.domain.SipBean;
import org.luapp.es.service.SipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sip")
public class SipController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SipService sipService;

    /**
     * 保存
     *
     * @param sipBean
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public Object save(SipBean sipBean) {
        return sipService.addSip(sipBean);
    }

    /**
     * 按照ID查詢
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getSipById")
    @ResponseBody
    public Object getSipById(Integer id) {
        SipBean sip = sipService.findSip(id);
        return sip;
    }


    @GetMapping(value = "/getSipList")
    @ResponseBody
    public Object getSipList() {
        List<SipBean> sips = sipService.findSipList();
        return sips;
    }

    @GetMapping(value = "/getSipByPage")
    @ResponseBody
    public Page<SipBean> getSipByPage(Integer pageNumber, Integer pageSize) {
        Page sips = sipService.findAll(pageNumber, pageSize);
        return sips;
    }


    @GetMapping(value = "/getSipBySn")
    @ResponseBody
    public Page<SipBean> getSipBySn(String sn, Integer pageNumber, Integer pageSize) {
        Page sips = sipService.findBySn(sn, pageNumber, pageSize);
        return sips;
    }

    @GetMapping(value = "/getSipByFuzzyQuery")
    @ResponseBody
    public Page<SipBean> getSipByFuzzyQuery(String field, String value, Integer pageNumber, Integer pageSize) {
        Page sips = sipService.findByFuzzyQuery(field, value, pageNumber, pageSize);
        return sips;
    }

    @GetMapping(value = "/search")
    @ResponseBody
    public Page<SipBean> search(String q, Integer pageNumber, Integer pageSize) {
        Page sips = sipService.search(q, pageNumber, pageSize);
        return sips;
    }


    @GetMapping(value = "/findByMutliQuery")
    @ResponseBody
    public Page<SipBean> getMutliQuery(String start, String end, String field, String value, Integer pageNumber, Integer pageSize) {
        Page sips = sipService.findByMutliQuery(start, end, field, value, pageNumber, pageSize);
        return sips;
    }
}