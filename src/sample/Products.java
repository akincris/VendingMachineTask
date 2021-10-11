package sample;

import java.util.ArrayList;

public class Products {

    private String name;
    private String productId;
    private int amount;
    private double price;

    static ArrayList<Products> productsArrayList=new ArrayList<>();


    Products(String name, String productId,int amount,double price){
        this.name=name;
        this.productId=productId;
        this.amount=amount;
        this.price=price;
    }

    public String getName(){

        return name;
    }

    public String getProductId(){
        return productId;
    }
    public int getAmount(){

        return amount;
    }
    public double getPrice(){

        return price;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setProductId(String productId){
        this.productId=productId;
    }

    public void setAmount(int amount){
        this.amount=amount;
    }

    public void setPrice(double price){
        this.price=price;
    }




}
