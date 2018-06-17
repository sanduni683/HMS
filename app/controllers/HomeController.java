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
        Connection con = db.getConnection();

        Statement stmt= null;
        try {
            stmt = con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from  Users");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ok("Welcome "+ name);

    }
}

