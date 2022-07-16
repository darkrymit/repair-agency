package com.epam.finalproject.service.impl;

import com.epam.finalproject.aop.logging.Loggable;
import com.epam.finalproject.model.entity.Receipt;
import com.epam.finalproject.model.entity.User;
import com.epam.finalproject.model.search.*;
import com.epam.finalproject.payload.request.search.*;
import com.epam.finalproject.repository.ReceiptRepository;
import com.epam.finalproject.repository.UserRepository;
import com.epam.finalproject.repository.specification.ReceiptSpecifications;
import com.epam.finalproject.repository.specification.UserSpecifications;
import com.epam.finalproject.service.SearchService;
import com.epam.finalproject.util.SearchRequestResolver;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {

    ReceiptRepository receiptRepository;

    UserRepository userRepository;

    SearchRequestResolver searchRequestResolver;

    @Override
    @Loggable
    public Page<Receipt> findBySearch(ReceiptSearch receiptSearch) {
        return receiptRepository.findAll(ReceiptSpecifications.matchSearch(receiptSearch), receiptSearch.getPageRequest());

    }

    @Override
    @Loggable
    public Page<Receipt> findBySearch(ReceiptSearchRequest receiptSearchRequest) {
        return findBySearch(searchRequestResolver.resolve(receiptSearchRequest));
    }

    @Override
    @Loggable
    public Page<Receipt> findBySearch(ReceiptWithCustomerSearch receiptSearch) {
        return receiptRepository.findAll(ReceiptSpecifications.matchSearch(receiptSearch), receiptSearch.getPageRequest());
    }

    @Override
    @Loggable
    public Page<Receipt> findBySearch(ReceiptWithCustomerSearchRequest receiptSearchRequest,User customer) {
        return findBySearch(searchRequestResolver.resolve(receiptSearchRequest,customer));
    }

    @Override
    @Loggable
    public Page<Receipt> findBySearch(ReceiptWithMasterSearch receiptSearch) {
        return receiptRepository.findAll(ReceiptSpecifications.matchSearch(receiptSearch), receiptSearch.getPageRequest());
    }

    @Override
    @Loggable
    public Page<Receipt> findBySearch(ReceiptWithMasterSearchRequest receiptSearchRequest,User master) {
        return findBySearch(searchRequestResolver.resolve(receiptSearchRequest,master));
    }

    @Override
    @Loggable
    public Page<User> findBySearch(UserSearch userSearch) {
        return userRepository.findAll(UserSpecifications.matchSearch(userSearch), userSearch.getPageRequest());
    }

    @Override
    @Loggable
    public Page<User> findBySearch(UserSearchRequest userSearchRequest) {
        return findBySearch(searchRequestResolver.resolve(userSearchRequest));
    }

    @Override
    @Loggable
    public Page<User> findBySearch(MasterSearch masterSearch) {
        return userRepository.findAll(UserSpecifications.matchSearch(masterSearch), masterSearch.getPageRequest());
    }
    @Override
    @Loggable
    public Page<User> findBySearch(MasterSearchRequest masterSearchRequest) {
        return findBySearch(searchRequestResolver.resolve(masterSearchRequest));
    }
}
