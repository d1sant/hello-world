package com.dpalaznik.mockito.example.loginservice;

/**
 * Date: 2013-04-14
 *
 * @author Dmitry Palaznik <dmitry.palaznik@viaden.com>
 */
public interface IAccountRepository {
    IAccount find(String accountId);
}
