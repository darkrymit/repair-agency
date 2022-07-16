package com.epam.finalproject.payload.request.search;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class ReceiptSearchRequest {
    String sort;
    Set<String> status;
    String customer;
    String master;
    Integer page;
    Integer count;
}
