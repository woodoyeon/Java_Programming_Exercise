package bank.account;

import java.util.List;
import bank.exception.NoAccountException;
import bank.exception.InsufficientBalanceException;

public interface AccountService {
    boolean createAccount(String owner, int money);
    List<AccountVO> listAllAccount();
    boolean deposit(int accountNo, int money) throws NoAccountException;  
    boolean withdraw(int accountNo, int money) throws NoAccountException, InsufficientBalanceException;  // 예외 추가
    boolean removeAccount(int accountNo) throws NoAccountException; 
}
