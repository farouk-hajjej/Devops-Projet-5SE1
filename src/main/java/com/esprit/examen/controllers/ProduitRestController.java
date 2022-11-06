package com.esprit.examen.controllers;



import com.esprit.examen.dto.ProduitDTO;
import org.modelmapper.ModelMapper;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.services.IProduitService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

    @Autowired
    IProduitService produitService;
    @Autowired
    private ModelMapper modelMapper;

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
    public Produit addProduit(@RequestBody ProduitDTO p) {
        Produit persistentProduit = modelMapper.map(p,Produit.class);
        return produitService.addProduit( persistentProduit);

    }

    @DeleteMapping("/remove-produit/{produit-id}")
    @ResponseBody
    public void removeProduit(@PathVariable("produit-id") Long produitId) {
        produitService.deleteProduit(produitId);
    }

    @PutMapping("/modify-produit")
    @ResponseBody
    public Produit modifyProduit(@RequestBody ProduitDTO produit) {
        Produit persistentProduit = modelMapper.map(produit,  Produit.class);
        return produitService.updateProduit(persistentProduit);
    }



}