package ma.emsi.edu.service;

import java.util.List;


import ma.emsi.edu.model.Panier;

public interface PanierService {
	
	void ajouter(Panier panier);

	void modifier(Panier panier,Long id);
	
	void supprimer(Long id);

	Panier getPanier(Long id);
	
	List<Panier> liste();

}
