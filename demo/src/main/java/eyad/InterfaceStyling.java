package eyad;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfaceStyling {

    public static void labelStyling (Label lb) {
        lb.setStyle("-fx-text-fill:rgb(255, 255, 255);");
    }

    public static void parentPane (BorderPane root, TextArea textArea_accounts, List<Button> buttonList) {
        
        Label lbProgName = new Label("Account Handler");
        lbProgName.setStyle("-fx-text-fill: white;");

        HBox upper =new HBox(lbProgName);
        HBox lower =new HBox();
        VBox left = new VBox();
        VBox right =new VBox();

        root.setLeft(left);
        root.setTop(upper);
        root.setBottom(lower);
        root.setRight(right);
        root.setCenter(textArea_accounts);

        left.setAlignment(Pos.CENTER);
        upper.setAlignment(Pos.CENTER);

        left.setMinWidth(150);
        upper.setMinHeight(25);
        lower.setMinHeight(25);
        right.setMinWidth(25);

        root.setStyle("-fx-background-color: rgb(163, 152, 152)");
        left.setStyle("-fx-background-color: rgb(0, 0, 0);");
        upper.setStyle("-fx-background-color: rgb(22, 22, 22);");
        lower.setStyle("-fx-background-color: rgb(22, 22, 22);");
        right.setStyle("-fx-background-color: rgb(22, 22, 22);");
        
        for (Button bt :buttonList) {
            left.getChildren().add(bt);
        }
        
    }
    

    public static void alert (String string) {
        Stage alert = new Stage();
        alert.setTitle("Alert");
        Label message = new Label(string);
        message.setStyle("-fx-text-fill:rgb(255, 255, 255);");
        
        Button ok = new Button("OK");
        buttonsStyling(ok);
        ok.setOnAction(eh->{alert.close();});
        
        VBox layout = new VBox(20, message, ok);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: rgb(22, 22, 22);");
        
        alert.setScene(new Scene(layout, 300, 150));
        alert.showAndWait();
    }
    

    public static void add_delete_ModifyForm (GridPane form) {
        form.setVgap(10);
        form.setHgap(10);
        form.setPadding(new Insets(20));
        form.setAlignment(Pos.CENTER);
    }
    

    public static void showAccounts(ArrayList<Account> list, TextArea textArea_accounts) {
        textArea_accounts.setText(AccountList.accountList(list));
        textArea_accounts.setEditable(false);
        textArea_accounts.setStyle("-fx-text-fill:rgb(0, 0, 0);");
    }
    

    public static void buttonsListStyling(List<Button> buttonList) {
        for (Button bt :buttonList) {
            InterfaceStyling.buttonsStyling(bt);
            bt.setMaxWidth(Double.MAX_VALUE);
            bt.setPrefHeight(100);
        }
    }


    public static void buttonsStyling (Button bt) {
            bt.setStyle("-fx-background-color: rgb(60,55,55);-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: center-left;-fx-padding: 10 20;");
            bt.setOnMouseEntered(e->{bt.setStyle("-fx-background-color: rgb(109,107,107);-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: center-left;-fx-padding: 10 20;");});
            bt.setOnMouseExited(e->{bt.setStyle("-fx-background-color:rgb(60,55,55);-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: center-left;-fx-padding: 10 20;");});
    }
}

