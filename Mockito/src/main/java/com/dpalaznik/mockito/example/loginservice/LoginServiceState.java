package com.dpalaznik.mockito.example.loginservice;

/**
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public abstract class LoginServiceState {
    private String previousAccountId = "";
    private int failedAttempts;

    public void login(IAccount account, String password) {
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
