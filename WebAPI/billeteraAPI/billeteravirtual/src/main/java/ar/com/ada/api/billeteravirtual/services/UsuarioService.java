package ar.com.ada.api.billeteravirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.repo.UsuarioRepository;
import ar.com.ada.api.billeteravirtual.security.Crypto;
import ar.com.ada.api.billeteravirtual.entities.*;
import ar.com.ada.api.billeteravirtual.excepciones.PersonaEdadException;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    @Autowired
    PersonaService personaService;

    public Usuario buscarPorId(int id) {
        Optional<Usuario> u = repo.findById(id);

        if (u.isPresent())
            return u.get();
        return null;
    }

    public List<Usuario> getUsuarios() {
        return repo.findAll();
    }

    public Usuario crearUsuario(String nombre, String dni, int edad, String email, String password) 
    throws PersonaEdadException {

        Persona p = new Persona();
        p.setNombre(nombre);
        p.setDni(dni);
        p.setEdad(edad);
        p.setEmail(email);

        Usuario u = new Usuario();
        u.setUserName(p.getEmail());
        u.setUserEmail(p.getEmail());

        String passwordEnTextoClaro;
        String passwordEncriptada;

        passwordEnTextoClaro = password;
        passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUserName());

        u.setPassword(passwordEncriptada);
        p.setUsuario(u);

        Billetera billetera = new Billetera();

        Cuenta cuenta = new Cuenta();
        cuenta.setMoneda("ARS");
        billetera.agregarCuentas(cuenta);
        billetera.setPersona(p);

        personaService.save(p);

        return u;

    }

    public void save(Usuario usuario){
        repo.save(usuario);
    }
    
}