package eyad;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteAccount {
    public static void delete(ArrayList<Account> list, TextArea textArea_accounts){
        Stage newwindow = new Stage ();
        newwindow.setTitle("Delete an account");

        Label websiteLB = new Label("The Website:");
        InterfaceStyling.labelStyling(websiteLB);
        Label emailLB = new Label("The Email:");
        InterfaceStyling.labelStyling(emailLB);


        TextField tfWebsite = new TextField();
        TextField tfEmail = new TextField();

        GridPane form = new GridPane();
        InterfaceStyling.add_delete_ModifyForm(form);
        form.addRow(0, websiteLB, tfWebsite);
        form.addRow(1, emailLB, tfEmail);

        Button submitButton = new Button("Delete Account");
        InterfaceStyling.buttonsStyling(submitButton);
        submitButton.setOnAction(e->{
            String web = tfWebsite.getText();
            String mail = tfEmail.getText();

            boolean found = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEmail().equalsIgnoreCase(mail) && list.get(i).getWebsite().equalsIgnoreCase(web)) {
                    found = true;
                    list.remove(i);
                    FileHandle.savaData(list);
                    newwindow.close();
                    InterfaceStyling.showAccounts(list, textArea_accounts);
                }
            }
            if (!found) {
                InterfaceStyling.alert("Account Not Found, Wrong Website or Email!!");
            }
            
        });
        
        
        VBox root = new VBox(10, form, submitButton);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: rgb(22, 22, 22);");

        newwindow.setScene(new Scene(root, 400, 300));
        newwindow.show();
    }
}
