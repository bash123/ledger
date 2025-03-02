package org.ledger.services;

import jakarta.inject.Singleton;
import org.ledger.mapper.LedgerApplicationException;
import org.ledger.request.TransactionRequest;
import org.ledger.response.TransactionHistoryResponseItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class LedgerService {
    private final Map<UUID, Transaction> ledger = new LinkedHashMap<>();
    private BigDecimal balance = BigDecimal.ZERO;

    public BigDecimal getBalance() {
        return balance;
    }

    public List<TransactionHistoryResponseItem> getTransactionHistory() {
        return ledger.entrySet().stream()
                .map(entry -> new TransactionHistoryResponseItem(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

    }

    public UUID makeDeposit(TransactionRequest request) {
        final UUID uuid = getUUID();

        final Transaction transaction  =
                new Transaction(
                        request.getSubmitterFirstName(),
                        request.getSubmitterLastName(),
                        request.getAmount(),
                        LocalDateTime.now(),
                        TransactionDirectionEnum.DEPOSIT);

        ledger.put(uuid, transaction);
        balance = balance.add(transaction.getAmount());

        return uuid;
    }

    public UUID makeWithdrawal(TransactionRequest request) throws LedgerApplicationException {

        if (balance.compareTo(request.getAmount()) < 0) {
            throw new LedgerApplicationException(String.format("Cannot withdrawal %s: Insufficient balance",
                    request.getAmount()));
        }

        final UUID uuid = getUUID();

        final Transaction transaction  =
                new Transaction(
                        request.getSubmitterFirstName(),
                        request.getSubmitterLastName(),
                        request.getAmount(),
                        LocalDateTime.now(),
                        TransactionDirectionEnum.WITHDRAWAL);

        ledger.put(uuid, transaction);
        balance = balance.subtract(transaction.getAmount());

        return uuid;
    }

    public Transaction getTransactionDetail(UUID uuid) throws LedgerApplicationException {

        if (!ledger.containsKey(uuid)) {
            throw new LedgerApplicationException(String.format("Transaction ID does not exist: %s", uuid));
        }

        return ledger.get(uuid);
    }

    private UUID getUUID() {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (ledger.containsKey(uuid));

        return uuid;
    }
}
