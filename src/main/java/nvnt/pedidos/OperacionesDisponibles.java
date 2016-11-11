package nvnt.pedidos;

import org.apache.log4j.Logger;

//TODO: Mejorar el orden de try-catch
public class OperacionesDisponibles {

	public static final Logger LOGGER = Logger
			.getLogger(OperacionesDisponibles.class);

	private PedidosDAO pedidosDAO;

	public OperacionesDisponibles(PedidosDAO dao) {
		this.pedidosDAO = dao;
	}

	/*
	 * Crear pedidos solo agrega a la base de datos, no a la cache
	 */
	public void crearPedidos(Pedido pedido) throws DBException {
		try {
			pedidosDAO.insertOrUpdate(pedido);
		} catch (DBException e) {
			LOGGER.error(e);
			throw e;
		}

	}
	

	public void modificarPedidos(Pedido pedido) throws DBException,
			CacheException {
		try {
			BumexMemCachedProxy.set(pedido.getId(), pedido);
		} catch (CacheException e) {
			// cache desactualizada
			LOGGER.error(e);
		}
		try {
			pedidosDAO.insertOrUpdate(pedido);
		} catch (DBException e) {
			LOGGER.error(e);
			throw e;
		}

	}

	public Pedido buscarPedidosPorId(Integer id) throws DBException {
		Pedido pedido = null;

		try {
			pedido = BumexMemCachedProxy.get(id);
		} catch (CacheException e) {
			LOGGER.debug(e);
			try {
				pedido = pedidosDAO.select(id);
			} catch (DBException dbException) {
				throw dbException;
			}
		}
		return pedido;
	}

	public void borrarPedidos(Pedido pedido) throws DBException {
		try {
			BumexMemCachedProxy.delete(pedido.getId());
		} catch (CacheException e) {
			LOGGER.debug(e);
			
			try {
				pedidosDAO.delete(pedido);
			} catch (DBException dbException) {
				throw dbException;
			}
		}
	}
}
