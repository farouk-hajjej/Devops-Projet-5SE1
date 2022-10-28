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

import static org.mockito.BDDMockito.willDoNothing;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceImplMock {


    @Mock
    ProduitRepository produitReposotory;
    @InjectMocks
    ProduitServiceImpl produitService;
    Produit p=new Produit((long) 1,"123","libelle 1",50);
    Produit p1=new Produit((long) 2,"123","libelle 2",60);
    Produit p2=new Produit((long) 3,"123","libelle 3",70);
    List<Produit> listProduits = new ArrayList<Produit>() {
        {
            add(p1);
            add(p2);
        }
    };

    @Test
    public void createProduitTest()
    {
        Produit pR=new Produit((long) 1,"123","libelle 1",50);
        produitService.addProduit(pR);
    }

    @Test
    public void RetrieveProduitTest() {
        Mockito.when(produitReposotory.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
        Produit produit1 = produitService.retrieveProduit((long)(2));
        Assertions.assertNotNull(produit1);
    }


    @Test
    public void updateProduitTest(){
        p.setLibelleProduit("Libelle 1 updated");
        Produit prm=new Produit(p.getIdProduit(),p.getCodeProduit(),p.getLibelleProduit(),p.getPrix());
        Produit updatedProduit = produitService.updateProduit(prm);
    }

    @Test
    public void deleteProduitTest(){
        willDoNothing().given(produitReposotory).deleteById(p1.getIdProduit());
        produitService.deleteProduit(p1.getIdProduit());
    }




}