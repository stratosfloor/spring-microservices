package se.emilnoreen.school;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			SchoolRepository repo
	) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				Faker faker = new Faker();
				School s = School.builder()
						.name(faker.funnyName().name())
						.email(faker.funnyName().name() + "@gmail.com")
						.build();
				repo.save(s);
			}

		};
	}

}
