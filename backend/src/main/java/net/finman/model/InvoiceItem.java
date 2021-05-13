package net.finman.model;


public class InvoiceItem{
    private String name;
    private int amount;
    private int price;

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setName(String name) {
        this.name = name;
    }
}
