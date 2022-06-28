package com.codecool.billardsaloon;

import com.codecool.billardsaloon.data.OrderElement;
import com.codecool.billardsaloon.data.Receipt;
import com.codecool.billardsaloon.data.Table;
import com.codecool.billardsaloon.data.TableType;
import com.codecool.billardsaloon.logic.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Set<Table> tables = Set.of(new Table(1, TableType.POOL));
        Set<OrderElement> orderElements = Set.of();
        List<Receipt> receipts = new ArrayList<>();
        OrderService orderService = new OrderService(orderElements);
        ReservationValidator reservationValidator = new ReservationValidator();
        ReservationService reservationService = new ReservationService(tables, receipts, reservationValidator);
        Map<TableType, Double> prices = Map.of(TableType.POOL, 10.50, TableType.SNOOKER, 11.50);
        BillingService billingService = new BillingService(prices);
        TableOverviewService tableOverviewService = new TableOverviewService(tables, receipts, billingService);
        BillardSaloon billardSaloon = new BillardSaloon(tables, orderElements, receipts, orderService, reservationService, tableOverviewService);
        billardSaloon.run();
    }
}
