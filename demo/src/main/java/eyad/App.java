package eyad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage){ 

        ArrayList<Account> list = FileHandle.loadData();
        
        //Define and Initialize
        BorderPane root = new BorderPane();
        TextArea textArea_accounts = new TextArea();
        Button btSearch = new Button("        Search");
        Button btExit = new Button("           Exit");
        Button btAccounts = new Button("       Accounts");
        Button btAddAccount = new Button("    Add Account");
        Button btDeleteAccount = new Button(" Delete Account");
        Button btModifyAccounts = new Button(" Modify Accounts");
        List<Button> buttons = Arrays.asList(btAccounts, btSearch, btAddAccount, btDeleteAccount, btModifyAccounts, btExit);
        
        //Styling all but Buttons
        InterfaceStyling.parentPane(root,textArea_accounts,buttons);

        //Button Styling
        InterfaceStyling.buttonsListStyling(buttons);

        //Left side Controls
        btAccounts.setOnAction(e->{
            InterfaceStyling.showAccounts(list, textArea_accounts);
        });

        btSearch.setOnAction(e->{
            AccountSearch.search(list);
        });

        btAddAccount.setOnAction(e->{
            AddAccount.add(list, textArea_accounts);
        });

        btDeleteAccount.setOnAction(e->{
            DeleteAccount.delete(list, textArea_accounts);
        });

        btModifyAccounts.setOnAction(e->{
            ModifyAccount.modify(list, textArea_accounts);
        });

       btExit.setOnAction(e-> {
            stage.close();
        });

        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}