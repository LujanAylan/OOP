package ar.com.ada.api.billeteravirtual.models.request;

import ar.com.ada.api.billeteravirtual.entities.Persona;

/**
 * RegistrationRequest
 */
public class RegistrationRequest {

    public String fullName;
    public String email;
    public String dni;
    public int edad;
    public String password;
    public Persona persona;
    
}