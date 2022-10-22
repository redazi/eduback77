package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Salle;
import ma.emsi.edu.repository.SalleRepository;
@Service
@Transactional
public class SalleServiceImpl implements SalleService {
private SalleRepository salleRepository;
public SalleServiceImpl(SalleRepository salleRepository) {
	this.salleRepository=salleRepository;
	
}
	@Override
	public void ajouter(Salle salle) {
		// TODO Auto-generated method stub
		salleRepository.save(salle);
		
		
	}

	@Override
	public void modifier(Salle salle, Long id) {
		// TODO Auto-generated method stub
		Salle salle2 = salleRepository.getById(id);
		if(salle2!=null) {
			salle2.setCode(salle.getCode());
			salle2.setNbrPlace(salle.getNbrPlace());
			salle2.setType(salle.getType());
			salleRepository.save(salle2);
		}
		
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		salleRepository.deleteById(id);
	}

	@Override
	public Salle getSalle(Long id) {
		// TODO Auto-generated method stub
		return salleRepository.findById(id).get();
	}

	@Override
	public List<Salle> liste() {
		// TODO Auto-generated method stub
		return salleRepository.findAll();
	}

	
}
