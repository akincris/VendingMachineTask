package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;



public class Main extends Application {

    @Override
    public void start(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        window.setTitle("Vending Machine");
        Scene scene=new Scene(root);
        window.setScene(scene);
        window.show();



    }


    public static void main(String[] args) {
        launch(args);












    }
}
