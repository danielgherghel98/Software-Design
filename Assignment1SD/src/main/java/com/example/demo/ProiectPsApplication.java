package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.ControllerPersistenta;


@SpringBootApplication
public class ProiectPsApplication {

	public static void main(String[] args) {
		ControllerPersistenta c=new ControllerPersistenta();
		c.run();
	}
}
