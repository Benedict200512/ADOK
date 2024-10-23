package alicante.pkg2d.fitnesstracker;

import java.util.Scanner;


public class Customer {
    
    public void cTransaction(){
        
        Scanner sc = new Scanner (System.in);
        String response;
        do{
        
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Enter Action: ");
        int action = sc.nextInt();
        Customer cs = new Customer ();
        

        switch(action){
            case 1:
                cs.addCustomers();           
                break;
            case 2:       
                cs.viewCustomers();
                break;
            case 3:
                cs.viewCustomers();
                cs.updateCustomers();
                cs.viewCustomers();
                break;
            case 4:
                cs.viewCustomers();
                cs.deleteCustomers();
                cs.viewCustomers();    
                break;
        }
        System.out.println("Do you want to continue? (yes/no)");
        response = sc.next();
    }while(response.equalsIgnoreCase("yes"));
    System.out.println("Thank You, See you soonest!");
    
    }
    
    
    public void addCustomers(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("First Name: ");
        String fname = sc.next();
        System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("Status: ");
        String stat = sc.next();
        System.out.print("Email: ");
        String em = sc.next();

        String sql = "INSERT INTO tbl_customers (c_fname, c_lname, c_status, c_email) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, fname, lname, stat, em);


    }

    private void viewCustomers() {
        config conf = new config();
        String Query = "SELECT * FROM tbl_customers";
        String[] Headers = {"Customers_ID","FirstName", "LastName", "Status", "Email"};
        String[] Columns = {"c_id", "c_fname", "c_lname", "c_status", "c_email"};
        
        
        conf.viewRecords(Query, Headers, Columns);
    }
    private void updateCustomers() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the ID to update: ");
        int id = sc.nextInt();
        
        System.out.println("New First Name: ");
        String nfname = sc.next();
        
        System.out.println("New Last Name: ");
        String nlname = sc.next();
        
        System.out.println("New Status: ");
        String nstat = sc.next();
        
        System.out.println("New Email: ");
        String nem = sc.next();
        
        String qry = "UPDATE tbl_customers SET c_fname = ?, c_lname = ?, c_status = ?, c_email = ? WHERE w_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, nstat, nem, id);         
        
        
    }
    
    private void deleteCustomers() {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter the ID  to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_customers WHERE c_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}

