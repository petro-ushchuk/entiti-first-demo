package pis.lab4.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntityFirstDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntityFirstDemoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demoAdmin(AuthService authService,
//                                       @Value("${spring.datasource.password}") String password,
//                                       @Value("${spring.datasource.username}") String email) {
//        return args -> {
//            UserDto userDto = new UserDto();
//            userDto.setFirstName("Admin");
//            userDto.setSecondName("Admin");
//            userDto.setEmail(email);
//            userDto.setPassword(password);
//            authService.signUp(userDto, Role.ADMIN);
 //           authService.signIn(userDto);
//        };
//    }
}
