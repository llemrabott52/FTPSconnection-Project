package com.monetique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.monetique.services.impl.TraitementServiceImpl;

@SpringBootApplication
public class ClearingAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
	
		SpringApplication.run(ClearingAppApplication.class, args);

	}



@Autowired
TraitementServiceImpl traitementServiceImpl;

	@Override
	public void run(String... args) throws Exception {
		traitementServiceImpl.traitementBatch();
	}
	
	

}

