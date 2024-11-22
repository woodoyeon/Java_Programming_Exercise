package bank.member;

import java.util.List;
import bank.exception.NoMemberException;

public class HJMemberService implements MemberService {

    private MemberDAO memberDAO;

    public HJMemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public boolean createMember(String name, String email) {
        int result = memberDAO.insert(name, email);
        return result == 1 ? true : false;
    }

    @Override
    public MemberVO findMember(int memberId) throws NoMemberException {
        MemberVO member = memberDAO.select(memberId);
        if (member == null) {
            throw new NoMemberException(memberId);  // 예외 던지기
        }
        return member;
    }

    @Override
    public List<MemberVO> listAllMembers() {
        return memberDAO.selectAll();
    }

    @Override
    public boolean updateEmail(int memberId, String email) throws NoMemberException {
        MemberVO member = memberDAO.select(memberId);
        if (member == null) {
            throw new NoMemberException(memberId);  // 예외 던지기
        }
        int result = memberDAO.updateEmail(memberId, email);
        return result == 1 ? true : false;
    }

    @Override
    public boolean deleteMember(int memberId) throws NoMemberException {
        MemberVO member = memberDAO.select(memberId);
        if (member == null) {
            throw new NoMemberException(memberId);  // 예외 던지기
        }
        int result = memberDAO.delete(memberId);
        return result == 1 ? true : false;
    }
}
