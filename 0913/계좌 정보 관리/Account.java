package 자바응용실습_이혜정교수님;

// Account 클래스 선언
class Account {
    // 계좌번호, 소유자 이름, 잔액을 저장할 필드 (private 접근 제어자 사용)
    private String accountNumber;
    private String owner;
    private int balance;

    // 생성자: 계좌번호, 소유자 이름, 초기 금액을 매개변수로 받아 초기화
    public Account(String accountNumber, String owner, int balance) {
        // 필드를 생성자 매개변수로 초기화
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    // 계좌번호를 반환하는 getter 메서드
    public String getAccountNumber() {
        return accountNumber;
    }

    // 소유자 이름을 반환하는 getter 메서드
    public String getOwner() {
        return owner;
    }

    // 잔액을 반환하는 getter 메서드
    public int getBalance() {
        return balance;
    }

    // 예금 기능: 금액을 매개변수로 받아 잔액에 더하는 메서드
    public void deposit(int amount) {
        balance += amount;
    }

    // 출금 기능: 금액을 매개변수로 받아 잔액에서 차감, 잔액이 충분하면 true, 부족하면 false 반환
    public boolean withdraw(int amount) {
        // 잔액이 충분한 경우
        if (balance >= amount) {
            balance -= amount;  // 잔액에서 출금액 차감
            return true;        // 출금 성공
        } else {
            return false;       // 잔액 부족으로 출금 실패
        }
    }
}
