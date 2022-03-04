import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class test {

	public static void main(String[] args) {
		
		List<String> name = new ArrayList<>();
				
		name.add("Pablo");
		name.add("Juan");
		name.add("Victor");		
		name.add("Kevin");
		
		name.forEach(System.out::println);
		
		name.forEach(na -> System.out.println(na));
		System.out.println("");
		//Ordenar por tamaño de caracteres
		name.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		System.out.println("\n");
		//Ordenar de manera alfabetica despues del ordenamiento po tamaño de caracteres
		name.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
		System.out.println("\n");
		//Ordenar de manera alfabetica
		name.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		System.out.println("\n");
		
		System.out.println(name.stream().count());
		
		System.out.println(name.stream().reduce("PLANETS:", (st1,st2) -> {
			if(st2.equals("Pablo")) {
				return st1 +st2;
			}
			return st1+","+st2;
		} ));
		//Array.stream(value).map()
		
		System.out.println("Planets2:"+name.stream().collect(Collectors.joining(",")));
		
		
		
		mapCollection();
	}	
		
	public static void mapCollection() {
		Map<Integer,String> my = new HashMap<Integer,String>();
		
		my.put(1, "Juan"); // Añade un elemento al Map
		my.put(2, "Pedro"); // Añade un elemento al Map
		my.put(3, "Kevin"); // Añade un elemento al Map
		my.put(4, "Jhon"); // Añade un elemento al Map
		
		my.size(); // Devuelve el numero de elementos del Map
		my.isEmpty(); // Devuelve true si no hay elementos en el Map y false si si los hay				
		my.remove(3); // Borra el par clave/valor de la clave que se le pasa como parámetro
		my.containsKey(4); // Devuelve true si en el map hay una clave que coincide con K
		my.containsValue("Pedro"); // Devuelve true si en el map hay un Valor que coincide con V
		my.values(); // Devuelve una "Collection" con los valores del Map
		
		my.get(2); // Devuelve el valor de la clave que se le pasa como parámetro o 'null' si la clave no existe
		System.out.println("\n"+my.get(3));
		System.out.println(my.containsValue("Pedro"));
		
		my.clear(); // Borra todos los componentes del Map
	}
		
	}
	
