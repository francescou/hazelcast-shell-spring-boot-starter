package it.uliana.hazelcastshell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 *
 * Hazelcast Shell configuration class, loaded by META-INF/spring.factories
 *
 */

@Configuration
@ComponentScan(basePackageClasses = HazelcastService.class)
public class HazelcastConfiguration {

    private Logger log = LoggerFactory.getLogger(HazelcastConfiguration.class);

    @PostConstruct
    public void postConstruct() {
        log.info("Hazelcast shell configuration done.");
    }

}
