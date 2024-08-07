package se.emilnoreen.student;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			StudentRepository repo
	) {
		return args -> {
			Random rand = new Random();
			for (int i = 0; i < 100; i++) {
				Faker faker = new Faker();
				Student s = Student.builder()
						.firstName(faker.name().firstName())
						.laseName(faker.name().lastName())
						.email(faker.name().firstName() + faker.name().lastName() + "@gmail.com")
						.schoolId(rand.nextInt(10)+1)
						.build();
				repo.save(s);
			}
		};
	}

}
