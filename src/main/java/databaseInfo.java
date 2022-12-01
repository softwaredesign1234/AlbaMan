import java.sql.*;


public class databaseInfo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/AlbaMan";
        String userName = "root";
        String password = "never9867!";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from resume");

        resultSet.next();
        String individualName = resultSet.getString("IndividualName");
        String workHistory = resultSet.getString("workExperience");

        System.out.println(individualName);
        System.out.println(workHistory);

        resultSet.close();
        statement.close();
        connection.close();
    }
}