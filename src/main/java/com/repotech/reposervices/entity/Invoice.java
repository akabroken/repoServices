/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repotech.reposervices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author amahayak
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long invoiceId;
    private String invoiceNo;
    private String middlewareSn;
    private String invoiceDate;
}
