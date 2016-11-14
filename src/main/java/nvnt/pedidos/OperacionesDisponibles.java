package nvnt.pedidos;

import org.apache.log4j.Logger;


public class OperacionesDisponibles {

	public static final Logger LOGGER = Logger
			.getLogger(OperacionesDisponibles.class);

	private PedidosDAO pedidosDAO;

	public OperacionesDisponibles(PedidosDAO dao) {
		this.pedidosDAO = dao;
	}

	/*Cuando estoy creando, me interesa más si falla la bd que la cache*/
	public void crearPedidos(Pedido pedido) throws DBException {
		try {
			pedidosDAO.insertOrUpdate(pedido);
		} catch (DBException e) {
			throw e;
		}
		try {
			BumexMemCachedProxy.set(pedido.getId(), pedido);
		} catch (CacheException e) {
			// cache desactualizada
			LOGGER.error(e);
		}

	}
	
	/*Cuando estoy modificando, me interesa que la cache esté actualizada
	 * y guarde la nueva version, por eso elimino la actual.*/
	public void modificarPedidos(Pedido pedido) throws DBException,
			CacheException {
		try {
			BumexMemCachedProxy.delete(pedido.getId());
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
		try {
			BumexMemCachedProxy.set(pedido.getId(),pedido);
		} catch (CacheException e) {
			// cache desactualizada
			LOGGER.error(e);
		}

	}
	/*confio en que tengo datos actualizados en la cache*/
	public Pedido buscarPedidosPorId(Integer id) throws DBException {
		Pedido pedido = null;

		try {
			pedido = BumexMemCachedProxy.get(id);
		} catch (CacheException e) {
			LOGGER.debug(e);
		}
		if(pedido == null){
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
		}
		try {
			pedidosDAO.delete(pedido);
		} catch (DBException dbException) {
			throw dbException;
		}
	}
}
