package pis.lab4.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.model.Actor;
import pis.lab4.demo.model.Film;
import pis.lab4.demo.model.Genre;
import pis.lab4.demo.model.enums.Role;
import pis.lab4.demo.repository.ActorRepository;
import pis.lab4.demo.repository.FilmRepository;
import pis.lab4.demo.repository.GenreRepository;
import pis.lab4.demo.service.AuthService;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;

@SpringBootApplication
public class EntityFirstDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntityFirstDemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner demoAdmin(AuthService authService,
                                       @Value("${spring.datasource.password}") String password,
                                       @Value("${spring.datasource.username}") String email) {
        return args -> {
            UserDto userDto = new UserDto();
            userDto.setFirstName("Admin");
            userDto.setSecondName("Admin");
            userDto.setEmail(email);
            userDto.setPassword(password);
            authService.signUp(userDto, Role.ADMIN);
 //           authService.signIn(userDto);
        };
    }
}
