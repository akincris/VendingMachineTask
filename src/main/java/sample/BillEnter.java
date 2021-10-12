package main.java.sample;

public class BillEnter {
    public double one_bills;
    public double five_bills;
    public double ten_bills;
    public double twenty_bills;
    public double fifty_bills;
    public double hundred_bills;

    public BillEnter(double... enteredBills){
        this.one_bills=enteredBills[0];
        this.five_bills=enteredBills[1];
        this.ten_bills=enteredBills[2];
        this.twenty_bills=enteredBills[3];
        this.fifty_bills=enteredBills[4];
        this.hundred_bills=enteredBills[5];

    }

    public double totalEnteredBalance(){
        double balance=0;
        balance=balance+this.one_bills*Bills.ONE.getValue();
        balance=balance+this.five_bills*Bills.FIVE.getValue();
        balance=balance+this.ten_bills*Bills.TEN.getValue();
        balance=balance+this.twenty_bills*Bills.TWENTY.getValue();
        balance=balance+this.fifty_bills*Bills.FIFTY.getValue();
        balance=balance+this.hundred_bills*Bills.HUNDRED.getValue();

        return balance;
    }
}
