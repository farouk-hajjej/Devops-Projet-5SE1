package com.esprit.examen.controllers;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.services.IProduitService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

    @Autowired
    IProduitService produitService;

    @GetMapping("/retrieve-all-produits")
    @ResponseBody
    public List<Produit> getProduits() {
        return  produitService.retrieveAllProduits();

    }

    @GetMapping("/retrieve-produit/{produit-id}")
    @ResponseBody
    public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
        return produitService.retrieveProduit(produitId);
    }
    @PostMapping("/add-produit")
    @ResponseBody
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);

    }

    @DeleteMapping("/remove-produit/{produit-id}")
    @ResponseBody
    public void removeProduit(@PathVariable("produit-id") Long produitId) {
        produitService.deleteProduit(produitId);
    }

    @PutMapping("/modify-produit")
    @ResponseBody
    public Produit modifyProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }


    }


