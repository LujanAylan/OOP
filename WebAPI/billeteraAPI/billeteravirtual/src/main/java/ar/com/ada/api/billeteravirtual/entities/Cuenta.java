package ar.com.ada.api.billeteravirtual.entities;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Cuenta
 */
@Entity
@Table(name = "cuenta")
public class Cuenta {
    
    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int cuentaId;

    protected String moneda;
    protected BigDecimal saldo;
    @Column(name = "saldo_disponible")
    protected BigDecimal saldoDisponible;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;

    @JsonIgnore
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();

    public Cuenta(){
    }

    public Cuenta(Billetera b, String moneda) {

        this.moneda = moneda;
        b.getCuentas().add(this);

    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    /**
     * @param billetera the usuario to set
     */

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
    }

    /**
     * @return the usuario
     */

    public Billetera getBilletera() {
        return billetera;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    /*public void agregarMovimiento(Movimiento movimiento){
		movimiento.setCuenta(this);
		this.movimientos.add(movimiento);
        this.setSaldo(this.getSaldo() + movimiento.getImporte());
        this.setSaldoDisponible(this.getSaldo());
    }*/
    
    public Usuario getUsuario(){
        Usuario u = this.getBilletera().getPersona().getUsuario();
        return u;   
    }

    public void agregarPlata(int usuarioDe, String concepto, BigDecimal importe, String detalle) {
        Movimiento m = new Movimiento();

        m.setCuenta(this);
        m.setTipoOperacion("Ingreso");
        m.setImporte(importe);
        m.setConceptoOperacion(concepto);
        m.setDetalle(detalle);
        m.setFecha(new Date());
        m.setDeUsuario(usuarioDe);
        m.setaUsuario(usuarioDe);
        m.setCuentaDestino(this.cuentaId);
        m.setCuentaOrigen(this.cuentaId);

        this.movimientos.add(m);
    }

    public void descontarPlata(int usuarioOr, String concepto, BigDecimal importe, String detalle) {
        Movimiento m = new Movimiento();

        m.setCuenta(this);
        m.setTipoOperacion("Salida");
        m.setImporte(importe.negate());
        m.setConceptoOperacion(concepto);
        m.setFecha(new Date());
        m.setDeUsuario(usuarioOr);
        m.setaUsuario(usuarioOr);
        m.setCuentaOrigen(this.cuentaId);
        m.setCuentaDestino(this.cuentaId);

    }
}