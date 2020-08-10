package org.luapp.tpl.utils;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.luapp.tpl.vo.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;

/**
 * @author: 86150
 * @create: 2020/07/27
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class DroolsApplicationTest {

    private final static Logger logger = LoggerFactory.getLogger(DroolsApplicationTest.class);

    @Autowired
    private KieSession session;

    @Autowired
    private KieBase kieBase;

    @AfterEach
    public void runDispose() {
        logger.info("$$$$$$$$$$$$$$$$$$$");
        session.dispose();//释放资源
    }

    @Test
    public void people() {
        People people = new People();
        people.setName("达");
        people.setGender(0);
        people.setDrlType("people");

        System.out.println("=================================================");
        logger.info("###############################");
        session.insert(people);//插入
        session.fireAllRules();//执行规则
        System.out.println("--------------------------------------------------");
    }

}

