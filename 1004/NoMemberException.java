package 회원관리서비스;

public class NoMemberException extends Exception {
    public NoMemberException(String id) {
        super("회원 정보 없음: " + id);
    }
}
