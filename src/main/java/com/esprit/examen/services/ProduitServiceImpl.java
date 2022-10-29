package com.esprit.examen.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    StockRepository stockRepository;

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

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit = produitRepository.findById(idProduit).orElse(null);
        Stock stock = stockRepository.findById(idStock).orElse(null);
        assert produit != null;
        produit.setStock(stock);
        produitRepository.save(produit);

    }


}