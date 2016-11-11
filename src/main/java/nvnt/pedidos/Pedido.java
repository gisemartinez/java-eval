package nvnt.pedidos;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class Pedido {
	@Id
	private Integer id;
	private String nombre;
	private BigDecimal monto;
	private BigDecimal descuento;

	public Integer getId() {
		return id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public BigDecimal getDescuento() {
		return descuento;
	}
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

}
