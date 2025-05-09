package eyad;

import java.util.ArrayList;

public class AccountList {
   public static String accountList(ArrayList<Account> list) {
        if (list.isEmpty()) {
            return "No accounts found";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Account account : list) {
                sb.append(account.toString()).append("\n");
            }
            return sb.toString().trim();
        }
    }
}
