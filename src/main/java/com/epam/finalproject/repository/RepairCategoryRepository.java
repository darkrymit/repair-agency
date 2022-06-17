package com.epam.finalproject.repository;

import com.epam.finalproject.entity.RepairCategory;
import com.epam.finalproject.entity.RepairCategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepairCategoryRepository extends JpaRepository<RepairCategory, Long> {
    Optional<RepairCategory> findByName(RepairCategoryName repairCategoryName);
}