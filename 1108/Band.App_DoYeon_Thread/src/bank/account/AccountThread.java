package bank.account;

public class AccountThread extends Thread {
    private Account account;  // Account 객체
    private int money;        // 입금액 또는 출금액

    // 생성자: 계좌 객체(Account)와 입금액을 받는 형태로 수정
    public AccountThread(String name, Account account, int money) {
        this.setName(name);      // 스레드 이름 설정
        this.account = account;  // 계좌 객체 설정
        this.money = money;      // 입금액 또는 출금액 설정
    }

    @Override
    public void run() {
        synchronized (account) {  // 동기화된 작업 시작
            account.setBalance(money);  // 입금/출금 작업
            try {
                account.wait();  // 다른 스레드가 작업을 완료할 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
