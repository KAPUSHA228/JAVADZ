package com.example.demo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class ClockController {
   ClockShop shop= Fabric.build();
  Clock c;  Clock2 c2;
    @FXML
    public Label cloneMark;
    @FXML
    public Label cloneCost;

    @FXML
    public Label cloneType;


    public void setClock1(Clock c) {
        this.c = c;
        cloneMark.setText(c.toGet_Mark());
        cloneCost.setText(Integer.toString(c.toGet_Cost()));
        cloneType.setText(c.toGet_Type());
    }
    public void setClock2(Clock2 c) {
        this.c2 = c;
        cloneMark.setText(c2.toGet_Mark());
        cloneCost.setText(Integer.toString(c2.toGet_Cost()));
        cloneType.setText(c.toGet_Type());
    }
    @FXML
    protected void toRemove(){
        /*if( cloneType.getText().equals("HM"))*/shop.remove(c);
       /* if( cloneType.getText().equals("HMS"))shop.remove(c);*/
    }





}
