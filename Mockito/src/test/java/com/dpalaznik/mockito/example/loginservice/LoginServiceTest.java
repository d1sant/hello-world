package com.dpalaznik.mockito.example.loginservice;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Date: 2013-04-14
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class LoginServiceTest {

    private IAccount account;
    private IAccountRepository accountRepository;
    private LoginService service;

    @Before
    public void init() {
        account = mock(IAccount.class);
        accountRepository = mock(IAccountRepository.class);
        when(accountRepository.find(anyString())).thenReturn(account);
        service = new LoginService(accountRepository);
    }

    @Test
    public void isShouldSetAccountToLoggedInWhenPasswordMatches() {
        willPasswordMatch(true);
        service.login("dmitry", "password");
        verify(account, times(1)).setLoggedIn(true);
    }

    @Test
    public void itShouldSetAccountToRevokedAfterThreeFailedLoginAttempts() {
        willPasswordMatch(false);
        for (int i = 0; i < 3; i++) {
            service.login("dmitry", "password");
        }
        verify(account, times(1)).setRevoked(true);
    }

    private void willPasswordMatch(boolean value) {
        when(account.passwordMatches(anyString())).thenReturn(value);
    }
}
