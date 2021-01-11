package EstructurasDeDatos;

import java.util.*;

public class Colections implements Comparator<Object>{

	public Colections(){

		//ARRAYLIST
		//Lista de elementos que no tiene orden y puede haber elementos repetidos
		ArrayList<Integer> al = new ArrayList<>();
		al.add(new Integer(3)); //Añade al final
		Integer i2 = new Integer(34);
		al.add(i2);
		al.set(0, new Integer(3)); //Especificamos la posición

		for (int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		Iterator<Integer> it= al.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		for (Integer num: al) {
			System.out.println(num);
		}


		//TREESET Y HASHSET
		//Lista de elementos que no se repitan (set: TreeSet, HashSet). DEBEMOS OVERRIDE EQUALS, HASHCODE Y COMPARETO
			/*TreeSet -->
			- Rapido
			- No permite elementos iguales
			- Solo se puede ordenar alfabeticamente!!
			- No se puede acceder por indice, pero si se puede recorrer (for - each)
			- OBLIGATORIO IMPLEMENTAR COMPARABLE
			*/

			/*HashSet -->
			- Rapido
			- No permite elementos iguales
			- NO se puede ordenar!!
			- No se puede acceder por indice, pero si se puede recorrer (for - each)
			*/

		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(new Integer(4));
		ts.remove(4);

		HashSet<Integer> hs = new HashSet<>();
		hs.add(new Integer(4));
		hs.remove(4);

		//Igual para HashSet y TreeSet
		Iterator iter = hs.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		for (Integer h : hs) {
			System.out.println(h);
		}



		//TREEMAP Y HASHMAP
		//Lista de elementos identificados por una clave (map: TreeMap, HashMap). DEBEMOS HACER OVERRIDE EQUALS, HASHCODE Y COMPARETO
		/*TreeMap -->
		- Ordenados por clave
		- Si permite valores iguales, pero no claves
		- Si no se indica nada, el TreeMap se ordena SIEMPRE por clave
		 */

		/*HashMap -->
		- Si permite valores iguales, pero no claves
		- No se ordena por defecto
		 */

		TreeMap<String, Integer> tm = new TreeMap<>();
		HashMap<String, Integer> hm = new HashMap<>();
		//Mismos metodos (más o menos) para un TreeMap y un HashMap
		hm.put("tres", new Integer(4));
		hm.get("tres"); //Pasamos por parametro el Key y nos devuelve el value
		hm.containsKey("tres"); //Más eficiente que el get
		hm.remove("tres");

		//Igual para un HashMap y TreeMap
		for(Map.Entry<String,Integer> entry : tm.entrySet()) { //Iterador
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " => " + value);
		}
		for (Object value : tm.values()) { //Nos da solo los valores
			System.out.println("Value" + value);
		}
		for (Object key : tm.keySet()) { //Nos da solo las claves
			System.out.println("Key" + key);
		}


	}

	@Override
	public int compare(Object o1, Object o2) {
		return 0;
	}
}
