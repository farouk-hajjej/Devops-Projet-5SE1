package com.esprit.examen.services;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(classes =SecteurActiviteMockitoTest.class)
@ExtendWith(MockitoExtension.class)
class SecteurActiviteMockitoTest {

    @Mock
    SecteurActiviteRepository secteurActiviteRepository;
    @InjectMocks
    SecteurActiviteServiceImpl secteurActiviteService;
    SecteurActivite s = new SecteurActivite(10,"fgh","dhdgh");

    List<SecteurActivite> listSecteur = new ArrayList<SecteurActivite>() {
        {
            add(new SecteurActivite(3, "f1","f2"));
            add(new SecteurActivite(4, "ff","aa"));
        }
    };
    @Test
    void testRetrieveSecteur() {
        when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        SecteurActivite secteurActivite = secteurActiviteService.retrieveSecteurActivite(1L);
        Assertions.assertNotNull(secteurActivite);
    }

    @Test
    void testRetrieveSecteurByid() {
        when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        SecteurActivite secteurActivite = secteurActiviteService.retrieveSecteurActivite(1L);
        System.out.println(secteurActivite);
        Assertions.assertNotNull(secteurActivite);
    }
    @Test
    void testRetrieveAllSecteur() {
        List<SecteurActivite> secteurs = new ArrayList();
        secteurs.add(new SecteurActivite());
        when(secteurActiviteRepository.findAll()).thenReturn(secteurs);
        List<SecteurActivite> expected = secteurActiviteService.retrieveAllSecteurActivite();
        Assertions.assertEquals(expected, secteurs);
        verify(secteurActiviteRepository).findAll();
    }
    @Test
    void testDeleteSecteur() {
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setLibelleSecteurActivite("new test");
        secteurActivite.setIdSecteurActivite(1L);
        when(secteurActiviteRepository.findById(secteurActivite.getIdSecteurActivite())).thenReturn(Optional.of(secteurActivite));
        SecteurActivite secteurActivite1 = secteurActiviteService.retrieveSecteurActivite(1L);
        secteurActiviteService.deleteSecteurActivite(secteurActivite1.getIdSecteurActivite());
        verify(secteurActiviteRepository).deleteById(secteurActivite1.getIdSecteurActivite());
    }

}
