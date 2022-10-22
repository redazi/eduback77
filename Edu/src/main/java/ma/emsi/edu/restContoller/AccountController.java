package ma.emsi.edu.restContoller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ma.emsi.edu.auth.AuthenticationResponse;
import ma.emsi.edu.auth.LoginRequest;
import ma.emsi.edu.model.Client;
import ma.emsi.edu.model.Role;
import ma.emsi.edu.model.Utilisateur;
import ma.emsi.edu.register.MessageResponse;
import ma.emsi.edu.register.SignupRequest;
import ma.emsi.edu.repository.RoleRepository;
import ma.emsi.edu.repository.UtilisateurRepository;
import ma.emsi.edu.security.JWTUtils;
import ma.emsi.edu.service.ClientService;
import ma.emsi.edu.service.UtilisateurService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	
	@Autowired
	private AuthenticationManager authenticationManager ;
	
	@Autowired
	UtilisateurService utilisateurService ;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UtilisateurRepository repository ;
	
	@Autowired
	ClientService clientService ;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JWTUtils jwt ;
	@PostMapping("/authenticate")
	
	public ResponseEntity<?> authenticate( @RequestBody LoginRequest request){
		System.out.println("print" + request);
	 authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		 UserDetails userDetails = utilisateurService.loadUserByUsername(request.getUsername());
		Utilisateur user = repository.findByUserName(request.getUsername());
		final String jw = jwt.generateToken(userDetails);
		AuthenticationResponse authenticationResponse = new AuthenticationResponse(jw , userDetails.getUsername() , user.getRoles().get(0).getNom(),user.getId());
		System.out.println(request.getUsername());
		System.out.println(authenticationResponse.getAccessToken());
		return ResponseEntity.ok(authenticationResponse);
		
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		if (repository.findByUserName(signUpRequest.getUsername())!=null) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Invalid: cet nom d'utilisateur exist deja!"));
		}

		if (repository.findByEmail(signUpRequest.getEmail())!=null) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Invalid: cet email exist deja!"));
		}
	
		
		Role rclient = roleRepo.findById((long) 2).get();
		List<Role> roles = new ArrayList<Role>();
		roles.add(rclient);
		// Create new user's account
		
		Client user = new Client(signUpRequest.getUsername(), 
				          encoder.encode(signUpRequest.getPassword()),
				          signUpRequest.getNom() ,
				          signUpRequest.getPrenom() ,
				          signUpRequest.getAge(),
							 signUpRequest.getEmail(),
							 signUpRequest.getCin(),
							 true,
							 false,
							 roles
							);

	
		

	

		
		clientService.ajouter(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
