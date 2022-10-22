package ma.emsi.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Creneau;
import ma.emsi.edu.model.Formation;
import ma.emsi.edu.repository.FormationRepository;
@Service
@Transactional
public class FormationServiceImpl implements FormationService {
	@Autowired
   FormationRepository formationRepository; 
	@Override
	public void ajouter(Formation formation) {
		// TODO Auto-generated method stub
		formationRepository.save(formation);
		
	}

	@Override
	public void modifier(Formation formation,Long id) {
		// TODO Auto-generated method stub
		Formation formation2 = formationRepository.getById(id);
		if(formation2!=null) {
			
			formation2.setNom(formation.getNom());
			formation2.setDescription(formation.getDescription());
			
formationRepository.save(formation2);
		}
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		formationRepository.deleteById(id);
	}

	@Override
	public Formation getFormation(Long id) {
		// TODO Auto-generated method stub
		return formationRepository.findById(id).get();
	}

	@Override
	public List<Formation> liste() {
		// TODO Auto-generated method stub
		return formationRepository.findAll();
	}
	

}
