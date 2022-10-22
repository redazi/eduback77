package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Paiment;
import ma.emsi.edu.repository.PaiementRepository;
@Service
@Transactional
public class PaiementServiceImpl implements PaiementService {
private PaiementRepository paiementRepository;
	@Override
	public void ajouter(Paiment paiment) {
		// TODO Auto-generated method stub
		paiementRepository.save(paiment);
		
	}

	@Override
	public void modifier(Paiment paiment, Long id) {
		// TODO Auto-generated method stub
		Paiment paiment2 = paiementRepository.getById(id);
		if(paiment2!=null) {
			paiment2.setDuree(paiment.getDuree());
			paiment2.setPanier(paiment.getPanier());
			
			
			paiementRepository.save(paiment2);
		}
		
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		paiementRepository.deleteById(id);
	}

	@Override
	public Paiment getPaiment(Long id) {
		// TODO Auto-generated method stub
		return paiementRepository.findById(id).get();
	}

	@Override
	public List<Paiment> liste() {
		// TODO Auto-generated method stub
		return paiementRepository.findAll();
	}

}
