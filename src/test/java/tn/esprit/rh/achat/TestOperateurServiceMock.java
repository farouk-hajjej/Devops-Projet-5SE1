package tn.esprit.rh.achat;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyLong;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class TestOperateurServiceMock {

	@Mock
	OperateurRepository or;
	@InjectMocks
	OperateurServiceImpl osI;

	Operateur o = Operateur.builder().idOperateur((long) 7).nom("salma").prenom("belhadj ali").password("azerty").build();

	@Test
	public void AddOperateur() {
		Operateur o_add = new Operateur();
		o_add.setNom("salma add");
		o_add.setPrenom("belhadj ali add");
		o_add.setPassword("password add");

		Mockito.when(or.save(ArgumentMatchers.any(Operateur.class))).thenReturn(o_add);

		Operateur o_added = osI.addOperateur(o_add);

		assertEquals(o_add.getNom(), o_added.getNom());
		assertEquals(o_add.getPrenom(), o_added.getPrenom());
		assertEquals(o_add.getPassword(), o_added.getPassword());
		verify(or).save(o_add);
	}

	@Test
	public void RetrieveOperateurById() {

		Mockito.when(or.findById(Mockito.anyLong())).thenReturn(Optional.of(o));
		Operateur o_get = osI.retrieveOperateur((long) 7);
		assertNotNull(o_get);
		verify(or).findById(Mockito.anyLong());
	}

	@Test
	public void RetrieveAll() {
		List<Operateur> operateurs = new ArrayList<>();
		operateurs.add(new Operateur());

		when(or.findAll()).thenReturn(operateurs);

		List<Operateur> expected = osI.retrieveAllOperateurs();

		assertEquals(expected, operateurs);
		verify(or).findAll();
	}

	@Test
	public void DeleteOperateur_ifFound() {
		Operateur o_delete = new Operateur();
		o_delete.setNom("salma delete");
		o_delete.setIdOperateur(1L);

		when(or.findById(o_delete.getIdOperateur())).thenReturn(Optional.of(o_delete));

		osI.deleteOperateur(o_delete.getIdOperateur());
		verify(or).deleteById(o_delete.getIdOperateur());
	}

	@Test
	public void DeleteException_ifnotFound() {
		try {
			Operateur o_delete = new Operateur();
			o_delete.setIdOperateur(2L);
			o_delete.setNom("salouma");

			when(or.findById(anyLong())).thenReturn(Optional.ofNullable(null));
			osI.deleteOperateur(o_delete.getIdOperateur());
		} catch (Exception e) {
			String expectedMessage = "entity with id";
			String actualMessage = e.getMessage();

			assertTrue(actualMessage.contains(expectedMessage));
		}
	}

	@Test
	public void EditOperateur_ifFound() {
		Operateur o_edit = new Operateur();
		o_edit.setIdOperateur(3L);
		o_edit.setNom("salma edit");

		Operateur new_o_edit = new Operateur();
		new_o_edit.setNom("new salma edit");

		when(or.findById(o_edit.getIdOperateur())).thenReturn(Optional.of(o_edit));
		o_edit = osI.updateOperateur(new_o_edit);

		verify(or).save(o_edit);
	}

	@Test
	public void EditException_ifnotFound() {
		try {
			Operateur o_edit = new Operateur();
			o_edit.setIdOperateur(4L);
			o_edit.setNom("salma edit");

			Operateur new_o_edit = new Operateur();
			new_o_edit.setIdOperateur(5L);
			new_o_edit.setNom("new salma edit");

			when(or.findById(anyLong())).thenReturn(Optional.ofNullable(null));
			osI.updateOperateur(new_o_edit);

		} catch (Exception e) {
			String expectedMessage = "entity with id";
			String actualMessage = e.getMessage();

			assertTrue(actualMessage.contains(expectedMessage));
		}
	}
}