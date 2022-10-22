package ma.emsi.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ma.emsi.edu.model.Plannification;
import ma.emsi.edu.repository.PlannificationRepository;
@Service
@Transactional
public class PlannificationServiceImpl implements PlannificationService{
	
	@Autowired
	PlannificationRepository plannificationRepository ;
	@Override
	public void ajouter(Plannification plannification) {
		// TODO Auto-generated method stub
		plannificationRepository.save(plannification);
	}

	@Override
	public void modifier(Plannification plannification,Long id) {
		// TODO Auto-generated method stub
		Plannification plannification2 = plannificationRepository.getById(id);
		if(plannification2!=null) {
			plannification2.setDescription(plannification.getDescription());
			
			
			plannificationRepository.save(plannification2);
		}
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		plannificationRepository.deleteById(id);
		
	}

	@Override
	public Plannification getPlannification(Long id) {
		// TODO Auto-generated method stub
		return plannificationRepository.findById(id).get();
	}

	@Override
	public List<Plannification> liste() {
		// TODO Auto-generated method stub
		return plannificationRepository.findAll();
	}

}
