package edu.wctc.stockpurchase.controller;

import edu.wctc.stockpurchase.entity.StockPurchase;
import edu.wctc.stockpurchase.service.StockPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stock-purchases")
public class StockPurchaseController {

    private StockPurchaseService service;

    @Autowired
    public StockPurchaseController(StockPurchaseService sps) {
        this.service = sps;
    }

    @GetMapping
    public List<StockPurchase> getStockPurchases() {
        return service.getAllStockPurchases();
    }

    @PostMapping
    public StockPurchase createStockPurchase(@RequestBody StockPurchase stock) {
        stock.setId(0);
        return service.save(stock);
    }

    @DeleteMapping("/{stockPurchaseId}")
    public String deleteStockPurchase(@PathVariable String stockPurchaseId) {
        try {
            int id = Integer.parseInt(stockPurchaseId);
            service.delete(id);
            return "StockPurchase Deleted: ID " + stockPurchaseId;
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "StockPurchase ID must be a number", e);
        }
    }

    @PutMapping
    public StockPurchase updateStockPurchase(@RequestBody StockPurchase stock) {
        return service.update(stock);
    }

    @GetMapping("/{stockPurchaseId}")
    public Optional<StockPurchase> getStockPurchase(@PathVariable String stockPurchaseId) {
        int id = Integer.parseInt(stockPurchaseId);
        return service.getStockPurchase(id);
    }

}
