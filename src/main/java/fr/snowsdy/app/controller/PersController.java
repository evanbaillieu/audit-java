/*
package fr.snowsdy.app.controller;

import fr.snowsdy.app.entity.Personne;
import fr.snowsdy.app.jwt.JwtUtil;
import fr.snowsdy.app.payload.LoginRequest;
import fr.snowsdy.app.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Personne")
public class PersController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonneRepository personneRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok(new JwtResponse(jwt,
                personneDetails.getId(),
                personneDetails.getPersonne());
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (personneRepository.existsByPersonne(signUpRequest.getPersonne())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Personne is already taken!"));
        }

        }

        // Create new user's account
        Personne personne = new Personne(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()));


        personneRepository.save(personne);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
*/