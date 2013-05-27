package com.dpalaznik.mockito.example.loginservice;

/**
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public abstract class LoginServiceState {

    public final void login(LoginServiceContext context, IAccount account, String password) {
        if (account.passwordMatches(password)) {
            account.login();
            context.setState(new AwaitingFirstLoginAttempt());
        } else {
            handleIncorrectPassword(context, account, password);
        }

    }
    public abstract void handleIncorrectPassword(LoginServiceContext context, IAccount account, String password);
}
