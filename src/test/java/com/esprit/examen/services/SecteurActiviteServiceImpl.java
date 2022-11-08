package com.esprit.examen.services;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SecteurActiviteServiceImpl {
    @Autowired
    ISecteurActiviteService secteurActiviteService;

    @Test
    @Order(3)
    void testRetrieveAllSecteurAct() {
        List<SecteurActivite> listSecteurs = secteurActiviteService.retrieveAllSecteurActivite();
        assertEquals(0, listSecteurs.size());
    }
    @Test
    @Order(1)
    void testAddSecteur() {
        List<SecteurActivite> listSecteurs = secteurActiviteService.retrieveAllSecteurActivite();
        int expected=listSecteurs.size();
        SecteurActivite s = new SecteurActivite(10,"fgh","dhdgh");
        SecteurActivite savedSecteur= secteurActiviteService.addSecteurActivite(s);
        assertEquals(expected+1, secteurActiviteService.retrieveAllSecteurActivite().size());
        assertNotNull(savedSecteur.getLibelleSecteurActivite());
        secteurActiviteService.deleteSecteurActivite(savedSecteur.getIdSecteurActivite());
    }

    @Test
    @Order(2)
    void testDeleteSecteur() {
        SecteurActivite s = new SecteurActivite(10,"code","fdhd");
        SecteurActivite savedSecteur= secteurActiviteService.addSecteurActivite(s);
        secteurActiviteService.deleteSecteurActivite(savedSecteur.getIdSecteurActivite());
        assertNull(secteurActiviteService.retrieveSecteurActivite(savedSecteur.getIdSecteurActivite()));
    }
}
