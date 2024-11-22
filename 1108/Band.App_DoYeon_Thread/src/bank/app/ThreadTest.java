package bank.app;

import bank.account.Account;
import bank.account.AccountThread;

public class ThreadTest {

    public static void main(String[] args) {
        // 입금 테스트
        depositTest();
        
        // 출금 테스트
        withdrawTest();
    }

    // 입금 테스트
    private static void depositTest() {
        System.out.println("입금 테스트 시작!");
        Account account = new Account(); // 계좌 객체 생성

        // 두 개의 입금 스레드 생성
        AccountThread depositThread1 = new AccountThread("DepositThread-1", account, 2000);
        AccountThread depositThread2 = new AccountThread("DepositThread-2", account, 3000);

        // 스레드 시작
        depositThread1.start();
        depositThread2.start();

        try {
            // 두 스레드가 끝날 때까지 기다림
            depositThread1.join();
            depositThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 결과 출력
        System.out.printf("최종 잔액: %d원\n", account.getBalance()); // 예상 값: 5000원
    }

    // 출금 테스트
    private static void withdrawTest() {
        System.out.println("출금 테스트 시작!");
        Account account = new Account(); // 계좌 객체 생성

        // 초기 잔액 설정
        account.setBalance(10000);

        // 두 개의 출금 스레드 생성
        AccountThread withdrawThread1 = new AccountThread("WithdrawThread-1", account, -3000);
        AccountThread withdrawThread2 = new AccountThread("WithdrawThread-2", account, -2000);

        // 스레드 시작
        withdrawThread1.start();
        withdrawThread2.start();

        try {
            // 두 스레드가 끝날 때까지 기다림
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 결과 출력
        System.out.printf("최종 잔액: %d원\n", account.getBalance()); // 예상 값: 4000원
    }
}
