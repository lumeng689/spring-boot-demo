package org.luapp.xunwu.spring;

import org.luapp.xunwu.entity.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author: 86150
 * @create: 2020/11/20
 **/
public class BeanDefinitionTest {

    public static void main(String[] args) {
        BeanDefinitionBuilder builder =  BeanDefinitionBuilder.genericBeanDefinition(User.class);

        builder.addPropertyValue("id", 3);
        builder.addPropertyValue("name", "zhangsan");

        BeanDefinition bd = builder.getBeanDefinition();

        GenericBeanDefinition gd = new GenericBeanDefinition();
        gd.setBeanClass(User.class);
        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.addPropertyValue("id", 3);
        mpv.addPropertyValue("name", "zhangsan");
        mpv.add("password", "134").add("email", "aaa");

        gd.setPropertyValues(mpv);

    }
}
