<p align="center"><b>Transfer API - API to manager Bank transfer</b></p>

## About

This project was created as a home assigment to Ebanx Job interview.

## Features

- Reset Api
- Get balance of a account
- Transitions

## Techs

- Java
- Sprinboot
- h2 database

## Routes

#### `POST` `/reset`

This route reset all account.

#### `GET` `/balance?account_id={id}`

This route thru a request param return a balance of the account.

#### `POST` `/event`

This route you can do a transition

- **Body Request**  
  The body resquest has to follow up with this object:

  - type: "deposit"/"withdraw"/"transfer"
  - destination: (mandatory for deposit and transfer)
  - origin: (mandatory for witdraw and transfer)
  - ammount: (mandatory number higher than 0)
