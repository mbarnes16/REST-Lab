package edu.wctc.stockpurchase.service;

import edu.wctc.stockpurchase.entity.StockPurchase;
import edu.wctc.stockpurchase.repo.StockPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockPurchaseService {
    private StockPurchaseRepository repo;

    @Autowired
    public StockPurchaseService(StockPurchaseRepository spr) {
        repo = spr;
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public StockPurchase update(StockPurchase stock) {
        return repo.save(stock);
    }

    public StockPurchase save(StockPurchase stock) {
        return repo.save(stock);
    }

    public List<StockPurchase> getAllStockPurchases() {
        List<StockPurchase> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    public Optional<StockPurchase> getStockPurchase(int id){
        return repo.findById(id);
    }


}
