package com.esprit.examen.services;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
@SpringBootTest(classes =ProduitServiceImplMockIT.class)
@ExtendWith(MockitoExtension.class)
class ProduitServiceImplMockIT {
    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitServiceImpl produitServiceImp;

    Produit produit = new Produit((long)1, "2365","produit1",50);

    List<Produit> listProduits = new ArrayList<Produit>() {
        {
            add(new Produit((long)2, "9687","produit2",30));
            add(new Produit((long)3, "4503","produit3",70));
        }
    };
    @Test
    void testRetrieveProduit() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produit1 = produitServiceImp.retrieveProduit((long)1);
        Assertions.assertNotNull(produit1);
    }


    @Test
    void testRetrieveProsuitByid() {
        when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produitp = produitServiceImp.retrieveProduit((long)1);
        System.out.println(produitp);
        Assertions.assertNotNull(produitp);
    }
    @Test
    void testRetrieveAllProduit() {
        List<Produit> produits = new ArrayList();
        produits.add(new Produit());
        when(produitRepository.findAll()).thenReturn(produits);
        List<Produit> expected = produitServiceImp.retrieveAllProduits();
        Assertions.assertEquals(expected, produits);
        verify(produitRepository).findAll();
    }
    @Test
    void testCreateNewObject() {
        Produit obj = new Produit((long)4,"15444", "new",3);
        when(produitRepository.save(isA(Produit.class))).thenAnswer(invocation -> (Produit) invocation.getArguments()[0]);
        Produit returnedObj = produitServiceImp.addProduit(obj);
        ArgumentCaptor<Produit> savedObjectArgument = ArgumentCaptor.forClass(Produit.class);
        verify(produitRepository, times(1)).save(savedObjectArgument.capture());
        verifyNoMoreInteractions(produitRepository);
        Produit savedRestObject = savedObjectArgument.getValue();
        Assertions.assertNotNull(savedRestObject);
    }
    @Test
    void testDeleteObject() {
        Produit produite = new Produit();
        produite.setLibelleProduit("new test");
        produite.setIdProduit(1L);
        when(produitRepository.findById(produite.getIdProduit())).thenReturn(Optional.of(produite));
        Produit produitp = produitServiceImp.retrieveProduit(1L);
        produitServiceImp.deleteProduit(produitp.getIdProduit());
        verify(produitRepository).deleteById(produitp.getIdProduit());
    }


}