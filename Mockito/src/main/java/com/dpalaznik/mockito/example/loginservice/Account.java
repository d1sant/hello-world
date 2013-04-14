package com.dpalaznik.mockito.example.loginservice;

/**
 * Date: 2013-04-14
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class Account implements IAccount {

    public Account(String accountId, String password) {
    }

    @Override
    public void setLoggedIn(boolean value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean passwordMatches(String candidate) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setRevoked(boolean value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isLoggedIn() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isRevoked() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void login() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
