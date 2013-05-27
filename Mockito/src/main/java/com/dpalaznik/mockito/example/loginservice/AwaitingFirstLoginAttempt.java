package com.dpalaznik.mockito.example.loginservice;

/**
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class AwaitingFirstLoginAttempt extends LoginServiceState {
    @Override
    public void handleIncorrectPassword(LoginServiceContext context, IAccount account, String password) {
        context.setState(new AfterFirstFailedLoginAttempt(account.getId()));
    }
}
