package br.com.alura.models;

public class Purchase implements Comparable<Purchase> {
    private String purchaseName;
    private double purchasePrice;

    public Purchase(String purchaseName, double purchasePrice){
        this.purchaseName = purchaseName;
        this.purchasePrice = purchasePrice;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public String toString() {
        return "Descrição da compra: " + this.purchaseName + '\'' +
                "Valor da compra: " + this.purchasePrice;
    }

    @Override
    public int compareTo(Purchase otherPurchase) {
        return Double.valueOf(this.purchasePrice).compareTo(Double.valueOf(otherPurchase.getPurchasePrice()));
    }
}
