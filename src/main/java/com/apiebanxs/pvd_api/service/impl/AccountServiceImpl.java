package com.apiebanxs.pvd_api.service.impl;

import com.apiebanxs.pvd_api.dto.TransferDto;
import com.apiebanxs.pvd_api.model.Account;
import com.apiebanxs.pvd_api.repository.AccountRepository;
import com.apiebanxs.pvd_api.service.AccountService;
import java.util.NoSuchElementException;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  public AccountServiceImpl(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Account findById(Integer account_id) {
    return accountRepository
      .findById(account_id)
      .orElseThrow(NoSuchElementException::new);
  }

  @Override
  public TransferDto deposit(Integer account_id, Integer amount) {
    Account accountToDeposit = accountRepository
      .findById(account_id)
      .orElse(new Account(account_id, amount));

    if (accountRepository.existsById(account_id)) {
      accountToDeposit.setBalance(accountToDeposit.getBalance() + amount);
    }

    accountRepository.save(accountToDeposit);

    TransferDto newDto = new TransferDto(accountToDeposit, null);
    return newDto;
  }

  @Override
  public TransferDto withdraw(Integer account_id, Integer amount) {
    Account accountToWithdraw = accountRepository
      .findById(account_id)
      .orElseThrow(NoSuchElementException::new);

    if (accountToWithdraw.getBalance() < amount) {
      throw new NoSuchElementException();
    }

    accountToWithdraw.setBalance(accountToWithdraw.getBalance() - amount);
    accountRepository.save(accountToWithdraw);

    TransferDto newDto = new TransferDto(null, accountToWithdraw);

    return newDto;
  }

  @Override
  public TransferDto transfer(
    Integer origin,
    Integer amount,
    Integer destination
  ) {
    Account accountOfOrigin = accountRepository
      .findById(origin)
      .orElseThrow(NoSuchElementException::new);
    Account accountOfDestination = accountRepository
      .findById(destination)
      .orElse(new Account(destination, amount));

    this.withdraw(origin, amount);
    this.deposit(destination, amount);

    return new TransferDto(accountOfOrigin, accountOfDestination);
  }
}
