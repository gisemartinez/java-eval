package nvnt.pedidos;
/*
 * La manera de implementar un singleton, según Joshua Bloch en Effective Java
 */
public enum BumexMemcached {
	CACHE;
	public void set(String key, Object value){
		System.out.println(key+":"+value);
	}
	 public Object get(String key){
		 return "Object"+key;
	 }
	 public  void delete(String key){
		 System.out.println("Deleted:"+key);
	 }
}
