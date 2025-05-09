package eyad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AddAccount extends Account {

    public static void add(ArrayList<Account> list, TextArea textArea_accounts) {

        Stage newwindow = new Stage ();
        newwindow.setTitle("Add new account");

        Label websiteLB = new Label("The new Website:");
        Label emailLB = new Label("The new Email:");
        Label passLB = new Label("The new Password:");
        
        List<Label> labels = Arrays.asList(websiteLB, emailLB, passLB);
        for (Label lb :labels) {
            InterfaceStyling.labelStyling(lb);
        }

        TextField tfWebsite = new TextField();
        TextField tfEmail = new TextField();
        PasswordField pfPass = new PasswordField();

        GridPane form = new GridPane();
        InterfaceStyling.add_delete_ModifyForm(form);
        form.addRow(0, websiteLB, tfWebsite);
        form.addRow(1, emailLB, tfEmail);
        form.addRow(2, passLB, pfPass);
    
        Button submitButton = new Button("Create Account");
        InterfaceStyling.buttonsStyling(submitButton);

        submitButton.setOnAction(e->{
            String website = tfWebsite.getText();
            String email = tfEmail.getText();
            String pass = pfPass.getText();

            Account a = new Account(website, email, pass);
            list.add(a);
            FileHandle.savaData(list);
            
            newwindow.close();
            InterfaceStyling.showAccounts(list, textArea_accounts);
        });

        VBox root = new VBox(10, form, submitButton);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: rgb(22, 22, 22);");
        
        newwindow.setScene(new Scene(root, 400, 300));
        newwindow.show();
    }
}
