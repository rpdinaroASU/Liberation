import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        createSystemUserTable();
    }
    private static void createSystemUserTable() {
        String url = "jdbc:www.liberationunionorganization.com:1856";
        String username = "lioninn";
        String password = "Shamb00m!";
        Connection con;
        try {
            con = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "CREATE TABLE system_user (" +
                            "userID int NOT NULL," +
                            "workplaceID int NOT NULL," +
                            "eEmail varchar(62) NOT NULL," +
                            "ePassword varchar(256) NOT NULL," +
                            "eFirstName varchar(50) NOT NULL," +
                            "eLastName varchar(50) NOT NULL," +
                            "isWorker shortInt(1) NOT NULL," +
                            "isOrganizer shortInt(1) NOT NULL," +
                            "isStaff shortInt(1) NOT NULL," +
                            "isAdmin shortInt(1) NOT NULL," +
                            "loginAttempts shortInt(1) NOT NULL" +
                            "PRIMARY KEY(userID, workplaceID)," +
                            "UNIQUE(userID));"
            );
            Statement statement = con.createStatement();
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}