/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repotech.reposervices.service;

import com.repotech.reposervices.entity.Invoice;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author amahayak
 */
public interface invoiceService {
    //Save Ops
    Invoice saveInvoices(Invoice invoice);
    
    //Read Ops
    List<Invoice> findAllInv();
    
    //update Ops
    Invoice updateInvoice(Invoice invoice, Long invoiceId);
    
    //Delete Ops
    void deleteInvoiceById(Long invoiceId);
    
}
