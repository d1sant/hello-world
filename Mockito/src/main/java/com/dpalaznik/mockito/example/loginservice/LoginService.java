package com.dpalaznik.mockito.example.loginservice;

/**
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class LoginService {
    private final IAccountRepository accountRepository;
    private int failedAttempts = 0;
    private String previousAccountId = "";

    public LoginService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void login(String accountId, String password) {
        IAccount account = accountRepository.find(accountId);

        if (account == null) {
            throw new AccountNotFoundException();
        }

        verifyLoginAttempt(account, password);
    }

    private void verifyLoginAttempt(IAccount account, String password) {
        if (account.passwordMatches(password)) {
            account.login();
        } else {
            if (previousAccountId.equals(account.getId())) {
                ++failedAttempts;
            } else {
                failedAttempts = 1;
                previousAccountId = account.getId();
            }
        }

        if (failedAttempts == 3) {
            account.setRevoked(true);
        }
    }
}
