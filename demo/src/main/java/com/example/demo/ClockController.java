package com.example.demo;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ClockController {
    ClockShop shop = Fabric.build();
    Time c;
    @FXML
    public Label ID;
    @FXML
    public Label cloneMark;
    @FXML
    public Label cloneCost;
    @FXML
    public Label cloneType;
    @FXML
    public Label times;
    @FXML
    public void toSET(){
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
                alert.setTitle("Информационное окно");
                alert.setHeaderText(null);
                try {c.toSet(TYPES.valueOf(comboBox.getValue()),Integer.parseInt(textField.getText()));
                    alert.setContentText("Выбранные Вами часы "+c.toGet_Mark()+"за "+c.toGet_Cost()+" были выставлены на  время "+textField.getText()+" "+comboBox.getValue());}
                catch(TimeExcept e){alert.setContentText(e.getMessage());}
                alert.showAndWait();
                return null;}
            else { return null;}
        });
        dialog.showAndWait();
        times.setText(c.toGet_Time());}
    @FXML
    public void toMOVE(){Dialog<String> dialog = new Dialog<>();
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
                alert.setTitle("Информационное окно");
                alert.setHeaderText(null);
                try {c.toMove(TYPES.valueOf(comboBox.getValue()),Integer.parseInt(textField.getText()));
                    alert.setContentText("Выбранные Вами часы "+c.toGet_Mark()+"за "+c.toGet_Cost()+" были переведены на  время "+textField.getText()+" "+comboBox.getValue());}
                catch(TimeExcept e){alert.setContentText(e.getMessage());}
                alert.showAndWait();
                return null;}
            else { return null;}
        });
        dialog.showAndWait();
        times.setText(c.toGet_Time());}
    @FXML
    public void setClock(Time c) {
        this.c = c;
        cloneMark.setText(c.toGet_Mark());
        cloneCost.setText(Integer.toString(c.toGet_Cost()));
        cloneType.setText(c.toGet_Type());
        times.setText(c.toGet_Time());
        ID.setText("ID:"+(c.toGet_ID()+1));
    }
    @FXML
    protected void toRemove(){shop.remove(c); }
}
