package com.esprit.examen.services;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Produit;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTest {
    @Autowired
    IProduitService produitService;

    @Test
    @Order(4)
    public void testRetrieveAllProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }
    @Test
    @Order(1)
    public void testAddProduit() {
        List<Produit> produits = produitService.retrieveAllProduits();
        int expected=produits.size();
        Produit p = new Produit((long)4,"pc","10",100);
        Produit savedProduit= produitService.addProduit(p);

        assertEquals(expected+1, produitService.retrieveAllProduits().size());
        assertNotNull(savedProduit.getLibelleProduit());
        produitService.deleteProduit(savedProduit.getIdProduit());

    }

    @Test
    @Order(3)
    public void testAddProduitOptimized() {

        Produit p = new Produit((long)4,"pc","10",100);
        Produit savedProduit= produitService.addProduit(p);
        assertNotNull(savedProduit.getIdProduit());
        assertSame(100, savedProduit.getPrix());
        assertTrue(savedProduit.getPrix()>0);
        produitService.deleteProduit(savedProduit.getIdProduit());

    }

    @Test
    @Order(2)
    public void testDeleteProduit() {
        Produit p = new Produit((long)4,"produit test","pc",60);
        Produit savedProduit= produitService.addProduit(p);
        produitService.deleteProduit(savedProduit.getIdProduit());
        assertNull(produitService.retrieveProduit(savedProduit.getIdProduit()));
    }
}