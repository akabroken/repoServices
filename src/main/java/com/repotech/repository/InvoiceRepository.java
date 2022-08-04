/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repotech.repository;

import com.repotech.repomodel.InvoiceModel;
import com.repotech.reposervices.entity.Invoice;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amahayak
 */
@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceRepository, Long> {
    
    Collection<InvoiceModel> findByInvoiceNo(String invNo);

    public Invoice save(Invoice invoice);
}
