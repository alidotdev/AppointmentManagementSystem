/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammad Ali Murtaza
 */
public class User {

    private int id;
    private String Name;
    private String Contact;
    private String Email;
    private String Password;
    private int role;                    // role 0 for dentist, 1 for staff, 2 for patient

    public User(String Name, String Contact, String Email,String Password, int role) {
        CreateUser(Name,  Contact,  Email, Password ,  role);
    }
   
    
    private  User(){
        this.id = 0;
        this.Name = "";
        this.Contact = "";
        this.Email = "";
        this.role = 0;
        this.Password = "";
    }

//  Getter Setter for id
    public int getid() {
        return this.id;
    }

//    public void setId(int id) {
//        this.role = role;
//    }
//  Getter Setter for Name
    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
   //  Getter Setter for Password
    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

//  Getter Setter for Contact
    public String getContact() {
        return this.Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

//  Getter Setter for Email
    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

//  Getter Setter for role
    public int getrole() {
        return this.role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void getInfo() {

        String[] roles = {"Dentist", "Staff", "Patient"};
        System.out.println("Personal Information of User");
        System.out.println("Name: " + this.Name);
        System.out.println("Contact Number: " + this.Contact);
        System.out.println("Email: " + this.Email);
        System.out.println("Role of User: " + roles[this.role]);

    }
    
    public void SetCurrentUser(){
        String FilePath = "src/CurrentUser.txt";
        try {

            File yourFile = new File(FilePath);
            yourFile.createNewFile(); // if file already exists will do nothing

            FileWriter writer = new FileWriter(FilePath, false);
            writer.write(this.id + "," + this.Name + "," + this.Contact + "," + this.Email + "," + this.Password + "," + this.role );
            writer.close();

//        this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> getAllDentists() {
        ArrayList<User> dentists = new ArrayList<>();
        String line;
        String[] profile;

        try {
            FileReader reader = new FileReader("src/dentists/Profiles.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((line = bufferedReader.readLine()) != null) {

                profile = line.split(",");

                User user = new User();
                user.id = Integer.parseInt(profile[0]);
                user.Name = profile[1];
                user.Contact = profile[2];
                user.Email = profile[3];
                user.role = Integer.parseInt(profile[4]);
                
                dentists.add(user);
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dentists;

    }
    
    public ArrayList<User> getAllPatients() {
        ArrayList<User> dentists = new ArrayList<>();
        String line;
        String[] profile;

        try {
            FileReader reader = new FileReader("src/patients/Profiles.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((line = bufferedReader.readLine()) != null) {

                profile = line.split(",");

                User user = new User();
                user.id = Integer.parseInt(profile[0]);
                user.Name = profile[1];
                user.Contact = profile[2];
                user.Email = profile[3];
                user.role = Integer.parseInt(profile[4]);
                
                dentists.add(user);
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dentists;

    }
    
//    public User getProfile(){
//        
//    }
    
    
    private void CreateUser(String Name, String Contact, String Email,String Password ,int role)
    {
        UUID uniqueId = UUID.randomUUID();
        this.id = uniqueId.hashCode();
        this.Name = Name;
        this.Contact = Contact;
        this.Email = Email;
        this.role = role;
        this.Password = Password;
        String FilePath = "src/Profiles.txt";
//        FilePath = switch (this.role) {
//            case 0 ->
//                "src/dentists/Profiles.txt";
//            case 1 ->
//                "src/staff/Profiles.txt";
//            default ->
//                "src/patients/Profiles.txt";
//        };

        try {

            File yourFile = new File(FilePath);
            yourFile.createNewFile(); // if file already exists will do nothing

            FileWriter writer = new FileWriter(FilePath, true);
            writer.write(this.id + "," + this.Name + "," + this.Contact + "," + this.Email + "," + this.Password + "," + this.role + "\n");
            writer.close();

//        this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
