package com.goleg.labo.Labo.course;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(CourseRepository repository) {
        return args -> {
			Course PBO = new Course(
				"Pemrograman Berorientasi Objek",
				LocalDate.of(2023, Month.JANUARY, 5)
			);
            Course Basdat = new Course(
                "Basis Data", 
                LocalDate.of(2023, Month.JANUARY, 10)
            );

            repository.saveAll(List.of(PBO, Basdat));
        };
    }

}
