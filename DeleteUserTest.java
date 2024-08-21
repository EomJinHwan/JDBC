package JDBC;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserTest {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			connection = JDBCUtil.getConnection();

			String deletesql = "delete from member where user_id = ?";

			preparedstatement = connection.prepareStatement(deletesql);

			preparedstatement.setString(1, "asdf");

			int rowsInserted = preparedstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, null, preparedstatement);
		}
	}
}
