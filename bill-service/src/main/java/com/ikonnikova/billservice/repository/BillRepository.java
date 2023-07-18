package com.ikonnikova.billservice.repository;

import com.ikonnikova.billservice.entity.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {
}
