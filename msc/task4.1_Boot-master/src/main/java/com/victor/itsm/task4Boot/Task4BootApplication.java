package com.victor.itsm.task4Boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@SpringBootApplication
public class Task4BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Task4BootApplication.class, args);
	}

	@RequestMapping( value = "/",method = RequestMethod.GET)
    @ResponseBody
	public String greeting() {
        return "greeting";
	}

}
