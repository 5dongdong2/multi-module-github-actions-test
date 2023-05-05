package com.study.web.repository;

import com.study.web.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Item, Long> {
}
