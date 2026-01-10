package med.vol.api.infra.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import static org.springframework.security.config.Elements.JWT;

@Service
public class TokenService {

    public String generarToken() {
        try {
            var algoritmo = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            String token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
        }
    }
}
