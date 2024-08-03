package com.apiebanxs.pvd_api.dto;

public class RequestDto {

  private String type;
  private String destination;
  private String origin;
  private Integer amount;

  public RequestDto() {}

  public RequestDto(
    String type,
    String destination,
    String origin,
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

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
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
