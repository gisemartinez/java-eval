package nvnt.pedidos;

public class BumexMemCachedProxy {

	/*
	 * Utilizo una clase proxy para no ensuciar la implementacion principal con casteos
	 *  
	 * */
	public static void set(Integer key, Pedido value) throws CacheException{
		BumexMemcached.INSTANCE.set(key.toString(), value);
	}
	
	public static Pedido get(Integer key) throws CacheException {
		Object elem = BumexMemcached.INSTANCE.get(key.toString());
		
		Pedido pedido;
		
		 if (elem != null && (elem instanceof Pedido)){
			 pedido = (Pedido) elem;
		 } else {
			 pedido = null;
		 }
		 return pedido;
	}

	public static void delete(Integer key) throws CacheException{
		BumexMemcached.INSTANCE.delete(key.toString());
	}
}
