package controllers;

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

    public Result welcome(String name) {
        //first create a connection
        Connection con = db.getConnection();

        Statement stmt= null;

        String firstName="";
        String lastName="";

        try {

            //Second-- create a statement
            stmt = con.createStatement();
            //Execute the query, then the result will be a result set
            String query="select FirstName ,LastName FROM Users WHERE UserName ='" +name+ "';";
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
}

