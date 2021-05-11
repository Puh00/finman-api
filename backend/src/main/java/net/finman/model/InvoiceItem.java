package net.finman.model;

import java.lang.reflect.Array;
import java.util.List;

public class InvoiceItem{
    private String name;
    private int amount;

    public String getName() {
        return name;
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
