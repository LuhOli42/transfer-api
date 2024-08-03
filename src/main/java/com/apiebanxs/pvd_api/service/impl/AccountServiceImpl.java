package com.apiebanxs.pvd_api.service.impl;

import com.apiebanxs.pvd_api.dto.TransferDto;
import com.apiebanxs.pvd_api.error.AccountNotFoundException;
import com.apiebanxs.pvd_api.model.Account;
import com.apiebanxs.pvd_api.repository.AccountRepository;
import com.apiebanxs.pvd_api.service.AccountService;
import java.util.NoSuchElementException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  public AccountServiceImpl(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public void resetAPI() {
    accountRepository.deleteAll();
  }

  @Override
  public Account findById(String account_id) {
    return accountRepository
      .findById(account_id)
      .orElseThrow(AccountNotFoundException::new);
  }

  @Override
  public TransferDto deposit(String id, Integer amount) {
    Account accountToDeposit = accountRepository
      .findById(id)
      .orElse(new Account(id, amount));

    if (accountRepository.existsById(id)) {
      accountToDeposit.setBalance(accountToDeposit.getBalance() + amount);
    }

    accountRepository.save(accountToDeposit);

    TransferDto newDto = new TransferDto(null, accountToDeposit);
    return newDto;
  }

  @Override
  public TransferDto withdraw(String id, Integer amount) {
    Account accountToWithdraw = accountRepository
      .findById(id)
      .orElseThrow(AccountNotFoundException::new);

    if (accountToWithdraw.getBalance() < amount) {
      throw new NoSuchElementException();
    }

    accountToWithdraw.setBalance(accountToWithdraw.getBalance() - amount);
    accountRepository.save(accountToWithdraw);

    TransferDto newDto = new TransferDto(accountToWithdraw, null);

    return newDto;
  }

  @Override
  public TransferDto transfer(
    String origin,
    Integer amount,
    String destination
  ) {
    TransferDto accountOfOrigin = this.withdraw(origin, amount);
    TransferDto accountOfDestination = this.deposit(destination, amount);

    return new TransferDto(
      accountOfOrigin.getOrigin(),
      accountOfDestination.getDestination()
    );
  }
}
