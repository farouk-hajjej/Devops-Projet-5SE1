package com.esprit.examen.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
    @SpringBootTest
    @ExtendWith(MockitoExtension.class)
    public class ProductServiceImplMock {

        @Mock
        ProduitRepository produitRepository;

        @InjectMocks
        ProduitServiceImpl produitServiceImpl;

        Produit produit = new Produit("p1", "pc" , 12 ,new Date() );

        List<Produit> listUsers = new ArrayList<Produit>() {
            {
                add(new Produit("p2", "phone", 13,  new Date()));
                add(new Produit("p3", "game", 14 , new Date()));
            }
        };
        @Test
        public void testRetrieveProduit() {
            Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
            Produit prod1 = produitServiceImpl.retrieveProduit(1L);
            Assertions.assertNotNull(prod1);
        }


    }