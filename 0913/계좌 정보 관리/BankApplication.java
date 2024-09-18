package 자바응용실습_이혜정교수님;

import java.util.Scanner;

// BankApplication 클래스: 계좌 관리 프로그램의 메인 로직을 담당
public class BankApplication {
    
    // Account 객체 배열: 최대 100개의 계좌를 저장
    private static Account[] accounts = new Account[100];  // 최대 100개의 계좌 저장
    private static int accountCount = 0;  // 생성된 계좌 수를 관리

    // 프로그램의 시작점 (메인 메서드)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // 사용자 입력을 위한 Scanner 객체 생성
        boolean isRunning = true;  // 프로그램의 실행 여부를 결정하는 플래그

        // 프로그램 실행 루프
        while (isRunning) {
            // 메뉴 출력
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.print("선택> ");
            int choice = Integer.parseInt(scanner.nextLine());  // 사용자의 선택 입력받기

            // 선택에 따른 기능 실행
            switch (choice) {
                case 1:
                    createAccount(scanner);  // 계좌 생성
                    break;
                case 2:
                    showAccounts();  // 계좌 목록 출력
                    break;
                case 3:
                    deposit(scanner);  // 예금 기능
                    break;
                case 4:
                    withdraw(scanner);  // 출금 기능
                    break;
                case 5:
                    isRunning = false;  // 프로그램 종료
                    System.out.println("프로그램 종료.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");  // 잘못된 입력 처리
            }
        }
    }

    // 계좌 생성 기능: 사용자가 입력한 계좌번호, 계좌주, 초기 입금액으로 계좌 생성
    private static void createAccount(Scanner scanner) {
        System.out.print("계좌번호: ");
        String accountNumber = scanner.nextLine();  // 계좌번호 입력받기
        System.out.print("계좌주: ");
        String owner = scanner.nextLine();  // 계좌주 입력받기
        System.out.print("초기입금액: ");
        int balance = Integer.parseInt(scanner.nextLine());  // 초기 입금액 입력받기

        // 새로운 계좌 객체를 배열에 추가하고 계좌 개수 증가
        accounts[accountCount++] = new Account(accountNumber, owner, balance);
        System.out.println("결과: 계좌가 생성되었습니다.");
    }

    // 계좌 목록 출력 기능: 생성된 모든 계좌 정보를 출력
    private static void showAccounts() {
        System.out.println("==== 계좌목록 ====");
        for (int i = 0; i < accountCount; i++) {  // 생성된 계좌만큼 반복
            Account account = accounts[i];  // 각 계좌 객체 가져오기
            // 계좌번호, 계좌주, 잔액 출력
            System.out.printf("%s %s %d%n", account.getAccountNumber(), account.getOwner(), account.getBalance());
        }
    }

    // 예금 기능: 계좌번호로 계좌를 찾아 예금액을 추가
    private static void deposit(Scanner scanner) {
        System.out.print("계좌번호: ");
        String accountNumber = scanner.nextLine();  // 계좌번호 입력받기
        System.out.print("예금액: ");
        int amount = Integer.parseInt(scanner.nextLine());  // 예금액 입력받기

        // 계좌 찾기
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);  // 예금액 추가
            System.out.println("결과: 예금이 성공되었습니다.");
        } else {
            System.out.println("결과: 계좌를 찾을 수 없습니다.");
        }
    }

    // 출금 기능: 계좌번호로 계좌를 찾아 출금액을 차감
    private static void withdraw(Scanner scanner) {
        System.out.print("계좌번호: ");
        String accountNumber = scanner.nextLine();  // 계좌번호 입력받기
        System.out.print("출금액: ");
        int amount = Integer.parseInt(scanner.nextLine());  // 출금액 입력받기

        // 계좌 찾기
        Account account = findAccount(accountNumber);
        if (account != null) {
            // 출금액 차감, 성공 여부에 따라 메시지 출력
            if (account.withdraw(amount)) {
                System.out.println("결과: 출금이 성공되었습니다.");
            } else {
                System.out.println("결과: 잔액이 부족합니다.");
            }
        } else {
            System.out.println("결과: 계좌를 찾을 수 없습니다.");
        }
    }

    // 계좌 찾기 기능: 입력받은 계좌번호로 계좌 배열에서 해당 계좌를 찾음
    private static Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {  // 계좌 목록에서 반복 검색
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];  // 계좌번호가 일치하면 해당 계좌 반환
            }
        }
        return null;  // 일치하는 계좌가 없으면 null 반환
    }
}
