package bank.exception;

public class NoAccountException extends Exception {
    // 기본 생성자
    public NoAccountException() {}

    // 메시지를 출력할 수 있는 생성자
    public NoAccountException(int accountNo) {
        super("없는 계좌 번호: " + accountNo); // 예외 메시지 설정
    }
}
