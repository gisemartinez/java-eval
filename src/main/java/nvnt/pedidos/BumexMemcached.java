package nvnt.pedidos;
/*
 * Supongo que al singleton se lo implementó como un Enum, 
 * y que tiene alguna política de optimización.
 */
public enum BumexMemcached {
	INSTANCE;
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
