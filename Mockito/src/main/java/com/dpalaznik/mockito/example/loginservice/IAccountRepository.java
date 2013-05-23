package com.dpalaznik.mockito.example.loginservice;

/**
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public interface IAccountRepository {
    IAccount find(String accountId);
}
