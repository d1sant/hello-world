package com.dpalaznik.mockito.example.loginservice;

/**
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public interface IAccount {
    String getId();
    void setLoggedIn(boolean value);
    boolean passwordMatches(String candidate);
    void setRevoked(boolean value);
    boolean isLoggedIn();
    boolean isRevoked();
    void login();
}
