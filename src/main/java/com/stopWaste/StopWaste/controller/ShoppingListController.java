package com.stopWaste.StopWaste.controller;

import com.stopWaste.StopWaste.dao.ShoppingListDao;
import com.stopWaste.StopWaste.model.ShoppingList;
import com.stopWaste.StopWaste.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ShoppingListController {
    ShoppingListDao shoppingListDao;

    @Autowired
    public ShoppingListController(final ShoppingListDao shoppingListDao) {
        this.shoppingListDao = shoppingListDao;
    }

    @GetMapping({"/shoppingList"})
    public List<ShoppingList> getShoppingList() {
        return shoppingListDao.findAll();
    }

    @PutMapping({"/addProduct"})
    public ShoppingList saveProduct(@RequestBody ShoppingList shoppingList) {
        return shoppingListDao.save(shoppingList);
    }

    @DeleteMapping({"/deleteProduct"})
    public String removeProductFromShoppingList(@RequestBody ShoppingList shoppingList) {
        if (shoppingList != null) {
            shoppingListDao.delete(shoppingList);
            return "Produit supprimé";
        } else {
            return "Produit non trouvé";
        }
    }

    @PutMapping({"/updateProduct"})
    public String updateProduct(@RequestBody ShoppingList shoppingList) {
        if (shoppingList != null){
            shoppingListDao.save(shoppingList);
            return "Produit modifié";
        }else{
            return "Produit non trouvé";
        }

    }
}
