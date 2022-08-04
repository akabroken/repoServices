/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repotech.reposervices.service;

import com.repotech.reposervices.entity.Invoice;
import com.repotech.repository.InvoiceRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author amahayak
 */
@Service
public class invoiceServiceImpl  implements invoiceService {
    
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    //Save Ops
    @Override
    public Invoice saveInvoices(Invoice invoice){
        return invoiceRepository.save(invoice);
    }
    
    //Read Ops

    /**
     *
     * @return
     */
    @Override
    public List<Invoice> findAllInv(){
        
//        List<Invoice> tete;
//        tete = (List<Invoice>)(Invoice)invoiceRepository.findAll();
        
      return (List<Invoice>)(Invoice)invoiceRepository.findAll();
     // return tete;
    }
    
      //  @Override
    public List<Invoice> findAllIIInv(){
        
//        List<Invoice> tete;
//        tete = (List<Invoice>)(Invoice)invoiceRepository.findAll();
        
      return (List<Invoice>)(Invoice)invoiceRepository.findAll();
     // return tete;
    }
    
    // Update operation
    @Override
    public Invoice updateInvoice(Invoice invoice, Long invoiceId){
        Invoice invDB = (Invoice) invoiceRepository.findById(invoiceId).get();
        
        if (Objects.nonNull(invoice.getInvoiceNo()) 
                &&!"".equalsIgnoreCase(invoice.getInvoiceNo())){
            invDB.setInvoiceNo(invoice.getInvoiceNo());
        }
        
        if(Objects.nonNull(invoice.getMiddlewareSn())
                && !"".equalsIgnoreCase(invoice.getMiddlewareSn())){
            invDB.setMiddlewareSn(invoice.getMiddlewareSn());
        }
        
        if(Objects.nonNull(invoice.getInvoiceDate())
                &&!"".equalsIgnoreCase(invoice.getInvoiceDate())){
            invDB.setInvoiceDate(invoice.getInvoiceDate());
        }
        
        return invoiceRepository.save(invDB);
    } 
    
    //Delete
    @Override
    public void deleteInvoiceById(Long invoiceId){
        invoiceRepository.deleteById(invoiceId);
    }
}
