package JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class InsertUesrTest {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		

		try {
			connection = JDBCUtil.getConnection();
			
			String insertsql = "insert into member(user_id, user_pw, name, phone, birth, created_at) values(?,?,?,?,?,CURRENT_TIMESTAMP)";
			
			preparedstatement = connection.prepareStatement(insertsql);
			
			LocalDate localDate = LocalDate.of(2001, 10, 11);
            Date sqlDate = Date.valueOf(localDate);
			
			preparedstatement.setString(1, "cccc");
			preparedstatement.setString(2, "4321");
			preparedstatement.setString(3, "o");
			preparedstatement.setString(4, "01042454222");
			preparedstatement.setDate(5, sqlDate);
			
			int rowsInserted = preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, null, preparedstatement);
		}
	}
}
