/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.repotech.reposervices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**
 *
 * @author amahayak
 */
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class Reposervices {

    public static void main(String... args) {
       // System.out.println("Hello World!");
       SpringApplication.run(Reposervices.class, args);
    }
}
