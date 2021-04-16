package net.finman.model;

public class Invoice {
  private int serialNumber;
  private String invoiceNumber;
  private int vat;
  private int ocr;
  private String invoiceDate;
  private String expiryDate;
  private String bankgiro;
  private int seller;
  private int buyer;

  public void setSerialNumber(int serialNumber) {
    this.serialNumber = serialNumber;
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

  public int getOcr() {
    return ocr;
  }

  public void setOcr(int ocr) {
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

}
