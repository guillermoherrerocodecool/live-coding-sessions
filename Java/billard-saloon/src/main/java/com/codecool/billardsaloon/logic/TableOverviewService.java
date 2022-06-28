package com.codecool.billardsaloon.logic;

import com.codecool.billardsaloon.data.Receipt;
import com.codecool.billardsaloon.data.Table;
import com.codecool.billardsaloon.data.TableType;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class TableOverviewService {
    private final Set<Table> tables;
    private final List<Receipt> receipts;

    private final BillingService billingService;

    public TableOverviewService(Set<Table> tables, List<Receipt> receipts, BillingService billingService) {
        this.tables = tables;
        this.receipts = receipts;
        this.billingService = billingService;
    }

    public Map<TableType, List<Table>> getByType() {
        return tables.stream()
                .collect(groupingBy(Table::type));
    }

    public Optional<Receipt> getHighestOpen() {
        return receipts.stream()
                .filter(receipt -> receipt.getEndTime().isEmpty())
                .max((e1, e2) -> max(e1, e2));
    }

     int max(Receipt recepit1, Receipt receipt2) {
        return billingService.calculate(recepit1) > billingService.calculate(receipt2) ? -1 : 1;
    }
}
