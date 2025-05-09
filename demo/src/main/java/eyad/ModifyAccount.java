package eyad;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ModifyAccount {

    public static void modify(ArrayList<Account> list, TextArea textArea_accounts){
        
        Stage newwindow = new Stage ();
        newwindow.setTitle("Account Modifier");

        Label websiteLB = new Label("The Website:");
        InterfaceStyling.labelStyling(websiteLB);
        Label emailLB = new Label("The Email:");
        InterfaceStyling.labelStyling(emailLB);

        TextField tfWebsite = new TextField();
        TextField tfEmail = new TextField();
        
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
   
        Button searchButton = new Button("Search Account");
        InterfaceStyling.buttonsStyling(searchButton);

        GridPane form = new GridPane();
        InterfaceStyling.add_delete_ModifyForm(form);
        form.addRow(0, websiteLB, tfWebsite);
        form.addRow(1, emailLB, tfEmail);

        VBox layout = new VBox(15, form, searchButton, outputArea);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(15));
        layout.setStyle("-fx-background-color: rgb(22, 22, 22);");

        searchButton.setOnAction(e -> {
            String web = tfWebsite.getText();
            String mail = tfEmail.getText();
            boolean found = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getWebsite().equalsIgnoreCase(web) && 
                    list.get(i).getEmail().equalsIgnoreCase(mail)) {
                    
                    found = true;
                    outputArea.appendText("\nAccount found successfully!");
                    showModificationDialog(i,list,outputArea,textArea_accounts);
                    break;
                }
            }
            
            if (!found) {
                outputArea.appendText("Account Not Found, Wrong Website or Email!!");
            }
        
        });

        newwindow.setScene(new Scene(layout, 400, 300));
        newwindow.show();
    }


    private static void showModificationDialog(int index, ArrayList<Account> list, TextArea outputArea, TextArea textArea_accounts) {
        
        Stage modify = new Stage();
        modify.setTitle("Modify Account");
        
        ToggleGroup group = new ToggleGroup();
        RadioButton websiteBtn = new RadioButton("Website");
        RadioButton emailBtn = new RadioButton("Email");
        RadioButton passwordBtn = new RadioButton("Password");
        
        websiteBtn.setStyle("-fx-text-fill: white");
        emailBtn.setStyle("-fx-text-fill: white");
        passwordBtn.setStyle("-fx-text-fill: white");

        websiteBtn.setToggleGroup(group);
        emailBtn.setToggleGroup(group);
        passwordBtn.setToggleGroup(group);
        
        TextField inputField = new TextField();
        Button submitButton = new Button("Submit");
        InterfaceStyling.buttonsStyling(submitButton);
        
        submitButton.setOnAction(e -> {
            RadioButton selected = (RadioButton) group.getSelectedToggle();
            if (selected == null) {
                InterfaceStyling.alert("Error, Please select a field to modify");
                return;
            }
            
            String newValue = inputField.getText();
            if (newValue.isEmpty()) {
                InterfaceStyling.alert("Error, Please enter a new value");
                return;
            }
            
            switch (selected.getText()) {
                case "Website":
                    list.get(index).setWebsite(newValue);
                    outputArea.appendText("\nThe website has been changed");
                    break;
                case "Email":
                    list.get(index).setEmail(newValue);
                    outputArea.appendText("\nThe email has been changed");
                    break;
                case "Password":
                    list.get(index).setPassword(newValue);
                    outputArea.appendText("\nThe password has been changed");
                    break;
            }
            FileHandle.savaData(list);
            modify.close();
            InterfaceStyling.showAccounts(list, textArea_accounts);
        });
        
        Label ask = new Label("What do you want to modify?");
        InterfaceStyling.labelStyling(ask);

        VBox layout = new VBox(15, ask, websiteBtn, emailBtn, passwordBtn, inputField, submitButton);

        layout.setPadding(new Insets(15));
        layout.setStyle("-fx-background-color: rgb(22, 22, 22);");
        layout.setAlignment(Pos.CENTER);

        modify.setScene(new Scene(layout, 300, 250));
        modify.show();   
    }
}
