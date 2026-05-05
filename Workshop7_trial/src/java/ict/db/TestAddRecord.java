
import ict.db.CustomerDB;

public class TestAddRecord {

    public static void main(String[] arg) {

        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        CustomerDB custDb = new CustomerDB(url, username, password);

        boolean isAdded = custDb.addRecord("1", "peter", "12345688", 21);
        if (isAdded) {
            System.out.println("peter is added");
       } else{
                System.out.println("added failed");
        }

          isAdded =        custDb.addRecord("2", "Nancy", "12345678", 21);
        if (isAdded) {
            System.out.println("Nancy is added");
       } else{
                System.out.println("added failed");
        }
         


    }
}
