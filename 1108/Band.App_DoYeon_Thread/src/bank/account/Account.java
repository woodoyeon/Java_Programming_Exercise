package bank.account;

public class Account {
    private int balance;

    // 동기화된 setBalance 메서드
    public synchronized void setBalance(int money) {
        try {
            Thread.sleep(1000);  // 1초 동안 작업을 수행하는 것처럼 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance += money;  // 잔액 업데이트
        System.out.println(Thread.currentThread().getName() + ": " + this.balance);  // 현재 스레드와 잔액 출력
        notify();  // 작업 완료 후 다른 스레드에게 신호를 보냄
    }

    // 동기화된 getBalance 메서드
    public synchronized int getBalance() {
        return this.balance;
    }
}
