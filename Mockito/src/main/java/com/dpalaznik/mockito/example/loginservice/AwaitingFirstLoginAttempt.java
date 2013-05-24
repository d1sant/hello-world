package com.dpalaznik.mockito.example.loginservice;

/**
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class AwaitingFirstLoginAttempt extends LoginServiceState {
    @Override
    public void login(LoginService context, IAccount account, String password) {
        if (account.passwordMatches(password)) {
            account.login();
        } else {
            context.setState(new AfterFirstFailedLoginAttempt(account.getId()));
        }
    }
}
