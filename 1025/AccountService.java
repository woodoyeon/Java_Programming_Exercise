package bank.account;

import bank.exception.NoAccountException;
import bank.exception.InsufficientBalanceException;
import java.util.List;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void createAccount(Account account) {
        accountDAO.createAccount(account);
    }

    public Account getAccount(String accountNumber) throws NoAccountException {
        Account account = accountDAO.findAccountByNumber(accountNumber);
        if (account == null) throw new NoAccountException("계좌가 존재하지 않습니다.");
        return account;
    }

    public List<Account> getAllAccounts() {
        return accountDAO.findAllAccounts();
    }

    public void deposit(String accountNumber, double amount) throws NoAccountException {
        Account account = getAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
    }

    public void withdraw(String accountNumber, double amount) throws NoAccountException, InsufficientBalanceException {
        Account account = getAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
    }
}
