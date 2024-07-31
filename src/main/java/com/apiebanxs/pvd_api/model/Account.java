package com.apiebanxs.pvd_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "accounts")
public class Account {

  @Id
  private Integer account_id;

  @Min(0)
  @Column(nullable = false)
  private Integer balance;

  public Account() {}

  public Account(Integer account_id, @Min(0) Integer balance) {
    this.account_id = account_id;
    this.balance = balance;
  }

  public Integer getAccount_id() {
    return account_id;
  }

  public void setAccount_id(Integer account_id) {
    this.account_id = account_id;
  }

  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }
}
