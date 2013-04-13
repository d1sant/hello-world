package com.dpalaznik.mockito.example.loginservice;

import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Date: 2013-04-14
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public class LoginServiceTest {

    @Test
    public void isShouldSetAccountToLoggedInWhenPasswordMatches() {
        IAccount account = mock(IAccount.class);
        when(account.passwordMatches(anyString())).thenReturn(true);

        IAccountRepository accountRepository = mock(IAccountRepository.class);
        when(accountRepository.find(anyString())).thenReturn(account);

        LoginService service = new LoginService(accountRepository);
        service.login("dmitry", "password");

        verify(account, times(1)).setLoggedIn(true);
    }

    @Test
    public void itShouldSetAccountToRevokedAfterThreeFailedLoginAttempts() {
        IAccount account = mock(IAccount.class);
        when(account.passwordMatches(anyString())).thenReturn(false);

        IAccountRepository accountRepository = mock(IAccountRepository.class);
        when(accountRepository.find(anyString())).thenReturn(account);

        LoginService service = new LoginService(accountRepository);

        for (int i = 0; i < 3; i++) {
            service.login("dmitry", "password");
        }

        verify(account, times(1)).setRevoked(true);
    }
}
