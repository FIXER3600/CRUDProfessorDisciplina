package application.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
    private Connection c;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String hostname="localhost";
        String dbName="dbjavafx";
        String user="guilherme";
        String senha="1234";
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        c= DriverManager.getConnection(String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;",
                hostname,dbName,user,senha));
        return c;
    }
}
