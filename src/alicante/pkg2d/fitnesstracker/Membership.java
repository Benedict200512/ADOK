package alicante.pkg2d.fitnesstracker;

import java.util.Scanner;


public class Membership {
    public void wTransaction(){
        
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
        Membership mb = new Membership ();
        

        switch(action){
            case 1:
                mb.addMembership();           
                break;
            case 2:       
                mb.viewMembership();
                break;
            case 3:
                mb.viewMembership();
                mb.updateMembership();
                mb.viewMembership();
                break;
            case 4:
                mb.viewMembership();
                mb.deleteMembership();
                mb.viewMembership();    
                break;
        }
        System.out.println("Do you want to continue? (yes/no)");
        response = sc.next();
    }while(response.equalsIgnoreCase("yes"));
    System.out.println("Thank You, See you soonest!");
    
    }
    
    
    public void addMembership(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Membership Status: ");
        String ms = sc.next();
        System.out.print("Membership Expiration Date: ");
        String med = sc.next();

        String sql = "INSERT INTO tbl_membership (w_date, w_type, w_duration, caloriesburned) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, date, type, dura, cb);


    }

    private void viewMembership() {
        config conf = new config();
        String Query = "SELECT * FROM tbl_workouts";
        String[] Headers = {"Workouts_ID","Date", "Type", "Duration", "CaloriesBurned"};
        String[] Columns = {"w_id", "w_date", "w_type", "w_duration", "caloriesburned"};
        
        
        conf.viewRecords(Query, Headers, Columns);
    }
    private void updateMembership() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the ID to update: ");
        int id = sc.nextInt();
        
        System.out.println("New Date: ");
        String ndate = sc.next();
        
        System.out.println("New Type: ");
        String ntype = sc.next();
        
        System.out.println("New Duration: ");
        String ndura = sc.next();
        
        System.out.println("New CaloriesBurned: ");
        String ncb = sc.next();
        
        String qry = "UPDATE tbl_workouts SET w_date = ?, w_type = ?, w_duration = ?, caloriesburned = ? WHERE w_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, ndate, ntype, ndura, ncb, id);         
        
        
    }
    
    private void deleteMembership() {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter the ID  to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_workouts WHERE w_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
    

