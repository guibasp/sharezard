package br.com.sharezard.beans;

import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
@EnableR2dbcRepositories
public class DatabaseConfig extends AbstractR2dbcConfiguration {

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        //ConnectionFactory factory = ConnectionFactories.get("r2dbc:h2:mem:///test?options=DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");

        //see: https://github.com/spring-projects/spring-data-r2dbc/issues/269
//        return new H2ConnectionFactory(
//                H2ConnectionConfiguration.builder()
//                        //.inMemory("testdb")
//                        .file("./testdb")
//                        .username("user")
//                        .password("password").build()
//        );

        return H2ConnectionFactory.inMemory("testdb");
    }

    @Bean
    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }
}   