package org.luapp.es.conf;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "org.luapp.es.repository")
public class EsConfig {
    private final static Logger logger = LoggerFactory.getLogger(EsConfig.class);
}
