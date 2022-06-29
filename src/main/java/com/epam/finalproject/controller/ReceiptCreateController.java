package com.epam.finalproject.controller;

import com.epam.finalproject.entity.Receipt;
import com.epam.finalproject.payload.request.receipt.create.ReceiptCreateRequest;
import com.epam.finalproject.service.ReceiptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
@AllArgsConstructor
@Slf4j
public class ReceiptCreateController {
    ReceiptService receiptService;

    @PostMapping("/create")
    String create(Model model, @RequestBody ReceiptCreateRequest createRequest, @RequestParam(required=false) String redirectURL) {
        Receipt receipt = receiptService.createNew(createRequest);
        return "redirect:/"+receipt.getId();
    }

}
