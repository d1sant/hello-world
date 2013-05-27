package com.dpalaznik.mockito.example.loginservice;

/**
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public abstract class LoginServiceState {
    public final void login(LoginService context, IAccount account, String password) {
        if (account.passwordMatches(password)) {
            account.login();
        } else {
            handleIncorrectPassword(context, account, password);
        }
    }
    public abstract void handleIncorrectPassword(LoginService context, IAccount account, String password);
}
