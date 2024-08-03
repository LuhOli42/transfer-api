package com.apiebanxs.pvd_api.service;

import com.apiebanxs.pvd_api.dto.TransferDto;
import com.apiebanxs.pvd_api.model.Account;

public interface AccountService {
  void resetAPI();
  Account findById(String account_id);
  TransferDto deposit(String id, Integer amount);
  TransferDto withdraw(String id, Integer amount);
  TransferDto transfer(String origin, Integer amount, String destination);
}
