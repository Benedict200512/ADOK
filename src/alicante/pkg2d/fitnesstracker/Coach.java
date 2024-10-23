package alicante.pkg2d.fitnesstracker;

import java.util.Scanner;

public class Coach {
    public void coachTransaction(){
        
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
        Coach ch = new Coach ();
        

        switch(action){
            case 1:
                ch.addCoach();           
                break;
            case 2:       
                ch.viewCoach();
                break;
            case 3:
                ch.viewCoach();
                ch.updateCoach();
                ch.viewCoach();
                break;
            case 4:
                ch.viewCoach();
                ch.deleteCoach();
                ch.viewCoach();    
                break;
        }
        System.out.println("Do you want to continue? (yes/no)");
        response = sc.next();
    }while(response.equalsIgnoreCase("yes"));
    System.out.println("Thank You, See you soonest!");
    
    }
    
    
    public void addCoach(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("First Name: ");
        String fname = sc.next();
        System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("Age: ");
        String age = sc.next();
        System.out.print("Address: ");
        String add = sc.next();

        String sql = "INSERT INTO tbl_coach (coach_fname, coach_lname, coach_age, coach_address) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, fname, lname, age, add);


    }

    private void viewCoach() {
        config conf = new config();
        String Query = "SELECT * FROM tbl_coach";
        String[] Headers = {"Coach_ID","FirstName", "LastName", "Age", "Address"};
        String[] Columns = {"coach_id", "coach_fname", "coach_lname", "coach_age", "coach_address"};
        
        
        conf.viewRecords(Query, Headers, Columns);
    }
    private void updateCoach() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the ID to update: ");
        int id = sc.nextInt();
        
        System.out.println("New First Name: ");
        String nfname = sc.next();
        
        System.out.println("New Last Name: ");
        String nlname = sc.next();
        
        System.out.println("New Age: ");
        String nage = sc.next();
        
        System.out.println("New Address: ");
        String nadd = sc.next();
        
        String qry = "UPDATE tbl_coach SET coach_fname = ?, coach_lname = ?, coach_age = ?, coach_address = ? WHERE coach_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, nage, nadd, id);         
        
        
    }
    
    private void deleteCoach() {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter the ID  to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_coach WHERE coach_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
    

