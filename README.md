# Ledger

Simple backend ledger  app written in vanilla Java (JAX-RS) and exposes number of REST endpoints detailed below.

## Needs
- Java 19+
- Maven
- Git

## Assumptions
All transactions are in the same currency.

## Installation
The app is configured to run with embedded Grizzly servlet container on port 8080.

To start the application, run the following commands in sequence:

- ``$ git clone https://github.com/bash123/ledger.git``
- ``$ cd ./ledger``
- ``$ mvn clean package exec:java``
- Wait for ``INFO: [HttpServer] Started.``
- Test with ``$ curl -X GET -H "Accept: application/json" 'http://localhost:8080/api/ledger/balance'``


## Endpoints
> Root path is http://localhost:8080/api/ledger

-  [/balance](http://localhost:8080/api/ledger/balance)
-  [/deposit](http://localhost:8080/api/ledger/deposit)
-  [/withdrawal](http://localhost:8080/api/ledger/withdrawal)
-  [/transaction-history](http://localhost:8080/api/ledger/transaction-history)
-  [/transaction-details/{id}](http://localhost:8080/api/ledger/transaction-details/{id})

## Examples

- [balance-example](./src/main/resources/balance-example)
- [deposit-example](./src/main/resources/deposit-example)
- [withdrawal-example](./src/main/resources/withdrawal-example)
- [transaction-history-example](./src/main/resources/transaction-history-example)
- [transaction-details-example](./src/main/resources/transaction-details-example)
- [violation-bad-amount](./src/main/resources/violation-bad-amount)
- [violation-bad-amount2](./src/main/resources/violation-bad-amount2)
- [violation-insufficient-balance](./src/main/resources/violation-insufficient-balance)
- [violation-bad-name](./src/main/resources/violation-bad-name)
- [violation-bad-transaction-id](./src/main/resources/violation-bad-transaction-id)
- [violation-example-multi](./src/main/resources/violation-example-multi)




