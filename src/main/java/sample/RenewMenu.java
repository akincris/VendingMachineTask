package main.java.sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class RenewMenu {

    private char[] lettterRows={'A','B','C','D','E','F','G','H','J'};
    private char[] numberColumns={'1','2','3','4','5','6','7','8','9'};
    private StringBuilder labelId=new StringBuilder();
     ArrayList<Label> productLabelStore =new ArrayList<>();


    public void resizeMenu(GridPane gridPane,int rows, int columns){
        Controller.labelsArrayList.clear();
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();
        gridPane.getChildren().clear();

        for (int i=0;i<rows+1;i++){
            RowConstraints newRow=new RowConstraints();
            gridPane.getRowConstraints().add(newRow);
        }
        for (int i=0;i<columns+1;i++){
            ColumnConstraints newColumn=new ColumnConstraints();
            gridPane.getColumnConstraints().add(newColumn);
        }


        for (int i=0;i<columns+1;i++){
            for (int j=0;j<rows+1;j++){
                Label label=new Label();
                labelId.setLength(0);

                if (i==0 && j==0){
                    labelId.append("");

                }else
                    if (i==0){
                        labelId.append(lettterRows[j-1]);
                        label.setStyle("-fx-background-color: #585858;"+"-fx-font-weight:bold;");
                        label.setTextFill(Color.valueOf("#7cacf2"));
                        label.setText(labelId.toString());
                    }else
                        if (j==0){
                            labelId.append(numberColumns[i-1]);
                            label.setStyle("-fx-background-color: #585858;"+ "-fx-font-weight:bold;");
                            label.setTextFill(Color.valueOf("#7cacf2"));
                            label.setText(labelId.toString());
                        }else {
                            labelId.append(lettterRows[j-1]);
                            labelId.append(numberColumns[i-1]);
                            label.setTextFill(Color.valueOf("#d8d8d8"));

                            Controller.labelsArrayList.add(label);
                        }


                        label.setMinWidth(Region.USE_COMPUTED_SIZE);
                        label.setMinHeight(Region.USE_COMPUTED_SIZE);
                        label.setMaxWidth(Region.USE_COMPUTED_SIZE);
                        label.setMaxHeight(Region.USE_COMPUTED_SIZE);
                        label.setPrefWidth(120);
                        label.setPrefHeight(20);
                        label.setAlignment(Pos.CENTER);

                label.setId(labelId.toString());



                gridPane.add(label,i,j);


            }

        }

    }

    public void insertNewProducts(ArrayList<Products> productsArrayList, ArrayList<Label> labelsArrayList){

        for (int i=0;i<productsArrayList.size();i++){
            labelsArrayList.get(i).setText(productsArrayList.get(i).getName());
        }

    }


}
