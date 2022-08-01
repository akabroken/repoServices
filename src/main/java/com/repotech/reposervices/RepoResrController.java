/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repotech.reposervices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amahayak
 */
@RestController
@RequestMapping("reposervice")
public class RepoResrController {
     @GetMapping("welcome")
    public String repotest(){
        return "This is first reposervice";
    }
}
