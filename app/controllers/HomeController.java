package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.db.Database;
import play.mvc.*;

import views.html.*;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    Database db;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok("Home pageee");
    }

    public Result getUsers() {
        return ok("Users not found");
    }

    public Result welcome(String userName) {
        //first create a connection
        Connection con = db.getConnection();

        Statement stmt= null;

        String firstName="";
        String lastName="";

        try {

            //Second-- create a statement
            stmt = con.createStatement();
            //Execute the query, then the result will be a result set
            String query="select FirstName ,LastName FROM Users WHERE UserName ='" +userName+ "';";
            System.out.println(query);
            ResultSet rs=stmt.executeQuery(query);


            //iterate the result
            while(rs.next()){
                System.out.println(rs.getString(1) +" "+ rs.getString(2));
                firstName=rs.getString(1);
                lastName=rs.getString(2);
                System.out.println(firstName +" "+ lastName);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if user is not in db print as not found
        if (firstName=="" && lastName==""){
            return ok("User not found ");
        }
        else{
            return ok("Welcome "+ firstName + " " +lastName);
        }
    }

    public Result changeUserDetails(String userName) {
        //first create a connection
        Connection con = db.getConnection();

        Statement stmt= null;

        JsonNode body = request().body().asJson();
        String updateFirstName =body.get("firstName").asText();
        String updateLastName =body.get("lastName").asText();
        int age =body.get("age").asInt();

        int result=0;

        try {

            //Second-- create a statement
            stmt = con.createStatement();
            //Execute the query, then the result will be a result set
            String query="UPDATE Users SET firstName ='" +updateFirstName+ "', lastName ='"+ updateLastName+ "' WHERE UserName='"+ userName+ "';";
            System.out.println(query);
            result= stmt.executeUpdate(query);
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(result==0){
            return ok("User not found");
        }
        else{
            return ok("Welcome "+ updateFirstName + " " +updateLastName);
        }
    }

    public Result createUserDetails(){
        //first create a connection
        Connection con = db.getConnection();

        Statement stmt= null;

        JsonNode body = request().body().asJson();
        String createUserName =body.get("UserName").asText();
        String createPassword =body.get("Password").asText();
        String createTitle =body.get("Title").asText();
        String createFirstName =body.get("FirstName").asText();
        String createLastName =body.get("LastName").asText();
        String createDOB =body.get("DOB").asText();
        String createIDnumber =body.get("IDnumber").asText();
        String createGender =body.get("Gender").asText();
        int createMobileNumber =body.get("MobileNumber").asInt();
        int createTelephoneNumber =body.get("TelephoneNumber").asInt();
        String createEmailAddress =body.get("EmailAddress").asText();
        String createAddress =body.get("Address").asText();

        int result=0;

        try {

            //Second-- create a statement
            stmt = con.createStatement();
            //Execute the query, then the result will be a result set
            String query="INSERT INTO  Users (UserName, Password, Title, FirstName, LastName, DOB, IDnumber, Gender, MobileNumber, TelephoneNumber, EmailAddress, Address ) VALUES ('"+ createUserName +"','"+ createPassword +"','"+ createTitle +"','"+ createFirstName +"','"+ createLastName +"','"+ createDOB +"','"+ createIDnumber +"','"+ createGender +"','"+ createMobileNumber +"','"+ createTelephoneNumber +"','"+ createEmailAddress +"','"+ createAddress +"'); ";
            System.out.println(query);
            result= stmt.executeUpdate(query);
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(result==0){
            return ok("Cannot create a user,Please Check again!");
        }
        else{
            return ok("Welcome "+ createFirstName + " " +createLastName);
        }
    }
}

