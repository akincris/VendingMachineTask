package main.java.sample;

public class Calculator implements CalculatorInterface{



    @Override
    public double calculateEnteredBills(BillEnter enteredBills){
        return enteredBills.totalEnteredBalance();
    };

}
