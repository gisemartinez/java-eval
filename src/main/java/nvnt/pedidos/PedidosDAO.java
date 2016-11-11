package nvnt.pedidos;

public class PedidosDAO {
	/*
	 * Inserta un nuevo pedido en la base de datos o modifica un pedido
	 * existente (en cado de crear uno nuevo, el pedido pasado como parámetro se
	 * completa con el nuevo id).
	 */
	public void insertOrUpdate(Pedido pedido) throws DBException {

	}

	/* Elimina el pedido que corresponde al id recibido. */
	void delete(Pedido pedido) throws DBException {

	}

	/* Busca un pedido por id. */
	public Pedido select(Integer idPedido) throws DBException {
		// TODO
		return null;
	}
}
