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
     class ProductServiceImplMockIT {

        @Mock
        ProduitRepository produitRepository;

        @InjectMocks
        ProduitServiceImpl produitServiceImpl;

        Produit produit = new Produit("p", "pc" , 12 ,new Date() );
        Produit produit1 = new Produit("p2", "game" , 90 ,new Date() );
        Produit produit2 = new Produit("p3", "phone" , 15 ,new Date() );
        List<Produit> list = new ArrayList<Produit>() {
            {
                add(produit1);
                add(produit2);
            }
        };



        @Test
         void testRetrieveProduit() {
            Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
            Produit prod1 = produitServiceImpl.retrieveProduit(1L);
            Assertions.assertNotNull(prod1);
        }


        @Test
        void updateProduitTest(){
            produit.setLibelleProduit("Libelle 1 updated");
            Assertions.assertNotNull(produitServiceImpl.updateProduit(produit));
        }
        @Test
        void deleteSecteurTest(){
            produitServiceImpl.deleteProduit(
                    produit2.getIdProduit());
            Assertions.assertNotNull(list);
        }

    }
