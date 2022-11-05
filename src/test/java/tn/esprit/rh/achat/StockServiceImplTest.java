package tn.esprit.rh.achat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
    @Mock
    StockRepository stockRepo;
    @InjectMocks
    StockServiceImpl stockServiceImpl;

    @Test
    public void addStockMockTest() {
        //given
        Stock stock = new Stock("LibelleTest", 10, 1);

        //when
        Mockito.when(this.stockRepo.save(Mockito.any())).thenReturn(stock);
        Stock savedStock = stockServiceImpl.addStock(stock);


        //then
        assertNotNull(savedStock.getLibelleStock());
    }
}
