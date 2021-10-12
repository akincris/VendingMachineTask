package main.java.sample;

public class ProductRequest {
    public Products requestedProduct;
    public BillEnter enteredBills;

    public ProductRequest(Products selectedProduct, double... enteredBills){
        this.requestedProduct=Controller.selectedProduct;
        this.enteredBills= new BillEnter(enteredBills);
    }




}
