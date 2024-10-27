package bank.app;

import bank.account.Account;
import bank.account.AccountService;
import bank.account.OracleAccountDAO;
import bank.view.BankView;

public class BankApplication {
    public static void main(String[] args) {
        BankView view = new BankView();
        AccountService service = new AccountService(new OracleAccountDAO());

        int option;
        do {
            view.showMenu();
            option = view.getMenuSelection();

            switch (option) {
                case 1:
                    view.createAccount(service);
                    break;
                case 2:
                    view.showAccountList(service);
                    break;
                case 3:
                    view.deposit(service);
                    break;
                case 4:
                    view.withdraw(service);
                    break;
                case 5:
                    view.showMessage("프로그램 종료");
                    break;
                default:
                    view.showMessage("잘못된 입력입니다. 다시 선택해주세요");
                    break;
            }
        } while (option != 5);
    }
}
