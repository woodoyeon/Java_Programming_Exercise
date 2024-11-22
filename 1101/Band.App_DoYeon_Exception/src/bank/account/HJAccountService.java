package bank.account;

import java.util.List;
import bank.exception.NoAccountException;
import bank.exception.InsufficientBalanceException;

public class HJAccountService implements AccountService {

    private AccountDAO accountDAO;
    
    public HJAccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public boolean createAccount(String owner, int money) {
        int result = accountDAO.insert(owner, money);
        return result == 1;
    }

    @Override
    public List<AccountVO> listAllAccount() {
        List<AccountVO> accountList = accountDAO.selectAll();
        return accountList.isEmpty() ? null : accountList;
    }

    @Override
    public boolean deposit(int accountNo, int money) throws NoAccountException {
        AccountVO account = accountDAO.select(accountNo);
        
        if (account == null) {
            throw new NoAccountException(accountNo);  // 예외 던지기
        }
        
        int newBalance = account.getBalance() + money;
        int result = accountDAO.updateBalance(accountNo, newBalance);
        return result == 1;
    }

    @Override
    public boolean withdraw(int accountNo, int money) throws NoAccountException, InsufficientBalanceException {
        AccountVO account = accountDAO.select(accountNo);
        
        if (account == null) {
            throw new NoAccountException(accountNo);  // 예외 던지기
        }
        
        if (account.getBalance() < money) {
            throw new InsufficientBalanceException(money);  // 잔액 부족 예외 던지기
        }
        
        int newBalance = account.getBalance() - money;
        int result = accountDAO.updateBalance(accountNo, newBalance);
        return result == 1;
    }

    @Override
    public boolean removeAccount(int accountNo) throws NoAccountException {
        AccountVO account = accountDAO.select(accountNo);
        
        if (account == null) {
            throw new NoAccountException(accountNo);  // 예외 던지기
        }
        
        int result = accountDAO.delete(accountNo);
        return result == 1;
    }
}
