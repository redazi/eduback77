package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Formation;
import ma.emsi.edu.model.Matiere;
import ma.emsi.edu.repository.MatiereRepository;
@Service
@Transactional
public class MatiereServiceImpl implements MatiereService {

	private MatiereRepository matiereRepository;
	public MatiereServiceImpl(MatiereRepository matiereRepository) {
		this.matiereRepository=matiereRepository;
	}
	@Override
	public void ajouter(Matiere matiere) {
		// TODO Auto-generated method stub
		matiereRepository.save(matiere);
	}
	@Override
	public void modifier(Matiere matiere,Long id) {
		// TODO Auto-generated method stub
		Matiere matiere2 = matiereRepository.getById(id);
		if(matiere2!=null) {
			matiere2.setLibelle(matiere.getLibelle());
			matiere2.setNom(matiere.getNom());
			matiere2.setDescription(matiere.getDescription());
			
			
			matiereRepository.save(matiere2);
		}
	}
	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		matiereRepository.deleteById(id);
		
	}
	@Override
	public Matiere getMatiere(Long id) {
		// TODO Auto-generated method stub
		return matiereRepository.findById(id).get();
	}
	@Override
	public List<Matiere> liste() {
		// TODO Auto-generated method stub
		return matiereRepository.findAll();
	}
	@Override
	public List<Matiere> getDispoMatiere(Long formation_id) {
		// TODO Auto-generated method stub
		return matiereRepository.getDispoMatiere(formation_id);
	}
	@Override
	public List<Matiere> getMforF(Long formation_id) {
		return matiereRepository.getMforF(formation_id);
	}
	
}
