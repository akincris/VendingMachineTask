package sample;


import javafx.event.ActionEvent;

public interface VendingMachine {

    void selectProduct(ActionEvent event);
    void enterMoney(ActionEvent event);
    void displayChangeMessage(ActionEvent event);
}
