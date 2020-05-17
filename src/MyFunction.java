
import store.MyConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyFunction {

    public static int countData(String tableName) {
        int total = 0;
        Statement st;
        try {
            Connection con = MyConnection.getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) as '"+tableName+"' from user");
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return total;
    }
}
