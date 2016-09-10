package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roma on 10.09.2016.
 */
public class DaoMsg {
    public static Connection getConnection() {
        Connection result = null;

        try {
            Class.forName("org.postgresql.Driver");
            result = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "password");
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static int addMsg(Msg msg) {
        int status = 0;
        try (Connection connection = DaoMsg.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO msg_app(name, msg) VALUES (?,?)");

            statement.setString(1, msg.getAuthor());
            statement.setString(2, msg.getMsg());

            status = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Msg> getMsgs(int offset, int amount) {
        List<Msg> result = new ArrayList<>();

        try (Connection connection = DaoMsg.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM msg_app ORDER BY id DESC OFFSET " + offset + " LIMIT " + amount);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new Msg(resultSet.getString("name"), resultSet.getString("msg")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static int getRowCount(){
        int result = -1;
        try(Connection connection = DaoMsg.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM msg_app");

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            result = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
