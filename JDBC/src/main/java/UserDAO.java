import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void update(User user) throws SQLException;
    User getById(int id) throws SQLException;

}
