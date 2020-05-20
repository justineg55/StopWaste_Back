package com.stopWaste.StopWaste.dao;

import com.stopWaste.StopWaste.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<Stock, Long> {
}
