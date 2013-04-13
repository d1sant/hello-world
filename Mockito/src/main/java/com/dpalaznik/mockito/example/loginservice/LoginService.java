package com.dpalaznik.mockito.example.loginservice;

/**
 * Date: 2013-04-14
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class LoginService {
    private final IAccountRepository accountRepository;

    public LoginService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public void login(String accountId, String password) {
        IAccount account = accountRepository.find(accountId);
        account.setLoggedIn(true);
    }
}
