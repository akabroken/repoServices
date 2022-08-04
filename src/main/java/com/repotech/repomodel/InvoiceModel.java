/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repotech.repomodel;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *
 * @author amahayak
 */
@Entity
//@SuppressWarnings("PersistenceUnitPresent")
public class InvoiceModel /*implements Serializable */ {
    private @Id @GeneratedValue Long id;
    private String mw_sn; //Middleware serial number
    private String invoice_no;//Invoice number 

    public InvoiceModel() {
    }
    public InvoiceModel(String mw_sn, String invoice_no) {
        this.mw_sn = mw_sn; 
        this.invoice_no = invoice_no;
    }
    
    public long getId(){
        return this.id;
    }
    public String getMw_sn(){
        return this.mw_sn;
    }
    
    public String getInvoice_no(){
        return this.invoice_no;
    }
    
    public void getId(Long id){
        this.id = id;
    }
    
    public void getMw_id(String mw_sn){
        this.mw_sn = mw_sn;
    }
    
    
    public void getInvoice_no(String invoice_no){
        this.invoice_no = invoice_no;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this ==obj)
            return true;
        if(!(obj instanceof InvoiceModel))
            return false;
        InvoiceModel invmodel =(InvoiceModel)obj;
        return Objects.equals(this.id, invmodel.id)&&
                Objects.equals(this.mw_sn, invmodel.mw_sn)&&
                Objects.equals(this.invoice_no, invmodel.invoice_no);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(this.id,this.mw_sn, this.invoice_no);
    }
    
    @Override
    public String toString(){
        String jsonStr ="Employee{" + "id=" + this.id + ", name='" + this.mw_sn + '\'' + ", role='" + this.invoice_no + '\'' + '}';
        return jsonStr;
    }
    
}
