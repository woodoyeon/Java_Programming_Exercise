package 회원관리서비스;

public interface MemberService {
    void regist(Member member);
    void remove(String id) throws NoMemberException;
    boolean login(String id, String password) throws NoMemberException;
    void logout(String id);
    Member info(String id, String password) throws NoMemberException;
}
