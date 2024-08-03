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
  private String id;

  @Min(0)
  @Column(nullable = false)
  private Integer balance;

  public Account() {}

  public Account(String id, @Min(0) Integer balance) {
    this.id = id;
    this.balance = balance;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "{id:" + id + ", balance:" + balance + "}";
  }
}
