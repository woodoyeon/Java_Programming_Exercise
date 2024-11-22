package bank.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bank.common.DBConnectionFactory;

public class OracleMemberDAO implements MemberDAO {

    @Override
    public int insert(String name, String email) {
        int result = 0;
        String sql = "INSERT INTO member (member_id, name, email, regdate) VALUES (member_seq.nextval, ?, ?, sysdate)";

        try (Connection conn = DBConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    @Override
    public MemberVO select(int memberId) {
        MemberVO member = null;
        String sql = "SELECT * FROM member WHERE member_id = ?";

        try (Connection conn = DBConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, memberId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    Date regDate = rs.getDate("regdate");
                    member = new MemberVO(memberId, name, email, regDate);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return member;
    }

    @Override
    public List<MemberVO> selectAll() {
        List<MemberVO> memberList = new ArrayList<>();
        String sql = "SELECT * FROM member";

        try (Connection conn = DBConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int memberId = rs.getInt("member_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date regDate = rs.getDate("regdate");
                memberList.add(new MemberVO(memberId, name, email, regDate));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return memberList;
    }

    @Override
    public int updateEmail(int memberId, String email) {
        int result = 0;
        String sql = "UPDATE member SET email = ? WHERE member_id = ?";

        try (Connection conn = DBConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setInt(2, memberId);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    @Override
    public int delete(int memberId) {
        int result = 0;
        String sql = "DELETE FROM member WHERE member_id = ?";

        try (Connection conn = DBConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, memberId);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }
}
