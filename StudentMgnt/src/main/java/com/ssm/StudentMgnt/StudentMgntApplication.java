package com.ssm.StudentMgnt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@OpenAPIDefinition(
		info = @Info(
				title = "Student Management API",
				description = "This project handles all student related operations",
				version = "1.0"
		)
)
@SpringBootApplication(scanBasePackages = {"com.ssm.StudentMgnt", "com.project.studentmgnt"})
@EnableCaching
public class StudentMgntApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMgntApplication.class, args);
	}
}
