package me.bouzri.multipledatasource.todo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = SecondUser.class,
        entityManagerFactoryRef = "todosEntityManagerFactory",
        transactionManagerRef = "todosTransactionManager"
)
public class TodoJpaConfiguration {

    @Bean("todosEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean todosEntityManagerFactory(
            @Qualifier("todosDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
        Map<String, String> properties = new HashMap<>();
        properties.put("spring.jpa.hibernate.ddl-auto", "create");
        return builder
                .dataSource(dataSource)
                .packages(SecondUser.class)
                .properties(properties)
                .build();
    }

    @Bean
    public PlatformTransactionManager todosTransactionManager(
            @Qualifier("todosEntityManagerFactory") LocalContainerEntityManagerFactoryBean todosEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(todosEntityManagerFactory.getObject()));
    }
}