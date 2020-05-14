
public class Pruebas {

	// Pruebas ------------------------------------------------------------
	public static void main(String[] args) {
		Pruebas pruebas = new Pruebas();
		pruebas.ejecutar();
	}

	private void ejecutar() {
		// Alumnos ------------------------------------------------------------
		Alumno alicia = new Alumno("Alicia Blazquez Martin", 5622);
		Alumno pedro = new Alumno("Pedro Jimenez del Pozo", 8510);
		Alumno adriana = new Alumno("Adriana Torres Pardo", 2345);
		Alumno felipe = new Alumno("Felipe Garcia Gomez", 1253);
		Alumno eduardo = new Alumno("Eduardo Parra Martin", 8765);
		Alumno diego = new Alumno("Diego Perez Gonzalez", 8135);
		Alumno mar = new Alumno("Mar Hernando Lopez", 8217);

		// Arbol --------------------------------------------------------------
		Arbol arbol = new Arbol();
		arbol.insertar(alicia);
		arbol.insertar(pedro);
		arbol.insertar(adriana);
		arbol.insertar(felipe);
		arbol.insertar(eduardo);
		arbol.insertar(diego);
		arbol.insertar(mar);
		System.out.println("----------------- Arbol ----------------");
		System.out.println("Hay " + arbol.getNumElementos() + " alumnos:");
		arbol.mostrar();
		System.out.println("----------------------------------------");

		System.out.println();
		System.out.print("El alumno con menor clave es: ");
		this.mostrarAlumno(arbol.getMenorElemento());

		this.mostrarMenores(arbol, 5623);
		this.mostrarMenores(arbol, 8511);
		this.mostrarMenores(arbol, 2346);
		this.mostrarMenores(arbol, 1254);
		this.mostrarMenores(arbol, 8766);
		this.mostrarMenores(arbol, 8136);
		this.mostrarMenores(arbol, 8218);
		this.mostrarMenores(arbol, 1253);
	}

	private void mostrarAlumno(Alumno alumno) {
		if (alumno == null) {
			System.out.println("NINGUNO");
		} else {
			alumno.mostrar();
		}
	}

	private void mostrarMenores(Arbol arbol, int clave) {
		System.out.println();
		System.out.println("Hay " + arbol.getNumMenores(clave)
				+ " alumnos con clave menor que " + clave);
		System.out.print("El mayor de los menores que " + clave + " es: ");
		this.mostrarAlumno(arbol.getMenorElementoClave(clave));	
	}
}
