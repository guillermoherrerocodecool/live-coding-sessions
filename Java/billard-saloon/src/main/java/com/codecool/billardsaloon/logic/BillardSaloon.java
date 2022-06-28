package com.codecool.billardsaloon.logic;

import com.codecool.billardsaloon.data.OrderElement;
import com.codecool.billardsaloon.data.Receipt;
import com.codecool.billardsaloon.data.Table;

import java.util.List;
import java.util.Set;

public class BillardSaloon {
    private final Set<Table> tables;
    private final Set<OrderElement> orderElements;
    private final List<Receipt> receipts;
    
    private final OrderService orderService;
    private final ReservationService reservationService;
    private final TableOverviewService tableOverviewService;

    public BillardSaloon(Set<Table> tables, Set<OrderElement> orderElements, List<Receipt> receipts, OrderService orderService, ReservationService reservationService, TableOverviewService tableOverviewService) {
        this.tables = tables;
        this.orderElements = orderElements;
        this.receipts = receipts;
        this.orderService = orderService;
        this.reservationService = reservationService;
        this.tableOverviewService = tableOverviewService;
    }

    public void run() {
        // display menu
        // get user option (consume OrderElements / reserve a table / pay / ask questions)
        // 
    }
}
