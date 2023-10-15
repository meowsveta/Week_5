import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://127.0.0.1:5432/test"; //?useSSL=false&amp;serverTimezone=UTC
        String userName = "postgres";
        String password = "205899";

        Connection connection = null;
               // DriverManager.getConnection(url, userName, password);
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//             connection = DriverManager.getConnection(url, user, password);
//            System.out.println("Подключение к базе данных успешно установлено!");
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("Ошибка при подключении к базе данных:");
//            e.printStackTrace();
//        }

        ResultSet resultSet = null;

//        try ( Connection connection1 = DriverManager.getConnection(url, userName, password);
//             Statement statement = connection.createStatement();)
//        {
//            String selectSql = "SELECT \"name\", birthday, city, age, id\n" +
//                    "FROM public.\"User\";\n";
//            resultSet = statement.executeQuery(selectSql);
//            // Print results from select statement
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
//                + " " + resultSet.getString(4) );
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }

        UserDAO userDAO = new UserDAOImpl(connection);
        User user1 = new User(10, "AAA" , "MMM",  9);
        User user2 = new User(20, "Ffff" , "sssss", 8);
        userDAO.add(user2);
        userDAO.add(user1);
        //userDAO.delete(user2);

        User user3 = userDAO.getById(6); // poisk po id
        System.out.println(user3.getName() + user3.getAge()+ user3.getCity());

//        User user4 = new User(11, "Klim" , "NSK" , AUTO_ID); // obnovleniye
//        userDAO.update(user4);



        List<User> users = userDAO.allUsers();
        for (User user : users) {
            System.out.println(user.getName());
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




//        String connectionUrl =
//                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
//                        + "database=AdventureWorks;"
//                        + "user=yourusername@yourserver;"
//                        + "password=yourpassword;"
//                        + "encrypt=true;"
//                        + "trustServerCertificate=false;"
//                        + "loginTimeout=30;";
//
//        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
//            // Code here.
//        }
//        // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//        }


//        try (Connection conn = DriverManager.getConnection(
//                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "205899")) { //jdbc:postgresql://127.0.0.1:5432/
//
//            if (conn != null) {
//                System.out.println("Connected to the database!");
//            } else {
//                System.out.println("Failed to make connection!");
//            }



