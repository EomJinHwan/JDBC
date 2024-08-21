package JDBC;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserTest {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			connection = JDBCUtil.getConnection();

			String updatesql = "update member set  user_pw=?, phone=? where user_id=?";

			preparedstatement = connection.prepareStatement(updatesql);

			preparedstatement.setString(1, "1111");
			preparedstatement.setString(2, "01022223333");
			preparedstatement.setString(3, "asdf");

			int rowsInserted = preparedstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, null, preparedstatement);
		}
	}
}
