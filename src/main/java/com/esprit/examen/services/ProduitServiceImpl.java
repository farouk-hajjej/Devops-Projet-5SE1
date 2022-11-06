package com.esprit.examen.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    ProduitRepository produitRepository;


    @Override
    public List<Produit> retrieveAllProduits() {
        log.info("In method retrieveAllProduits");
        List<Produit> produits = produitRepository.findAll();
        for (Produit produit : produits) {
            log.info(" Produit : " + produit);
        }
        log.info("out of method retrieveAllProduits");
        return produits;
    }

    @Override
    public Produit addProduit(Produit p) {
        // récuperer la date à l'instant t1
        log.info("In method addStock");
        return produitRepository.save(p);

    }

    @Override
    public void deleteProduit(Long produitId) {
        log.info("In method deleteProduit");
        produitRepository.deleteById(produitId);

    }

    @Override
    public Produit updateProduit(Produit p) {
        log.info("In method updateProduit");
        return produitRepository.save(p);
    }

    @Override
    public Produit retrieveProduit(Long produitId) {
        long start = System.currentTimeMillis();
        log.info("In method retrieveProduit");
        Produit produit = produitRepository.findById(produitId).orElse(null);
        log.info("out of method retrieveProduit");
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");

        return produit;
    }


}