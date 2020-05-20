package com.stopWaste.StopWaste.controller;

import com.stopWaste.StopWaste.dao.StockDao;
import com.stopWaste.StopWaste.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StockController {
    StockDao stockDao;

    @Autowired
    public StockController(final StockDao stockDao){
        this.stockDao=stockDao;
    }

    @GetMapping({"/liststock"})
    public List<Stock> getListStock(){
        return stockDao.findAll();
    }

    @PutMapping({"/addStock"})
    public Stock saveProduct(@RequestBody Stock stock){
        return stockDao.save(stock);
    }

    @DeleteMapping({"/deleteStock"})
    public String removeProductofStock(@RequestBody Stock stock) {
        if (stock != null) {
            stockDao.delete(stock);
            return "Produit supprimé";
        }else{
            return "Produit non trouvé";
        }
    }

    @PutMapping({"/updateStock"})
    public String updateProduct(@RequestBody Stock stock){
        if (stock != null) {
            stockDao.save(stock);
            return "Produit modifié";
        }else{
            return "Produit non trouvé";
        }

//        stockDao.findById(stock.getId())
//                .map(stockFound -> {
//                    stockFound.setName(stock.getName());
//                    stockFound.setQuantity(stock.getQuantity());
//                    stockFound.setExpiration(stock.getExpiration());
//                    return stockDao.save(stockFound);
//                })
//                .orElse(null);

    }
}
