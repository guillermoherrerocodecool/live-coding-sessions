package com.codecool.billardsaloon.logic;

import com.codecool.billardsaloon.data.Receipt;
import com.codecool.billardsaloon.data.Table;
import com.codecool.billardsaloon.data.TableType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ReservationService {
    private final Set<Table> tables;
    private final List<Receipt> receipts;
    private final ReservationValidator reservationValidator;

    public ReservationService(Set<Table> tables, List<Receipt> receipts, ReservationValidator reservationValidator) {
        this.tables = tables;
        this.receipts = receipts;
        this.reservationValidator = reservationValidator;
    }

    public Optional<Receipt> reserve(TableType tableType, LocalDateTime time) {
        if (!reservationValidator.isValid(tableType, time)) {
            return Optional.empty();
        }
        return doReserve(tableType, time);
    }

    private Optional<Receipt> doReserve(TableType tableType, LocalDateTime time) {
        Set<Table> availableTables = findAvailable(tableType);
        if (availableTables.isEmpty()) {
            return Optional.empty();
        }
        Table table = availableTables.iterator().next();
        Receipt receipt = new Receipt(table, new ArrayList<>(), time);
        receipts.add(receipt);
        return Optional.of(receipt);
    }

    private Set<Table> findAvailable(TableType tableType) {
        List<Table> reservedTables = receipts.stream()
                .filter(receipt -> receipt.getEndTime().isEmpty())
                .map(Receipt::getTable)
                .toList();
        return tables.stream()
                .filter(table -> table.type().equals(tableType))
                .filter(table -> !reservedTables.contains(table))
                .collect(toSet());
    }
}
