package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Paiment;
import ma.emsi.edu.model.Panier;
import ma.emsi.edu.repository.PanierRepository;
@Service
@Transactional
public class PanierServiceImpl implements PanierService {
private PanierRepository panierRepository;
public PanierServiceImpl(PanierRepository panierRepository) {
	this.panierRepository=panierRepository;
	
	
}
	@Override
	public void ajouter(Panier panier) {
		// TODO Auto-generated method stub
		panierRepository.save(panier);
	}

	@Override
	public void modifier(Panier panier,Long id) {
		// TODO Auto-generated method stub
		Panier panier2 = panierRepository.getById(id);
		if(panier2!=null) {
			panier2.setClient(panier.getClient());
			panier2.setPlanification(panier.getPlanification());
			
			panierRepository.save(panier2);
		}
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		panierRepository.deleteById(id);
		
	}

	@Override
	public Panier getPanier(Long id) {
		// TODO Auto-generated method stub
		return panierRepository.findById(id).get();
	}

	@Override
	public List<Panier> liste() {
		// TODO Auto-generated method stub
		return panierRepository.findAll();
	}
	@Override
	public List<Panier> getPlanificationByClient(Long id ) {
		// TODO Auto-generated method stub
		return panierRepository.getPlanificationByClient(id);
	}
	@Override
	public List<Panier> checkIfDejaExist(Long id, Long id1) {
		// TODO Auto-generated method stub
		return panierRepository.checkIfDejaExist(id, id1);
	}
	@Override
	public Long GetPlanificationByRes(Long id) {
		// TODO Auto-generated method stub
		return panierRepository.GetPlanificationByRes(id);
	}


}
