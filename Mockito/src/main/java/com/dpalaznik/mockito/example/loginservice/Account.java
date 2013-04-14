package com.dpalaznik.mockito.example.loginservice;

/**
 * Date: 2013-04-14
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class Account implements IAccount {

    private final String id;
    private final String password;
    private boolean isLoggedIn = false;
    private boolean isRevoked = false;

    public Account(String accountId, String password) {
        this.id = accountId;
        this.password = password;
    }

    @Override
    public void setLoggedIn(boolean value) {
        isLoggedIn = value;
    }

    @Override
    public boolean passwordMatches(String candidate) {
        return this.password.equals(candidate);
    }

    @Override
    public void setRevoked(boolean value) {
        this.isRevoked = value;
    }

    @Override
    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    @Override
    public boolean isRevoked() {
        return this.isRevoked;
    }

    @Override
    public void login(String password) {
        if (passwordMatches(password)) {
            if (isLoggedIn()) {
                throw new AccountLoginLimitReachedException();
            }
            setLoggedIn(true);
        }
    }
}
