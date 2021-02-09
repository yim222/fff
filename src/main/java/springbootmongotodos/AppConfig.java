package springbootmongotodos;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
class ApplicationConfig extends AbstractMongoClientConfiguration {

  @Override
  protected String getDatabaseName() {
    return "test-spring-boot";
  }

//  @Override
//  protected String getMappingBasePackage() {
//    return "com.oreilly.springdata.mongodb";
//  }
}