package br.com.alura.models;
import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private boolean system = true;
    List<Purchase> purchases = new ArrayList<>();

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return this.limit;
    }

    public void setSystem(boolean systemOnOff) {
        this.system = systemOnOff;
    }

    public boolean getSystem() {
        return this.system;
    }

    public void addPurchaseToList(Purchase purchase) {
        this.purchases.add(purchase);
    }

    public List<Purchase> getPurchasesList() {
        return  this.purchases;
    }
}
