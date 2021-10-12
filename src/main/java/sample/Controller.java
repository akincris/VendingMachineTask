package main.java.sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Controller implements VendingMachine {


    private String letterId,numberId;
    private String changeMess;
    static StringBuilder productId=new StringBuilder();
    static Products selectedProduct;
    private BillEnter change;
    private Calculator calculator=new Calculator();

    @FXML
    private Label productIdLabel,productNameLabel, productPriceLabel,messageLabel;
    @FXML
    private GridPane gridPane;
    @FXML
    private  Label A1,A2,A3,A4,A5,B1,B2,B3,B4,B5,C1,C2,C3,C4,C5,D1,D2,D3,D4,D5,E1,E2,E3,E4,E5;
    @FXML
    private RadioButton btnA,btnB,btnC,btnD,btnE;
    @FXML
    private RadioButton btn1,btn2,btn3,btn4,btn5;
    @FXML
    private ToggleGroup letter,number;
    @FXML
    private Button loadingOptions,btnOk,enterBillsButton, payButton,loadButton;
    @FXML
    private TextField billsField;
    @FXML
    private VBox numberVbox;

    static ArrayList<Label>   labelsArrayList=new ArrayList<>();


    public void getLetter(ActionEvent event){
        if (btnA.isSelected()){
            letterId=btnA.getText();
        }
        else if (btnB.isSelected()){
            letterId=btnB.getText();
        }
        else if (btnC.isSelected()){
            letterId=btnC.getText();
        }
        else if (btnD.isSelected()){
            letterId=btnD.getText();
        }
        else {
            letterId=btnE.getText();
        }
        numberVbox.setVisible(true);
    }

    public void getNumber(ActionEvent event) {
        if (btn1.isSelected()) {
            numberId = btn1.getText();
        } else if (btn2.isSelected()) {
            numberId = btn2.getText();
        } else if (btn3.isSelected()) {
            numberId = btn3.getText();
        } else if (btn4.isSelected()) {
            numberId = btn4.getText();
        } else {
            numberId = btn5.getText();
        }
        productId.setLength(0);
        productId.append(letterId).append(numberId);
    }




    public  void showProducts(ActionEvent event){

 labelsArrayList.add(A1);
 labelsArrayList.add(A2);
 labelsArrayList.add(A3);
 labelsArrayList.add(B3);
 labelsArrayList.add(D5);
        Products product1=new Products("doritos",1,2.30);
        Products product2=new Products("pringles",10,1.50);
        Products product3=new Products("cheetos",10,1.90);
        Products product4=new Products("kitkat",10,3.50);
        Products product5=new Products("oreo",0,1.70);

        Products.productsArrayList.add(product1);
        Products.productsArrayList.add(product2);
        Products.productsArrayList.add(product3);
        Products.productsArrayList.add(product4);
        Products.productsArrayList.add(product5);

        for (int i=0;i<Products.productsArrayList.size();i++){
            labelsArrayList.get(i).setText(Products.productsArrayList.get(i).getName());
        }

    }


    @Override
    public void selectProduct(ActionEvent event){

        for (int i=0;i<labelsArrayList.size();i++){

                if(labelsArrayList.get(i).getId().equals(productId.toString())){
                productIdLabel.setText(productId.toString());
                productNameLabel.setText(Products.productsArrayList.get(i).getName());
                String priceString="$"+Double.toString(Products.productsArrayList.get(i).getPrice());
                productPriceLabel.setText(priceString);

                selectedProduct=Products.productsArrayList.get(i);
                if (selectedProduct.getAmount()!=0){
                    messageLabel.setText("Enter the bills ($1,$5,$10,$20,$50,$100)");
                    billsField.setVisible(true);
                    enterBillsButton.setVisible(true);
                    int productAmount=selectedProduct.getAmount();
                    productAmount--;
                    selectedProduct.setAmount(productAmount);


                }else {
                    messageLabel.setText("OUT OF "+selectedProduct.getName());
                    billsField.setVisible(false);
                    enterBillsButton.setVisible(false);
                }
            }
        }
    };



    @Override
    public void enterMoney(ActionEvent event){
        String introducedBalance=billsField.getText();
        double[] enteredBillsArray=Bills.stringToBills(introducedBalance);

        ProductRequest request=new ProductRequest(selectedProduct,enteredBillsArray);
        double totalBalance=calculator.calculateEnteredBills(request.enteredBills);
        if (totalBalance<selectedProduct.getPrice()){
            messageLabel.setText("Insufficient balance !!!");
        }else {
        messageLabel.setText("BALANCE: $"+totalBalance);

        double totalChange=totalBalance-request.requestedProduct.getPrice();

        changeMess="CHANGE: $"+totalChange;
        enterBillsButton.setVisible(false);


        }

    };

    @Override
    public void displayChangeMessage(ActionEvent event){
        billsField.setText("");
        messageLabel.setText(changeMess);

    };

    @Override
    public void loadingNewOptions(ActionEvent event){
        ReadNewProducts.readFromJsonFile("input.json",Products.productsArrayList);
        RenewMenu rMenu=new RenewMenu();
        rMenu.resizeMenu(gridPane,ReadNewProducts.rows,ReadNewProducts.columns);
        rMenu.insertNewProducts(Products.productsArrayList,labelsArrayList);
    }






}
