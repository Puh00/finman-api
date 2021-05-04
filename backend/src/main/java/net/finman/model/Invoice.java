package net.finman.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Invoice {
    private String source;
    private UUID serialNumber;
    private int vat;
    private String ocr;
    private String invoiceDate;
    private String expiryDate;
    private String bankgiro;
    private String seller;
    private Customer customer;
    private boolean isPaid;
    private List<Item> items;

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSerialNumber(UUID serialNumber) {
        this.serialNumber = serialNumber;
    }

    public UUID getSerialNumber() {
        return serialNumber;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public String getOcr() {
        return ocr;
    }

    public void setOcr(String ocr) {
        this.ocr = ocr;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getBankgiro() {
        return bankgiro;
    }

    public void setBankgiro(String bankgiro) {
        this.bankgiro = bankgiro;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    

    public void convertAndSetCustomerJsonToObject(String customer) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.customer = objectMapper.readValue(customer, Customer.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
