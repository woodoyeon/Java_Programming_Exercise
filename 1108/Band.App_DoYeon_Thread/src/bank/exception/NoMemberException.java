package bank.exception;

public class NoMemberException extends Exception {
    
    // 기본 생성자
    public NoMemberException() {}

    // 회원 ID를 받는 생성자
    public NoMemberException(int memberId) {
        super("없는 회원 ID: " + memberId);  // 예외 메시지 설정
    }
}
