package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.esprit.examen.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;
@ExtendWith(MockitoExtension.class)
//@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	IStockService stockService;
	@Mock
    StockRepository stockRepository;
	Stock s =Stock.builder().libelleStock("string").qte(2).qteMin(3).build();
	List<Stock> list=new ArrayList<Stock>(){
		{
			add(Stock.builder().libelleStock("hhh").qte(222).qteMin(22).build());
			add(Stock.builder().libelleStock("hhddh").qte(22552).qteMin(22).build());
		}

	};
	/*
	@Test
	public void testAddStock() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());
		
	}
	*/
	 
	public void retreiveStockTest(){
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        Stock stock=stockService.retrieveStock((long)2);
        assertNotNull(stock);
        log.info("get ==>" + stock.toString());
    }
	@Test
	public void testAddStockOptimized() {

		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
		
	} 
	/*
	@Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}
*/
}
