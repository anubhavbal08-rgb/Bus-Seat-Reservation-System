
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@(description="
                + "(address=(protocol=tcps)(port=2484)"
                + "(host=db.freesql.com))"
                + "(connect_data=(service_name=26ai_un3c1)))";

        String username = "ANUBHAVBAL08_SCHEMA_O3R4Z";
        String password = "4A0EWODF7SOKAUt$SEHVCP8B5RC11X";

        try (Connection con =
                     DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to Oracle FreeSQL successfully!");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM BUS");

            while (rs.next()) {
                System.out.println(
                    rs.getString("BUS_NO") + " | " +
                    rs.getString("ROUTE") + " | " +
                    rs.getInt("AVAILABLE_SEATS")
                );
            }
        } catch (SQLException e) {
            System.out.println("Connection failed:");
            e.printStackTrace();
        }
    }
}
