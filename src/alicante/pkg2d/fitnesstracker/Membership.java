package alicante.pkg2d.fitnesstracker;

import java.util.Scanner;


public class Membership {
    public void mTransaction(){
        
        Scanner sc = new Scanner (System.in);
        String response;
        do{
            
        System.out.println("\n----------------------------");
        System.out.println("PAMEMBRO NA!");
        System.out.println("1. ADD MEMBERSHIP");
        System.out.println("2. VIEW MEMBERSHIP");
        System.out.println("3. UPDATE MEMBERSIP");
        System.out.println("4. DELETE MEMBERSHIP");
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
        System.out.println("Customer ID:");
        String cid = sc.next();
        System.out.println("Coach ID:");
        String coachid = sc.next();
        System.out.println("Workout ID:");
        String wid = sc.next();

        String sql = "INSERT INTO tbl_membership (m_status, m_expirationdate, c_id, coach_id, w_id) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, ms, med, cid, coachid, wid);


    }

    private void viewMembership() {
        config conf = new config();
        String Query = "SELECT * FROM tbl_membership";
        String[] Headers = {"Membership ID", "Customer_ID","Coach_ID", "Workout_ID", "MembershipStatus", "MembershipExpirationDate"}; 
        String[] Columns = {"m_id", "c_id", "coach_id", "w_id", "m_status", "m_expirationdate" };
        
        
        conf.viewRecords(Query, Headers, Columns);
    }
    private void updateMembership() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.println("Enter the ID to update: ");
        int id = sc.nextInt();  
        
        while(conf.getSingleValue("SELECT m_id FROM tbl_membership WHERE m_id = ?", id) == 0){
        System.out.println("Selected ID doesn't exist!");
        System.out.println("Select Membership ID Again: ");
        id = sc.nextInt();
        }
        
        System.out.println("New Membership Status: ");
        String nms = sc.next();
        System.out.println("New Membership Expiration Date: ");
        String nmed = sc.next();
        System.out.println("New Customer ID: ");
        String ncid = sc.next();
        System.out.println("New Coach ID: ");
        String ncoachid = sc.next();
        System.out.println("New Workout ID: ");
        String nwid = sc.next();
        
        String qry = "UPDATE tbl_membership SET m_status = ?, m_expirationdate = ?, c_id = ?, coach_id = ?, w_id = ? WHERE m_id = ?";
        
        
        conf.updateRecord(qry, nms, nmed, ncid, ncoachid, nwid, id);         
        
        
    }
    
    private void deleteMembership() {
        Scanner sc = new Scanner (System.in);
        config conf = new config();
        System.out.println("Enter the ID  to delete: ");
        int id = sc.nextInt();
        
        while(conf.getSingleValue("SELECT m_id FROM tbl_membership WHERE m_id = ?", id) == 0){
        System.out.println("Selected ID doesn't exist!");
        System.out.println("Select Membership ID Again: ");
        id = sc.nextInt();
        }
        
        String qry = "DELETE FROM tbl_membership WHERE m_id = ?";
        
       
        conf.deleteRecord(qry, id);
    }
}
    

