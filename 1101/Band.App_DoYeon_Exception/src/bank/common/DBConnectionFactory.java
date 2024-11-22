package bank.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {

    // getConnection 메서드는 main 메서드 외부에 정의해야 합니다.
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        
        final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String userid = "c##java";
        final String passwd = "1234";
        
        Class.forName(jdbcDriverClassName); // JDBC 드라이버 로드
        return DriverManager.getConnection(url, userid, passwd); // 연결 반환
    }

   
}
