package net.finman.model;

import java.util.List;
import java.util.UUID;

public class Invoice {
    private UUID serialNumber;
    private String invoiceNumber;
    private int vat;
    private String ocr;
    private String invoiceDate;
    private String expiryDate;
    private String bankgiro;
    private String regNumber;
    private int seller;
    private int buyer;
    private List<Item> items;

    public void setSerialNumber(UUID serialNumber) {
        this.serialNumber = serialNumber;
    }

    public UUID getSerialNumber() {
        return serialNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public int getBuyer() {
        return buyer;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
