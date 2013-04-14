package com.dpalaznik.mockito.example.loginservice;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.when;

/**
 * Date: 2013-04-14
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class AccountTest {
    private static final String PASSWORD = "password";
    private IAccount account;

    @Before
    public void init() {
        account = new Account("dmitry", "password");
    }

    @Test(expected = AccountLoginLimitReachedException.class)
    public void itShouldNowAllowConcurrentLogins() {
        account.login(PASSWORD);
        account.login(PASSWORD);
    }

    @Test(expected = AccountRevokedException.class)
    public void itShouldNotBePossibleToLogIntoRevokedAccount() {
        account.setRevoked(true);
        account.login(PASSWORD);
    }
}
