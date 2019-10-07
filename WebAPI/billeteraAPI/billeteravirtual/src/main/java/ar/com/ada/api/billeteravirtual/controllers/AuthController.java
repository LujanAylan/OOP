package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.excepciones.PersonaEdadException;
import ar.com.ada.api.billeteravirtual.models.request.RegistrationRequest;
import ar.com.ada.api.billeteravirtual.models.response.RegistrationResponse;

/**
 * AuthController
 */
@RestController
public class AuthController {

    @PostMapping("auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req) throws PersonaEdadException {
        RegistrationResponse r = new RegistrationResponse();
        //aca creamos la persona y el usuario a traves del service.

        Persona persona = new Persona();
        persona.setEmail(req.email);
        persona.setNombre(req.fullName);
        persona.setDni(req.dni);
        persona.setEdad(req.edad);

        Usuario usuario = new Usuario();
        usuario.setPersona(req.persona);
        usuario.setPassword(req.password);

        Billetera billetera = new Billetera();
        billetera.setPersona(req.persona);

        r.isOk = true;
        r.message = "Te registraste con exitoooo";
        return r;
    }

}