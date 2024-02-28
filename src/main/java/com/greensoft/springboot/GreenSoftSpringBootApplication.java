package com.greensoft.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLOutput;

@SpringBootApplication
public class GreenSoftSpringBootApplication {//implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(GreenSoftSpringBootApplication.class, args);
	}

	@Bean
	public ModelMapper model(){ return new ModelMapper();}
/*

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("GreenSoft"));
	}
*/

/*
	@Override
	public void run(String... args) throws Exception {
		String password = "KhushbuMahajan";
		System.out.println("------------------------------------------------");
		System.out.println(encrypt.encode(password));
		System.out.println("------------------------------------------------");
	}*/
}
