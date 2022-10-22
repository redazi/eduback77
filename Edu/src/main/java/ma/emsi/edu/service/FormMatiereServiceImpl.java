package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.FormMatiere;
import ma.emsi.edu.repository.FormMatiereRepository;

@Service
@Transactional
public class FormMatiereServiceImpl implements FormMatiereService {

	private FormMatiereRepository formMatiereRepository;

	public FormMatiereServiceImpl(FormMatiereRepository formMatiereRepository) {
		this.formMatiereRepository = formMatiereRepository;
	}

	@Override
	public void ajouter(FormMatiere formMatiere) {
		// TODO Auto-generated method stub
		formMatiereRepository.save(formMatiere);
	}

	@Override
	public void modifier(FormMatiere formMatiere, Long id) {
		// TODO Auto-generated method stub
		FormMatiere formMatiere1 = formMatiereRepository.getById(id);
		if (formMatiere1 != null) {
			formMatiere1.setFormation(formMatiere.getFormation());
			formMatiere1.setMatiere(formMatiere.getMatiere());

			formMatiereRepository.save(formMatiere1);
		}
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		formMatiereRepository.deleteById(id);

	}

	@Override
	public FormMatiere getFormMatiere(Long id) {
		// TODO Auto-generated method stub
		return formMatiereRepository.findById(id).get();
	}

	@Override
	public List<FormMatiere> liste() {
		// TODO Auto-generated method stub
		return formMatiereRepository.findAll();
	}

	@Override
	public FormMatiere getfm(Long idf , Long idm) {
		return formMatiereRepository.getfm(idf , idm);
	}

}
