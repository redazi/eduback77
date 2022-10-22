package ma.emsi.edu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Absence;
import ma.emsi.edu.model.AbsenceInfo;
import ma.emsi.edu.model.Client;
import ma.emsi.edu.model.Reservation;
import ma.emsi.edu.repository.AbsenceInfoRepository;
import ma.emsi.edu.repository.AbsenceRepository;
@Service
@Transactional
public class AbsenceInfoServiceImpl  implements AbsenceInfoService {
	 private AbsenceInfoRepository absenceinfoRepository;

		public AbsenceInfoServiceImpl(AbsenceInfoRepository absenceinfoRepository) {
		        this.absenceinfoRepository = absenceinfoRepository;
		    }
		@Override
		public void ajouter(AbsenceInfo absenceinfo) {
	       absenceinfoRepository.save(absenceinfo);

			
		}

		@Override
		public void modifier(AbsenceInfo absenceinfo,Long id) {
			// TODO Auto-generated method stub
			AbsenceInfo absenceinfo1 = absenceinfoRepository.getById(id);
	        if (absenceinfo1 != null){
	        	absenceinfo1.setClient(absenceinfo.getClient());
	        	absenceinfo1.setReservation(absenceinfo.getReservation());
	        	absenceinfo1.setStatus(absenceinfo.getStatus());
	        	absenceinfo1.setAbsence(absenceinfo.isAbsence());

	        }
			
			
		}

		@Override
		public void supprimer(Long id) {
			// TODO Auto-generated method stub
			absenceinfoRepository.deleteById(id);
			
		}

		@Override
		public AbsenceInfo getAbsenceInfo(Long id) {
			// TODO Auto-generated method stub
			return absenceinfoRepository.getById(id);
		}

		@Override
		public List<AbsenceInfo> liste() {
			// TODO Auto-generated method stub
			return absenceinfoRepository.findAll();
		}
		@Override
		public List<Client> listeEtudiant(long idreservation) {
			// TODO Auto-generated method stub
	
			return absenceinfoRepository.clients(idreservation);
		}
		@Override
		public byte[] decompressBytes(byte[] data) {
			// TODO Auto-generated method stub
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
		
			
		@Override
		public byte[] compressBytes(byte[] data) {
			// TODO Auto-generated method stub
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

			return outputStream.toByteArray();
		}

		@Override
		public List<Reservation> listereservation(String nom) {
			// TODO Auto-generated method stub
			
			return absenceinfoRepository.reservationbyformateur(nom);
		}
		@Override
		public void updateabsence(boolean absence, String status, long id,long idreservation) {
			// TODO Auto-generated method stub
			absenceinfoRepository.updateabsence(absence, status, id,idreservation);			
		}
		@Override
		public boolean getStatusBuidclient(long id, long idreservation) {
			// TODO Auto-generated method stub
			return absenceinfoRepository.getStatusBuidclient(id, idreservation);
		}
	
		
		
		@Override
		public void updateabsencevalider(long id) {
		absenceinfoRepository.updateabsencevalider(id);
			
		}
		@Override
		public List<Reservation> reservationwithabsencevalide(String nom) {
			// TODO Auto-generated method stub
				return absenceinfoRepository.reservationwithabsencevalide(nom);

		}
		@Override
		public List<AbsenceInfo> absenceinfobyreservation(long id) {
			// TODO Auto-generated method stub
			return absenceinfoRepository.absenceinfobyreservation(id);
		}

}
