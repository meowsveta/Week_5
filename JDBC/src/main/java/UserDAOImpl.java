import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDAOImpl extends AbstractDAO  implements UserDAO {
    public UserDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void add(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO public.\"User\"\n" +
                    "(\"name\", city, age , id)\n" +
                    "VALUES(?, ?, ? , ?)");
            //"INSERT INTO User (name, city, id, age, birthday) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getCity());
            statement.setInt(3, user.getAge());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public List<User> allUsers() {
        PreparedStatement statement = null;
        List<User> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT \"name\", city, age , id\n" +
                    "FROM public.\"User\";");
            ResultSet resultSet = statement.executeQuery(); //Update();

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String cite = resultSet.getString(2);
                int age = resultSet.getInt(3);
                int id = resultSet.getInt(4);
                User user = new User(age, name, cite, id);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return list;
    }


    @Override
    public void delete(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM public.\"User\" " +
                    "WHERE \"name\"='" + user.getName() + "' AND city='" + user.getCity() + "' AND age= " + user.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
    }


    @Override
    public void update(User user) throws SQLException {
        String name = user.getName();
        String city = user.getCity();
        int age = user.getAge();
        int id = user.getId();
        //User user1 = new User(age, name, city, id);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(" UPDATE public.\"User\" SET \"name\"=' " +
                    ""+ name +"', city='"+ city +"', age="+ age +" WHERE id = " + id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
    }


    @Override
    public User getById(int id) throws SQLException {
        User user = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT \"name\", city, age, id " +
                    "FROM public.\"User\" WHERE id = " + (id) + ";");
            //"INSERT INTO User (name, city, id, age, birthday) VALUES (?, ?, ?, ?, ?)");
            ResultSet resultSet = statement.executeQuery(); //Update();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String cite = resultSet.getString(2);
                int age = resultSet.getInt(3);
                int id1 = resultSet.getInt(4);
                user = new User(age, name, cite, id1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return user;

    }
}
