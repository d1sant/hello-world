package com.dpalaznik.mockito.example.loginservice;

/**
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class LoginService {
    private final IAccountRepository accountRepository;
    private LoginServiceState state = new AwaitingFirstLoginAttempt();

    public LoginService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void login(String accountId, String password) {
        IAccount account = accountRepository.find(accountId);

        if (account == null) {
            throw new AccountNotFoundException();
        }

        state.login(this, account, password);
    }

    public void setState(LoginServiceState state) {
        this.state = state;
    }
}
