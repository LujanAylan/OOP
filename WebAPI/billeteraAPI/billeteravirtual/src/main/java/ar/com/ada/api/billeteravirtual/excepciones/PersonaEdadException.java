package ar.com.ada.api.billeteravirtual.excepciones;

import ar.com.ada.api.billeteravirtual.entities.Persona;

/**
 * PersonaEdadException
 */
public class PersonaEdadException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private Persona persona;

    public PersonaEdadException(Persona p, String mensaje) {
        super(p.getNombre()+":"+ mensaje);
        this.persona = p;
    }
    
}