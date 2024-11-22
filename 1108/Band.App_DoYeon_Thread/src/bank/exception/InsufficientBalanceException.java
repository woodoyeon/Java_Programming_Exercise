package bank.exception;

public class InsufficientBalanceException extends Exception {
    
    // 기본 생성자
    public InsufficientBalanceException() {}

    // 메시지를 출력할 수 있는 생성자
    public InsufficientBalanceException(int money) {
        super("잔액 부족: " + money + "원");
    }
}
