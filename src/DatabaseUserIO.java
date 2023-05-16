import java.io.File;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseUserIO {

    static final String DB_URL = "jdbc:mysql://localhost/ICE";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "x";

    ArrayList<User> users = new ArrayList<>();

    File file;

    private static String currentUser;
    private static String currentId;

    public boolean login(String username, String password, String id) {
        if (username == null || password == null) {
            return false;
        }
        for (User user : users) {
            if (user.getUsername() != null && user.getPassword() != null
                    && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user.getUsername();
                currentId = user.getId();
                return true;
            }
        }
        return false;
    }

    public boolean createUser(String username, String password, String id) {

        users.add(new User(username, password, id, 99999));
        return true;
    }

    public void loadUsers() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database loading users");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT id, username, password, highscore FROM ice.user";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery(sql);

            //STEP 4: Extract data from result set
            while (rs.next()) {

                //Retrieve by column name

                String username = rs.getString("username");
                String password = rs.getString("password");
                String id = rs.getString("id");
                int highscore = rs.getInt("highscore");

                users.add(new User(username, password, id, highscore));
            }
            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDB
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }    //nothiing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }   //end finally try
        }  //end try
    }

    public void saveUsers() {
        //UserHandler userHandler = new UserHandler();

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //STEP 1: Register JDBC driver

            Class.forName("com.mysql.jdbc.Driver");
            //STEP 2: Open a connection
            System.out.println("Connecting to database loading saveusers");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // the mysql insert statement
            String sql = "INSERT INTO ice.user (username,password, highscore) VALUES (?, ?, ?)";

            //INSERT INTO streaming.users (UserName,password) VALUES (?, ?)

            // create the mysql insert preparedstatement

        stmt = conn.prepareStatement(sql);
            for (User user : users) {
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setInt(3, user.getHighscore());
                stmt.addBatch();
                // execute the preparedstatement

            }


            stmt.executeUpdate();

            conn.close();
            // TextUI.pickMenu();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    public boolean isUserNameValid(String username) {
        if (username == null || username.length() > 15 || username.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValid(String password) {
        if (password == null || password.length() < 8 || password.equals("")) {
            return false;
        } else {
            return true;
        }
    }


    public void saveTimeScore(int timeScore) {

        for (User user : users) {
            if (user.getId() == currentId) {
                if (timeScore < user.getHighscore()) {
                    user.setHighscore(timeScore);
                }

            }


        }


    }

}