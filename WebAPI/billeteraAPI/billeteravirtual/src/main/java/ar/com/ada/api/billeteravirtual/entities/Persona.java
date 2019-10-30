package ar.com.ada.api.billeteravirtual.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.ada.api.billeteravirtual.excepciones.PersonaEdadException;

/**
 * Persona
 */
@Entity
@Table(name = "persona")
// El campo nombre indica el nombre de la funcion que debe tener en el Repository
@NamedQuery(name = "Persona.findAllByNombreContiene", query = "FROM Persona WHERE nombre like CONCAT('%', ?1,'%')")
//Este es un caso de named query igual al anterior, solo con 2 parametros
@NamedQuery(name = "Persona.findAllByNombreAndDNI", query = "SELECT p FROM Persona p WHERE p.nombre = ?1 AND p.dni = ?2")
public class Persona {

    @Id
    @Column(name = "persona_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pesonaId;
    private String nombre;
    private String dni;
    private int edad;
    private String email;

    @JsonIgnore
    @OneToOne( mappedBy = "persona", cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private Billetera billetera;

    public Persona(String nombre, String dni, int edad, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.email = email;
    }

    public Persona() {
    }

    public Integer getPesonaId() {
        return pesonaId;
    }

    public void setPesonaId(Integer pesonaId) {
        this.pesonaId = pesonaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws PersonaEdadException {
        if(edad < 18)
        {
            //no se ejecuta nada mas despues del throw
            throw new PersonaEdadException(this, "Ocurrio un error con la edad");
        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", edad=" + edad + ", nombre=" + nombre + "]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.usuario.setPersona(this); 
    }
    
    /**
     * @return usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
        this.billetera.setPersona(this);
    }

    public Billetera getBilletera() {
        return billetera;
    }

}