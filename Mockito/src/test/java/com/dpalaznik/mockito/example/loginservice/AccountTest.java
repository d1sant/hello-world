package com.dpalaznik.mockito.example.loginservice;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Date: 2013-04-14
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class AccountTest {
    private IAccount account;

    @Before
    public void init() {
        account = new Account("dmitry", "password");
    }

    @Test(expected = AccountLoginLimitReachedException.class)
    public void itShouldNowAllowConcurrentLogins() {
        willPasswordMatch(true);
        when(account.isLoggedIn()).thenReturn(true);
        account.login();
    }

    private void willPasswordMatch(boolean value) {
        when(account.passwordMatches(anyString())).thenReturn(value);
    }
}
