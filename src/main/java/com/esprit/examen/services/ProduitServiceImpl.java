package com.esprit.examen.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    ProduitRepository produitRepository;


    @Override
    public List<Produit> retrieveAllProduits() {
        List<Produit> produits = produitRepository.findAll();
        for (Produit produit : produits) {
            log.info(" Produit : " + produit);
        }
        return produits;
    }

    @Transactional
    public Produit addProduit(Produit p) {
        produitRepository.save(p);
        return p;
    }

    @Override
    public void deleteProduit(Long produitId) {
        produitRepository.deleteById(produitId);
    }

    @Override
    public Produit updateProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public Produit retrieveProduit(Long produitId) {
        Produit produit = produitRepository.findById(produitId).orElse(null);
        log.info("produit :" + produit);
        return produit;
    }




}