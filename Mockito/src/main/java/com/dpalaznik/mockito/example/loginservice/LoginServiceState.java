package com.dpalaznik.mockito.example.loginservice;

/**
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public abstract class LoginServiceState {
    protected String previousAccountId = "";
    protected int failedAttempts;

    public abstract void login(IAccount account, String password);
}
