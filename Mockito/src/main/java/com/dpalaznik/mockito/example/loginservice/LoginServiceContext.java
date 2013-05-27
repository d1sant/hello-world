package com.dpalaznik.mockito.example.loginservice;

/**
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public abstract class LoginServiceContext {
    private LoginServiceState state;

    public LoginServiceContext(LoginServiceState state) {
        this.state = state;
    }

    public void setState(LoginServiceState state) {
        this.state = state;
    }

    public LoginServiceState getState() {
        return this.state;
    }
}
