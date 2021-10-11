package sample;

public enum Bills {
    ONE(1),FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    private int value;

    Bills(int value){
        this.value=value;
    }

    public int getValue(){
        return this.value;
    }

    public static double[] stringToBills(String bills){
        String[] billsText=bills.split(" ");
        double[] result= new double[billsText.length];
        for (int i=0 ; i<billsText.length; i++){
            result[i]=Double.parseDouble(billsText[i]);
        }
        return result;

    }
}
