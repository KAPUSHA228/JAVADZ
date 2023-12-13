package com.example.demo;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import com.google.gson.Gson;

public class HelloController implements Server{
    ClockShop shop= Fabric.build();
    Time c;
    public HelloController(){ shop.sub(this); }
    int k=0;
    @FXML
    public Label lb;
    @FXML
    public Button bt;
    @FXML
    public TextField Cost;
    @FXML
    public TextField Mark;
    @FXML
    public TextField Type;
    @FXML
    public Label error;
    @FXML
    public GridPane allClocks;
    @FXML
    public void toAddClock(){
       if(Type.getText().equals("HM")){shop.add(new Clock(Mark.getText(),Integer.parseInt(Cost.getText()),0,0,k++));}
       if(Type.getText().equals("HMS")){shop.add(new Clock2(Mark.getText(),Integer.parseInt(Cost.getText()),0,0,0,k++));}

    }
    @FXML
    public void toSaveBin(){
        FileChooser fc= new FileChooser();
        File file=fc.showSaveDialog(lb.getScene().getWindow());
        if(file!=null){
            lb.setText("Файл сохранен в"+file.getAbsolutePath());
            try{
                ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(shop);
            }
            catch(IOException ex){
                System.out.println("ошибка записи тип 1");
            }
        }
    }
    @FXML
    public void toLoadBin(){
        FileChooser fc= new FileChooser();
        File file=fc.showOpenDialog(lb.getScene().getWindow());
        if(file!=null){
            lb.setText("Файл выгружен из"+file.getAbsolutePath());
            try{
                ObjectInputStream ois= new ObjectInputStream(new FileInputStream(file));
                ClockShop rm =(ClockShop) ois.readObject();
                for (Time c: rm){shop.add(c);}

            }
            catch(IOException ex){
                System.out.println("ошибка чтения тип 1");
            }
            catch(ClassNotFoundException ex)
            {
                System.out.println("ошибка чтения тип 2");
            }
        }
    }
    @FXML
    public void toSaveJSON(){
        FileChooser fc= new FileChooser();
        File file=fc.showSaveDialog(lb.getScene().getWindow());
        if(file!=null){
            lb.setText("Файл сохранен в"+file.getAbsolutePath());
            try{
                FileWriter oos= new FileWriter(file);
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .registerTypeAdapter(Time.class, new TimeAdapter())
                        .create();
                String str= gson.toJson(shop);
                oos.write(str);
                oos.close();
            }
            catch(IOException ex){
                System.out.println("ошибка записи тип 1");
            }
        }
    }
    @FXML
    public void toLoadJSON(){
        FileChooser fc= new FileChooser();
        File file=fc.showOpenDialog(lb.getScene().getWindow());
        if(file!=null){
            lb.setText("Файл выгружен из"+file.getAbsolutePath());
            try{
                FileReader reader = new FileReader(file);
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .registerTypeAdapter(Time.class, new TimeAdapter())
                        .create();
                ClockShop rm = gson.fromJson(reader, ClockShop.class);
                for (Time c :rm) {shop.add(c);}

            }
            catch(IOException ex){
                System.out.println("ошибка чтения тип 1");
            }


        }
    }
    @FXML
    public void toLoadSQL(){}
    @FXML
    public void toSaveSQL(){}

    @Override
    public void event(ClockShop c) {
        allClocks.getChildren().clear();
        for (Time p:shop){
        try { ClockController cc= new ClockController();
            FXMLLoader fxmlLoader=new FXMLLoader(ClockController.class.getResource("clocks.fxml"));
            fxmlLoader.setController(cc);
            Parent root = fxmlLoader.load();
            cc.setClock(p);
            allClocks.addColumn(0,root);}
        catch (IOException e) {
            throw new RuntimeException(e);
        }}
    }
    public void toMegaSet(){
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Диалоговое окно");
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
                try {shop.MegaSet(TYPES.valueOf(comboBox.getValue()),Integer.parseInt(textField.getText()));
                    alert.setContentText("Часы выставлены на  время "+textField.getText()+" "+comboBox.getValue());}
                catch(TimeExcept e){alert.setContentText(e.getMessage());}
                alert.showAndWait();
                return null;}
            else { return null;}
       });dialog.showAndWait();}
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