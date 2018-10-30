package com.nhn.pea.musicmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nhn.pea.musicmanager")
public class MusicmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicmanagerApplication.class, args);
	}

}
