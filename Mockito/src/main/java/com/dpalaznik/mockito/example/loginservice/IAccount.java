package com.dpalaznik.mockito.example.loginservice;

/**
 * Date: 2013-04-14
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public interface IAccount {
    void setLoggedIn(boolean value);
    boolean passwordMatches(String candidate);
    void setRevoked(boolean value);
    boolean isLoggedIn();
    boolean isRevoked();
    void login(String password);
}
