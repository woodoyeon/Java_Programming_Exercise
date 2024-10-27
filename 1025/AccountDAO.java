package Bank_1025;

import java.util.List;

public interface AccountDAO {
    void createAccount(Account account);
    Account findAccountByNumber(String accountNumber);
    List<Account> findAllAccounts();
    void updateAccount(Account account);
    void deleteAccount(String accountNumber);
}
