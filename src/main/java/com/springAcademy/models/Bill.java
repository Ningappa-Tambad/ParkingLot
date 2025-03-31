package com.springAcademy.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {

    private Ticket ticket;
    private Gate gate;
    private BillsStatus billStatus;
    private int amount;
    private List<Payment> payments;
    private Date exitTime;
    private FeeCalculationStrategyType feeCalculationStrategyType;
}
