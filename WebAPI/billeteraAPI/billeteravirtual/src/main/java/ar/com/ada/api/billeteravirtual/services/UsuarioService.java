package ar.com.ada.api.billeteravirtual.services;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.repo.UsuarioRepository;
import ar.com.ada.api.billeteravirtual.security.Crypto;
import ar.com.ada.api.billeteravirtual.sistema.comms.EmailService;
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

    @Autowired
    BilleteraService billeteraService;

    @Autowired
    EmailService emailService;

    public Usuario buscarPorId(int id) {
        Optional<Usuario> u = repo.findById(id);

        if (u.isPresent())
            return u.get();
        return null;
    }

    public List<Usuario> getUsuarios() {
        return repo.findAll();
    }

    public Usuario buscarPorEmail(String email) {
        return repo.findByUserEmail(email);
    }

    public Usuario buscarPorUsername(String username) {
        return repo.findByUserName(username);
    }

    public int crearUsuario(String nombre, String dni, int edad, String email, String password)
    throws PersonaEdadException {

        Persona p = new Persona();
        p.setNombre(nombre);
        p.setDni(dni);
        p.setEdad(edad);
        p.setEmail(email);

        Usuario u = new Usuario();
        u.setUsername(p.getEmail());
        u.setUserEmail(p.getEmail());

        String passwordEnTextoClaro;
        String passwordEncriptada;

        passwordEnTextoClaro = password;
        passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUsername());

        u.setPassword(passwordEncriptada);
        p.setUsuario(u);

        personaService.save(p);

        Billetera b = new Billetera();
        p.setBilletera(b);

        Cuenta cuenta = new Cuenta();
        cuenta.setMoneda("ARS");
        b.agregarCuenta(cuenta);

        billeteraService.save(b);

        b.agregarPlata(new BigDecimal(100), "ARS", "Regalo", "Te regalo 100 pesitos");

        emailService.SendEmail(u.getUserEmail(),"Bienvenido a la Billetera Virtual ADA!!!", 
        "Hola "+p.getNombre()+"\nBienvenido a este hermoso proyecto hecho por todas las alumnas de ADA Backend 8va Mañana\n"+
        "Ademas te regalamos 100 pesitos" );

        return u.getUsuarioId();
    }

    public void login(String username, String password) {
        Usuario u = repo.findByUserName(username);

        if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUsername()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }
    }

    public void save(Usuario usuario){
        repo.save(usuario);
    }
    
}