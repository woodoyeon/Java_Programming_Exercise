package bank.member;

import java.util.List;

public interface MemberDAO {
    int insert(String name, String email);
    MemberVO select(int memberId);
    List<MemberVO> selectAll();
    int updateEmail(int memberId, String email);
    int delete(int memberId);
}
