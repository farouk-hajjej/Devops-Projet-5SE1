package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;

import java.util.List;

public interface IProduitService {

    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p);

    void deleteProduit(Long id);

    Produit updateProduit(Produit p);

    Produit retrieveProduit(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);

}