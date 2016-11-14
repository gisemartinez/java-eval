# java-eval

##Punto 1 
La clase OperacionesDisponibles.java es la que implementa todos los métodos. 
Hay una sola clase que suma contenido, llamada BumexMemCachedProxy y, justamente, es un Proxy de BumexMemCached. 
La misma aporta cuestiones de casteo, para poder tener la implementación principal un poco más ordenada. 

##Punto 2 
Por el lado de base de datos, supongo que se trata de una base relacional, ya que habla de tablas. También supongo que tiene un index en el campo id. En el caso de ser muy grande, quisiera evitar el problema de mucho tiempo invertido en búsqueda, por lo que haría que la tabla tenga un index secundario en el campo nombre. Éste campo no es único, pero podría ser utilizado para la optimización que hace el motor de base de datos. Por otra parte, pensaría en la posibilidad de migrar a una base de datos no relacional adecuada. Las mismas son más flexibles cuando se trata de volúmenes muy grande de datos.

Por el lado de Java, vería diferentes formas de implementar la caché y crearía tests que prueben a todas las implementaciones por igual, en conceptos como disponibilidad o consistencia de datos en arquitecturas concurrentes. 

##Punto 3 
El archivo index.html es el que tiene toda la parte de frontend. No hace pedidos Ajax, los datos esan mockeados. 
Utilicé Jquery, bootstrap y un estilo css material. 
