package com.apiebanxs.pvd_api.dto;

public class RequestDto {

  private String type;
  private Integer destination;
  private Integer origin;
  private Integer amount;

  public RequestDto() {}

  public RequestDto(
    String type,
    Integer destination,
    Integer origin,
    Integer amount
  ) {
    this.type = type;
    this.destination = destination;
    this.origin = origin;
    this.amount = amount;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getDestination() {
    return destination;
  }

  public void setDestination(Integer destination) {
    this.destination = destination;
  }

  public Integer getOrigin() {
    return origin;
  }

  public void setOrigin(Integer origin) {
    this.origin = origin;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return (
      "RequestDto [type=" +
      type +
      ", destination=" +
      destination +
      ", origin=" +
      origin +
      ", amount=" +
      amount +
      "]"
    );
  }
}
