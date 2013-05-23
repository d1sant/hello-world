package com.dpalaznik.mockito.example.loginservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
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

    @Test
    public void isShouldSetAccountToLoggedInAfterLogin() {
        account.login();
        Assert.assertEquals(true, account.isLoggedIn());
    }

    @Test(expected = AccountLoginLimitReachedException.class)
    public void itShouldNowAllowConcurrentLogins() {
        account.login();
        account.login();
    }

    @Test(expected = AccountRevokedException.class)
    public void itShouldNotBePossibleToLogIntoRevokedAccount() {
        account.setRevoked(true);
        account.login();
    }
}
