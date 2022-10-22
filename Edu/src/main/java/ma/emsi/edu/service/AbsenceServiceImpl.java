package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ma.emsi.edu.model.Absence;
import ma.emsi.edu.repository.AbsenceRepository;
@Service
@Transactional
public class AbsenceServiceImpl implements AbsenceService {
	 private AbsenceRepository absenceRepository;

	public AbsenceServiceImpl(AbsenceRepository absenceRepository) {
	        this.absenceRepository = absenceRepository;
	    }
	@Override
	public void ajouter(Absence absence) {
       absenceRepository.save(absence);

		
	}

	@Override
	public void modifier(Absence absence,Long id) {
		// TODO Auto-generated method stub
		Absence absence1 = absenceRepository.getById(id);
        if (absence1 != null){
        	absence1.setReservation(absence.getReservation());
        	absence1.setUtilisateur(absence.getUtilisateur());
        	absence1.setAbsence(absence.isAbsence());
        	absenceRepository.save(absence1);
        }
		
		
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		absenceRepository.deleteById(id);
		
	}

	@Override
	public Absence getAbsence(Long id) {
		// TODO Auto-generated method stub
		return absenceRepository.getById(id);
	}

	@Override
	public List<Absence> liste() {
		// TODO Auto-generated method stub
		return absenceRepository.findAll();
	}

}
