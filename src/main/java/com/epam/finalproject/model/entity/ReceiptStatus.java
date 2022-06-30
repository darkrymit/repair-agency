package com.epam.finalproject.model.entity;

import com.epam.finalproject.model.entity.enums.ReceiptStatusEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "receipt_statuses")
@Data

public class ReceiptStatus {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReceiptStatusEnum name;
}
