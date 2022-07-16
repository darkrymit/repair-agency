package com.epam.finalproject.payload.request.search;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class ReceiptWithCustomerSearchRequest {
    String sort;
    Set<String> status;
    String master;
    Integer page;
    Integer count;
}
