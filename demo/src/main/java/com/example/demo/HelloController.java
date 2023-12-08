package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.util.Optional;

public class HelloController implements Server {
    ClockShop shop= Fabric.build();
    public HelloController(){
        shop.sub(this);
    }
    @FXML
    public TextField Cost;
    @FXML
    public TextField Mark;
    @FXML
    public TextField Type;
    @FXML
    public Label error;
    @FXML
    GridPane allClocks;
    @FXML
    public void toAddClock(){
       if(Type.getText().equals("HM")){/*error.setText("+++++");}*/shop.add(new Clock(Mark.getText(),Integer.parseInt(Cost.getText())));}
      /*else{error.setText("-------");}*/else{shop.add(new Clock2(Mark.getText(),Integer.parseInt(Cost.getText())));}
    }


    @Override
    public void event(ClockShop c) {
        allClocks.getChildren().clear();
        for (Clock p:shop){
        try { ClockController cc= new ClockController();
            FXMLLoader fxmlLoader=new FXMLLoader(ClockController.class.getResource("clocks.fxml"));
            fxmlLoader.setController(cc);
            Parent root = fxmlLoader.load();
            if(p instanceof Clock){cc.setClock1(p);}
            else{cc.setClock2((Clock2) p);}
            allClocks.addColumn(0,root);}
        catch (IOException e) {
            throw new RuntimeException(e);
        }}
    }
    public void toMegaSet(){
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Input Dialog");
        dialog.setHeaderText("Please enter your name:");
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);
        TextField textField = new TextField();
        textField.setPromptText("Введите количество времени");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("Выберите тип времени");
        comboBox.getItems().addAll("HOUR", "MIN", "SEC");
        VBox v= new VBox();
        v.getChildren().addAll(textField,comboBox);
        dialog.getDialogPane().setContent(v);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButton) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                try {
                    shop.MegaSet(TYPES.valueOf(comboBox.getValue()),Integer.parseInt(textField.getText()));
                    alert.setContentText("Часы выставлены на  время "+textField.getText()+" "+comboBox.getValue());}
                catch(TimeExcept e){alert.setContentText(e.getMessage());}
                alert.showAndWait();
                return null;
            }
            else { return null;}
       });dialog.showAndWait();}

        /*Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> System.out.println("Hello, " + name + "!"));*/

    public void toPopMark(){Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Наиболее часто встречающаяся марка часов: "+shop.PopMark());

        alert.showAndWait();}
    public void toHighCost(){Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Самые дорoгие часы имеют цену: "+shop.HighCost());
        alert.showAndWait();}
    public void toSorted(){Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Марки часов без повторений в упорядоченном виде:"+shop.Sorted());
        alert.showAndWait();}
}