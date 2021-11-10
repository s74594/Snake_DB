import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Tables {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:D:/0_Intellij/Snake_DB/DataBase/Snake_System.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS highscore (\n"
                + " highscore_id integer PRIMARY KEY AUTOINCREMENT ,\n"
                + " player_id integer NOT NULL,\n"
                + " date_of_score text \n"
                + ");";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}