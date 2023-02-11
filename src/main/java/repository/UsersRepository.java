package repository;

import config.MySQLConfig;
import model.UsersColumn;
import payload.UsersResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepository {
    public UsersResponse login(String email, String pass) {
        Connection connection = MySQLConfig.connect();
        UsersResponse usersResponse = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM users u WHERE u.email = ? AND u.password = ?");
            statement.setString(1, email);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                int id = resultSet.getInt(UsersColumn.ID.getValue());
                email = resultSet.getString(UsersColumn.EMAIL.getValue());
                String fullname = resultSet.getString(UsersColumn.FULLNAME.getValue());
                String avatar = resultSet.getString(UsersColumn.AVATAR.getValue());

                usersResponse = new UsersResponse();
                usersResponse.setId(id);
                usersResponse.setAvatar(avatar);
                usersResponse.setEmail(email);
                usersResponse.setFullname(fullname);

            }
        } catch (SQLException throwables) {
            System.out.println("Lỗi query login: " + throwables.getMessage());
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    System.out.println("Lỗi không thể đóng connection: " + throwables.getMessage());
                }
            }
        }

        return usersResponse;
    }
}
