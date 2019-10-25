package ar.com.ada.api.billeteravirtual.entities;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Billetera
 */
@Entity
@Table(name = "billetera")
public class Billetera {

    @Id
    @Column(name = "billetera_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billeteraId;

    public Billetera(){
    }

    public Billetera(int billeteraId){
        this.billeteraId = billeteraId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "billetera", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    @JsonIgnore
    private Persona persona;

    
    public int getBilleteraId() {
        return billeteraId;
    }

    public void setBilleteraId(int billeteraId) {
        this.billeteraId = billeteraId;
    }

    public Cuenta getCuenta(int index){
        return getCuentas().get(index);
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Persona getPersona() {
        return persona;
    }

	public void setPersona(Persona persona) {
    }

    public void agregarCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
        cuenta.setBilletera(this);
    }

    public void agregarPlata(BigDecimal plata,String moneda, String concepto, String detalle) {
        this.buscarCuenta(moneda).agregarPlata(persona.getUsuario().getUsuarioId(), concepto, plata, detalle);
    
    }

    public void descontarPlata(BigDecimal plata,String moneda, String concepto, String detalle) {
        this.buscarCuenta(moneda).descontarPlata(persona.getUsuario().getUsuarioId(), concepto, plata, detalle);
    
    }

    public void transferencia (Billetera aBilletera,BigDecimal plata,String moneda, String concepto, String detalle){
        this.descontarPlata(plata, moneda, concepto, detalle);
        aBilletera.agregarPlata(plata, moneda, concepto, detalle);
    }


    private Cuenta buscarCuenta (String moneda){

        for (Cuenta c : this.cuentas) {
            if (moneda.equals(c.getMoneda())) {
                return c;
            }
        }
        return null;
    }

    public BigDecimal consultarSaldoCuentaUnica()
    {
        return this.cuentas.get(0).getSaldo();
    }

}