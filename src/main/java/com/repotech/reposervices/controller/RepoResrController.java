/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repotech.reposervices.controller;

import com.repotech.repomodel.InvoiceModel;
import com.repotech.reposervices.entity.Invoice;
import com.repotech.reposervices.service.invoiceService;
import com.repotech.repository.InvoiceRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amahayak
 */
@RestController
@RequestMapping("reposervice")
public class RepoResrController {
    
    private final InvoiceRepository repository; 
    
    RepoResrController(InvoiceRepository repository){
        this.repository = repository;
    }
    @Autowired private invoiceService invsrv;
    
     @GetMapping("welcome")
    public String repotest(){
        return "This is first reposervice";
    }
    
    @PostMapping("/invoices")
    public Invoice saveInvoice(@Valid @RequestBody Invoice invoice ){
       return invsrv.saveInvoices(invoice);
    }
    
    //Read Ops
    @GetMapping("/invoices")
    public List<Invoice> fetchAllInvoices(){
        return invsrv.findAllInv();
    }
    
    //Update
    @PutMapping("/invoices/{id}")
    public Invoice updateInvoice(@RequestBody Invoice invoice, 
            @PathVariable("id") Long invId){
        return invsrv.updateInvoice(invoice, invId);
    }
    
    //Delete
    @DeleteMapping("/invoices/{id}")
    public String deleteInvoiceById(@PathVariable("id") Long invId){
        invsrv.deleteInvoiceById(invId);
        return "Deleted Successfully";
    }
    
     // Aggregate root
  // tag::get-aggregate-root[]
   // @GetMapping("Invoices")
   // List<InvoiceModel> all_Invoice(){
//       return repository.findAll();
    //}
    
}
