package com.esprit.examen.controllers;



import java.util.List;

import com.esprit.examen.dto.StockDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.services.IStockService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des stocks")
@RequestMapping("/stock")
public class StockRestController {

	@Autowired
	IStockService stockService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getStocks() {
		return stockService.retrieveAllStocks();

	}


	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}


	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody StockDTO s) {
		Stock persistentStock = modelMapper.map(s,Stock.class);

		return  stockService.addStock( persistentStock);
	}


	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}


	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody StockDTO stock) {
		Stock persistentStock = modelMapper.map(stock,  Stock.class);

		return  stockService.updateStock( persistentStock);
	}



}