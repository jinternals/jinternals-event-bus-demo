package com.jinternals.activemq.consumer.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
public class TransactionManagerConfiguration {

    @Primary
    @ConditionalOnMissingBean
    @Bean("activemqConsumerTransactionManager")
    public PlatformTransactionManager activemqConsumerTransactionManager(
            @Qualifier("activemqJmsTransactionManager") PlatformTransactionManager activemqJmsTransactionManager,
            @Qualifier("transactionManager") PlatformTransactionManager dbTransactionManager

    ) {
        ChainedTransactionManager chainedTransactionManager = new ChainedTransactionManager(activemqJmsTransactionManager,dbTransactionManager);
        return chainedTransactionManager;
    }

    @Bean("transactionManager")
    public PlatformTransactionManager dbTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
