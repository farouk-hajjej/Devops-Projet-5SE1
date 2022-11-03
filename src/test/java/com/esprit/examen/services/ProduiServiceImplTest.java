package com.esprit.examen.services;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ProduiServiceImplTest {
    @Autowired
    IProduitService produitService;

    @Autowired
    ProduitRepository produitRepository;

    Produit produit = new Produit("p", "pc" , 12 ,new Date() );
    @Test
    @Order(1)
    public void testaddProdiut() {
        Produit produitAdded =  produitService.addProduit(produit);
        Assertions.assertEquals(produitAdded.getCodeProduit(), produitAdded.getCodeProduit());
    }

    @Test
    @Order(2)
    public void testRetrieveAllProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        Assertions.assertEquals(listProduits.size(), listProduits.size());
    }





}