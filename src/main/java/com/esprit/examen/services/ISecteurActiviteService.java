package com.esprit.examen.services;

import com.esprit.examen.entities.SecteurActivite;

import java.util.List;

public interface ISecteurActiviteService {

	List<SecteurActivite> retrieveAllSecteurActivite();

	SecteurActivite addSecteurActivite(SecteurActivite sa);

	void deleteSecteurActivite(Long id);

	SecteurActivite updateSecteurActivite(SecteurActivite sa);

	SecteurActivite retrieveSecteurActivite(Long id);

}
