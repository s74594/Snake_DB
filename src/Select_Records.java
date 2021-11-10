import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_Records {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:D:/0_Intellij/Snake_DB/DataBase/Snake_System.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void selectAll(){
        //String sql = "SELECT * FROM snake_players";
        String sql = "SELECT * FROM players";
        try {
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("player_id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println( e.getMessage());
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Select_Records app = new Select_Records();
        app.selectAll();
    }

}