package nvnt.pedidos;

public class BumexMemCachedProxy {

	/*
	 * Utilizo una clase proxy para no ensuciar la implementacion principal.
	 * 
	 * No es recomendable NUNCA la utilizacion de instanceof ni casteos, mas que en casos extremos
	 * como éste, donde es necesario utilizar un caché ya implementado.
	 * 
	 * */
	public static void set(Integer key, Pedido value) throws CacheException{
		BumexMemcached.CACHE.set(key.toString(), value);
	}
	
	public static Pedido get(Integer key) throws CacheException {
		Object elem = BumexMemcached.CACHE.get(key.toString());
		
		Pedido pedido;
		
		 if (elem != null && (elem instanceof Pedido)){
			 pedido = (Pedido) elem;
		 } else {
			 pedido = null;
		 }
		 return pedido;
	}

	public static void delete(Integer key) throws CacheException{
		BumexMemcached.CACHE.delete(key.toString());
	}
}
