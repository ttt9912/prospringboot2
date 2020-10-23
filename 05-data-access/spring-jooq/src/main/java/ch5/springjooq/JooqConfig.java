package ch5.springjooq;

import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import javax.sql.DataSource;

@Configuration
public class JooqConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    public DefaultDSLContext dsl() {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider());
        jooqConfiguration.set(new DefaultExecuteListenerProvider(exceptionTransformer()));
        return new DefaultDSLContext(jooqConfiguration);
    }

    private DefaultExecuteListener exceptionTransformer() {
        return new DefaultExecuteListener() {
            @Override
            public void exception(final ExecuteContext context) {
                SQLDialect dialect = context.configuration().dialect();
                SQLExceptionTranslator translator = new SQLErrorCodeSQLExceptionTranslator(dialect.thirdParty().springDbName());
                context.exception(translator.translate("Access database using jOOQ", context.sql(), context.sqlException()));
            }
        };
    }

}
