package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectUserTest2 {

	public static void main(String[] args) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedstatement = null;

		try {

			// 데이터베이스 연결
			connection = JDBCUtil.getConnection();

			String sql = "select * from member where name = ?";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, "a");

			resultSet = preparedstatement.executeQuery();

			System.out.println("member 목록");

			while (resultSet.next()) {
				System.out.print(resultSet.getString("user_id") + " : ");
				System.out.print(resultSet.getString("user_pw") + " : ");
				System.out.print(resultSet.getString("name") + " : ");
				System.out.print(resultSet.getString("phone") + " : ");
				System.out.println(resultSet.getDate("birth"));
			}

		} catch (SQLException e) {
			System.out.println("데이터베이스 작업 중 오류 발생.");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, resultSet, preparedstatement);
		}
	}
}
