package bank.member;

import java.util.List;
import bank.exception.NoMemberException;

public interface MemberService {
    boolean createMember(String name, String email);
    List<MemberVO> listAllMembers();
    boolean updateEmail(int memberId, String email) throws NoMemberException; // 예외 던지기 추가
    boolean deleteMember(int memberId) throws NoMemberException; // 예외 던지기 추가
    MemberVO findMember(int memberId) throws NoMemberException; // 예외 던지기 추가
}
