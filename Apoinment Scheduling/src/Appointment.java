/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime;// import the LocalTimme class
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammad Ali Murtaza
 */
public class Appointment {

    private int id;
    private int UserId;
    private int DentistID;
    private LocalDate dateOfAppoinemnt;
    private LocalTime timeOfAppoinment;
    private int duration;
    private int status;

//    Constructor
    public Appointment(int UserId, int DentistID, LocalDate dateOfAppoinemnt, LocalTime timeOfAppoinment, int duration, int status) {

        CreateAppointment(UserId, DentistID, dateOfAppoinemnt, timeOfAppoinment, duration);

    }

    private Appointment() {
        this.id = 0;
        this.UserId = 0;
        this.DentistID = 0;
        this.dateOfAppoinemnt = LocalDate.now();
        this.timeOfAppoinment = LocalTime.now();
        this.duration = 0;
        this.status = 0;
    }

//  Getter for id
    public int getid() {
        return this.id;
    }

//  Getter Setter for UserId
    public int getUserId() {
        return this.UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

//  Getter Setter for DentistId
    public int getDentisId() {
        return this.DentistID;
    }

    public void setDentisId(int dentisId) {
        this.DentistID = dentisId;
    }

//  Getter Setter for Date of Appointment
    public LocalDate getDateofAppoinment() {
        return this.dateOfAppoinemnt;
    }

    public void setDateOfAppoinment(LocalDate dateofappoinment) {
        this.dateOfAppoinemnt = dateofappoinment;
    }

    //  Getter Setter for Time of Appoinment
    public LocalTime getTimeofAppointment() {
        return this.timeOfAppoinment;
    }

    public void setTimeofAppoinment(LocalTime localTime) {
        this.timeOfAppoinment = localTime;
    }

//  Getter Setter for Duration of Appoinment
    public int getDurationofAppointment() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
//  Getter Setter for status
    public int getstatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private void CreateAppointment(int UserId, int DentistID, LocalDate dateOfAppoinemnt, LocalTime timeOfAppoinment, int duration) {
        UUID uniqueId = UUID.randomUUID();
        this.id = uniqueId.hashCode();
        this.UserId = UserId;
        this.DentistID = DentistID;
        this.dateOfAppoinemnt = dateOfAppoinemnt;
        this.timeOfAppoinment = timeOfAppoinment;
        this.duration = duration;
        String FilePath;
        FilePath = "src/apoinment/appointment" + this.DentistID + ".txt";

        try {

            File yourFile = new File(FilePath);
            yourFile.createNewFile(); // if file already exists will do nothing

            FileWriter writer = new FileWriter(FilePath, true);
            writer.write(this.id + "," + this.UserId + "," + this.DentistID + "," + this.dateOfAppoinemnt + "," + this.timeOfAppoinment
                    + "," + this.duration + "\n");
            writer.close();

//        this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Appointment> getScheduleofDenstist(int dentistId) {
        ArrayList<Appointment> appoinments = new ArrayList<>();

        String line;
        String[] appoinment;

        try {
            FileReader reader = new FileReader("src/apoinment/appointment" + this.DentistID + ".txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((line = bufferedReader.readLine()) != null) {

                appoinment = line.split(",");

                Appointment app = new Appointment();
                app.id = Integer.parseInt(appoinment[0]);
                app.UserId = Integer.parseInt(appoinment[1]);
                app.DentistID = Integer.parseInt(appoinment[2]);
                app.dateOfAppoinemnt = LocalDate.parse(appoinment[3]);
                app.timeOfAppoinment = LocalTime.parse(appoinment[4]);
                app.duration = Integer.parseInt(appoinment[5]);
                app.status = Integer.parseInt(appoinment[6]);
                

                appoinments.add(app);
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }


        return appoinments;
    }

}
