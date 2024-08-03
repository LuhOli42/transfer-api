package com.apiebanxs.pvd_api.dto;

import com.apiebanxs.pvd_api.model.Account;

public class TransferDto {

  private Account origin;
  private Account destination;

  public TransferDto() {}

  public TransferDto(Account origin, Account destination) {
    this.origin = origin;
    this.destination = destination;
  }

  public Account getOrigin() {
    return origin;
  }

  public void setOrigin(Account origin) {
    this.origin = origin;
  }

  public Account getDestination() {
    return destination;
  }

  public void setDestination(Account destination) {
    this.destination = destination;
  }

  @Override
  public String toString() {
    return ("{origin: " + origin + ", destination: " + destination + "}");
  }
}
