/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repotech.repository;

import com.repotech.repomodel.InvoiceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author amahayak
 */
@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    
//    @Bean
//     CommandLineRunner initDatabase(InvoiceRepository repository) {
//
//    return args -> {
//      log.info("Preloading " + repository.save(new InvoiceModel("Bilbo Baggins", "burglar")));
//      log.info("Preloading " + repository.save(new InvoiceModel("Frodo Baggins", "thief")));
//    };
//  }
}
