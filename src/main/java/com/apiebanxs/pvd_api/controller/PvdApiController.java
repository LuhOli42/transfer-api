package com.apiebanxs.pvd_api.controller;

import com.apiebanxs.pvd_api.dto.RequestDto;
import com.apiebanxs.pvd_api.dto.TransferDto;
import com.apiebanxs.pvd_api.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PvdApiController {

  private final AccountService accountService;

  public PvdApiController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/balance")
  public ResponseEntity<Integer> balance(
    @RequestParam("account_id") Integer account_id
  ) {
    var balance = accountService.findById(account_id).getBalance();
    return ResponseEntity.ok(balance);
  }

  @PostMapping("/event")
  public ResponseEntity<TransferDto> event(
    @RequestBody RequestDto requestedDto
  ) {
    TransferDto finalDto = null;

    if (requestedDto.getType().equals("deposit")) {
      finalDto =
        accountService.deposit(
          requestedDto.getDestination(),
          requestedDto.getAmount()
        );
    }

    if (requestedDto.getType().equals("withdraw")) {
      finalDto =
        accountService.withdraw(
          requestedDto.getOrigin(),
          requestedDto.getAmount()
        );
    }

    if (requestedDto.getType().equals("transfer")) {
      finalDto =
        accountService.transfer(
          requestedDto.getOrigin(),
          requestedDto.getAmount(),
          requestedDto.getDestination()
        );
    }

    return ResponseEntity.ok(finalDto);
  }
}
