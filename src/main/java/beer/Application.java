package beer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import beer.entity.User;
import beer.repository.UserRepository;

@SpringBootApplication
@PropertySource("classpath:/redis.properties")
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    CommandLineRunner init(final UserRepository userRepository) {

        return new CommandLineRunner() {

            @Override
            public void run(String... arg0) throws Exception {
                userRepository.save(new User("xile", "password"));
            }
        };

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
