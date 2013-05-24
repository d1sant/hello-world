package com.dpalaznik.mockito.example.loginservice;

/**
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class AfterFirstFailedLoginAttempt extends LoginServiceState {
    private String previousAccountId;

    public AfterFirstFailedLoginAttempt(String previousAccountId) {
        this.previousAccountId = previousAccountId;
        failedAttempts = 1;
    }

    @Override
    public void login(LoginService context, IAccount account, String password) {
        if (account.passwordMatches(password)) {
            account.login();
        } else {
            if (previousAccountId.equals(account.getId())) {
                context.setState(new AfterSecondFailedLoginAttempt(account.getId()));
            } else {
                previousAccountId = account.getId();
            }
        }
    }
}
