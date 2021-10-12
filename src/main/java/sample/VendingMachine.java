package main.java.sample;


import javafx.event.ActionEvent;

public interface VendingMachine {

    void selectProduct(ActionEvent event);
    void enterMoney(ActionEvent event);
    void displayChangeMessage(ActionEvent event);
    void loadingNewOptions(ActionEvent event);
}
