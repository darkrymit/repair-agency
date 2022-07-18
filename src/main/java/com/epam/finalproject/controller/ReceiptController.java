package com.epam.finalproject.controller;

import com.epam.finalproject.dto.ReceiptDTO;
import com.epam.finalproject.model.entity.Receipt;
import com.epam.finalproject.payload.request.receipt.create.ReceiptCreateRequest;
import com.epam.finalproject.payload.request.receipt.update.ReceiptUpdateRequest;
import com.epam.finalproject.service.ReceiptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
@AllArgsConstructor
@Slf4j
public class ReceiptController {
    ReceiptService receiptService;

    @PatchMapping("/{id}")
    String update(Model model, @RequestBody ReceiptUpdateRequest updateRequest, @RequestParam(required = false) String redirectURL, @PathVariable Long id) {
        updateRequest.setId(id);
        Receipt receipt = receiptService.update(updateRequest);
        return "redirect:/"+receipt.getId();
    }
    @GetMapping("/{id}")
    String show(Model model, @RequestParam(required = false) String redirectURL, @PathVariable Long id) {
        ReceiptDTO receipt = receiptService.findById(id);
        model.addAttribute("order",receipt);
        return "order";
    }

    @PostMapping("/create")
    String create(Model model, @RequestBody ReceiptCreateRequest createRequest, @RequestParam(required=false) String redirectURL) {
        Receipt receipt = receiptService.createNew(createRequest);
        return "redirect:/"+receipt.getId();
    }


}
