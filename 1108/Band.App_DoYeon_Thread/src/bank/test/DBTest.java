package bank.test;

import bank.common.DBConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try (Connection conn = DBConnectionFactory.getConnection()) {
            if (conn != null) {
                System.out.println("DB 연결 성공");
            }
        } catch (SQLException e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
        }
    }
}
