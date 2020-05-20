package com.stopWaste.StopWaste.dao;

import com.stopWaste.StopWaste.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListDao extends JpaRepository<ShoppingList, Long> {
}
