package com.epam.finalproject.controller;

import com.epam.finalproject.dto.ReceiptDTO;
import com.epam.finalproject.dto.ReceiptStatusFlowDTO;
import com.epam.finalproject.dto.UserDTO;
import com.epam.finalproject.payload.request.search.MasterSearchRequest;
import com.epam.finalproject.payload.request.search.ReceiptSearchRequest;
import com.epam.finalproject.payload.request.search.UserSearchRequest;
import com.epam.finalproject.service.ReceiptService;
import com.epam.finalproject.service.ReceiptStatusFlowService;
import com.epam.finalproject.service.SearchService;
import com.epam.finalproject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manager")
@AllArgsConstructor
@Slf4j
public class ManagerController {

    public static final String ACTIVE = "active";

    public static final String MANAGER_VIEW = "cabinet";

    public static final String TYPE = "type";
    public static final String MANAGER = "manager";
    public static final String SEARCH = "search";

    SearchService searchService;

    ReceiptService receiptService;

    ReceiptStatusFlowService receiptStatusFlowService;

    UserService userService;


    @GetMapping("/home")
    String homePage(Model model) {
        model.addAttribute(ACTIVE, "home");
        model.addAttribute(TYPE, MANAGER);
        return MANAGER_VIEW;
    }

    @GetMapping("/orders")
    String ordersPage(Model model, @AuthenticationPrincipal UserDetails userDetails, ReceiptSearchRequest receiptSearchRequest) {
        Page<ReceiptDTO> receipts = searchService.findBySearch(receiptSearchRequest);
        List<ReceiptStatusFlowDTO> flows = receiptStatusFlowService.listAllAvailableForUser(userDetails.getUsername());
        model.addAttribute("flows",flows);
        model.addAttribute(SEARCH,receiptSearchRequest);
        model.addAttribute("receipts", receipts);
        model.addAttribute(ACTIVE, "orders");
        model.addAttribute(TYPE, MANAGER);
        return MANAGER_VIEW;
    }

    @GetMapping("/users")
    String usersPage(Model model, UserSearchRequest userSearchRequest) {
        Page<UserDTO> users = searchService.findBySearch(userSearchRequest);
        model.addAttribute(SEARCH,userSearchRequest);
        model.addAttribute("users", users);
        model.addAttribute(ACTIVE, "users");
        model.addAttribute(TYPE, MANAGER);
        return MANAGER_VIEW;
    }

    @GetMapping("/masters")
    String mastersPage(Model model, MasterSearchRequest masterSearchRequest) {
        Page<UserDTO> masters = searchService.findBySearch(masterSearchRequest);
        model.addAttribute(SEARCH,masterSearchRequest);
        model.addAttribute("masters", masters);
        model.addAttribute(ACTIVE, "masters");
        model.addAttribute(TYPE, MANAGER);
        return MANAGER_VIEW;
    }
    @GetMapping("/responses")
    String responsesPage(Model model) {
        model.addAttribute(ACTIVE, "responses");
        model.addAttribute(TYPE, MANAGER);
        return MANAGER_VIEW;
    }
}
