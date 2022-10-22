package ma.emsi.edu.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ma.emsi.edu.model.Revue;
import ma.emsi.edu.repository.RevueRepository;

@Service
@Transactional
public class RevueServiceImpl implements RevueService{
	
	
	@Autowired
	RevueRepository revueRepository;
	@Override
	public void ajouter(Revue revue) {
		// TODO Auto-generated method stub
		
		  
		 
		revue.setDate(new Date());
		revueRepository.save(revue);
	}

	@Override
	public void modifier(Revue revue, Long id) {
		// TODO Auto-generated method stub
		Revue revue2 = revueRepository.getById(id);
		if(revue2!=null) {
			revue2.setMatiere(revue.getMatiere());
			revue2.setUtilisateur(revue.getUtilisateur());
			
			revue2.setCommentaire(revue.getCommentaire()+" (modified)");
			
			revueRepository.save(revue2);
		}
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		revueRepository.deleteById(id);
		
	}

	@Override
	public Revue getRevue(Long id) {
		// TODO Auto-generated method stub
		return revueRepository.findById(id).get();
	}

	@Override
	public List<Revue> liste() {
		// TODO Auto-generated method stub
		return revueRepository.findAll();
	}

	@Override
	public List<Revue> getListByMatiere(Long id) {	
		return revueRepository.getListByMatiere(id);
	}

}
