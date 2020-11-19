package EstructurasDeDatos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Colections {

		//Lista de elementos que no tiene orden y puede haber elementos repetidos
			public Colections(){

		//Lista de elementos que no tiene orden y puede haber elementos repetidos
			ArrayList<Integer> a = new ArrayList<>();
			a.add(new Integer(3)); //Añade al final
			Integer i2 = new Integer(34);
			a.add(i2);
			a.set(0, new Integer(3)); //Especificamos la posición

		//Lista de elementos que no se repitan (set: TreeSet, HashSet)
			/*TreeSet -->
			- Rapido
			- No permite elementos iguales
			- SÍ se puede ordenar alfabeticamente!!
			- No se puede acceder por indice, pero si se puede recorrer (for - each)
			*/

			/*HashSet -->
			- Rapido
			- No permite elementos iguales
			- NO se puede ordenar alfabeticamente!!
			- No se puede acceder por indice, pero si se puede recorrer (for - each)
				 */

		//DEBEMOS OVERRIDE EQUALS Y HASHCODE

		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(new Integer(4));
		ts.add(new Integer(1));

		HashSet<Integer> hs = new HashSet<>();
		hs.add(new Integer(4));
		hs.add(new Integer(1));


		//Lista de elementos identificados por una clave (map: TreeMap, HashMap) TODO
            //TreeMap -->
            //HashMap -->
			//DEBEMOS OVERRIDE EQUALS Y HASHCODE

		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.put("tres", new Integer(3));
		tm.put("tres", new Integer(4)); //Se sobreescribe el valor 3
		tm.put("cuatro", new Integer(15));

   }

}
