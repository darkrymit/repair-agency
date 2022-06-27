package com.epam.finalproject.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.domain.PageRequest;

@Value
@AllArgsConstructor
@Builder
public class UserSearch {
    PageRequest pageRequest;
    String username;
}
