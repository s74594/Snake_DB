import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_Values {

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


    public void insert(String name, String password) {
        String sql = "INSERT INTO snake_players( name, password) VALUES(?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert_highscore(int player_id, String date_of_score) {
        String sql = "INSERT INTO highscore( player_id,date_of_score) VALUES(?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, player_id);
            pstmt.setString(2, date_of_score);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Insert_Values app = new Insert_Values();
        // insert three new rows
        app.insert_highscore(2, "09:09:09-09.11.2021");
        app.insert_highscore(3, "09:09:09-09.11.2021");
        app.insert_highscore(4, "09:09:09-09.11.2021");
    }

}