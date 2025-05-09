package eyad;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountSearch {

    public static void search (ArrayList<Account> list){
    Stage newwindow = new Stage ();
    newwindow.setTitle("Search for Account");

    Label websiteLB = new Label("The Website:");
    InterfaceStyling.labelStyling(websiteLB);

    TextField tfWebsite = new TextField();

    TextArea outputArea = new TextArea();
    outputArea.setEditable(false);

    Button searchButton = new Button("Search Account");
    InterfaceStyling.buttonsStyling(searchButton);

    GridPane form = new GridPane();
    InterfaceStyling.add_delete_ModifyForm(form);
    form.addRow(0, websiteLB, tfWebsite);

    VBox layout = new VBox(15, form, searchButton, outputArea);
    layout.setAlignment(Pos.CENTER);
    layout.setPadding(new Insets(15));
    layout.setStyle("-fx-background-color: rgb(22, 22, 22);");

    searchButton.setOnAction(e -> {
        String web = tfWebsite.getText();
        outputArea.clear();
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWebsite().equalsIgnoreCase(web)) {
                found = true;               
                outputArea.appendText("Email: "+list.get(i).getEmail()+"\n"+"Password: "+list.get(i).getPassword()+"\n\n");
            }
        }
        
        if (!found) {
            outputArea.appendText("There is no account for this website\n");
        }
    
    });

    newwindow.setScene(new Scene(layout, 400, 300));
    newwindow.show();
    }

}

