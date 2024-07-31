package com.apiebanxs.pvd_api.service;

import com.apiebanxs.pvd_api.dto.TransferDto;
import com.apiebanxs.pvd_api.model.Account;

public interface AccountService {
  Account findById(Integer account_id);
  TransferDto deposit(Integer account_id, Integer amount);
  TransferDto withdraw(Integer account_id, Integer amount);
  TransferDto transfer(Integer origin, Integer amount, Integer destination);
}
