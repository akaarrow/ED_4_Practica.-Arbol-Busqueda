
public class Arbol {

    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    // Muestra los elementos del arbol binario en orden central ---------------
    public void mostrar() {
        this.mostrar(raiz, "  ");
    }

    private void mostrar(NodoArbol nodo, String espacios) {
        if (nodo != null) {
            this.mostrar(nodo.getIzquierdo(), espacios + "    ");
            System.out.print(espacios);
            nodo.getDato().mostrar();
            this.mostrar(nodo.getDerecho(), espacios + "    ");
        }
    }

    // Inserta un elemento con una cierta clave -------------------------------
    public void insertar(Alumno dato) {
        raiz = this.insertar(raiz, dato);
    }

    private NodoArbol insertar(NodoArbol nodo, Alumno dato) {
        if (nodo != null) {
            if (nodo.getDato().getMatricula() < dato.getMatricula()) {
                nodo.setDerecho(this.insertar(nodo.getDerecho(), dato));
            } else if (nodo.getDato().getMatricula() > dato.getMatricula()) {
                nodo.setIzquierdo(this.insertar(nodo.getIzquierdo(), dato));
            } else {
                System.out.println("la clave ya existe");
            }
        } else {
            nodo = new NodoArbol(dato);
        }
        return nodo;
    }

    // 3.2------------------------------------------------------------------------
    public int getNumElementos() {
        return getNumElementos(raiz);
    }

    private int getNumElementos(NodoArbol nodo) {
        if (nodo != null) {
            //sumar 1 por cada llamada a la funcion con un nodo != null
            return getNumElementos(nodo.getIzquierdo()) + getNumElementos(nodo.getDerecho()) + 1;
        }
        return 0;
    }

    // 3.3------------------------------------------------------------------------
    public int getNumMenores(int clave) {
        return getNumMenores(this.raiz, clave);
    }

    private int getNumMenores(NodoArbol nodo, int clave) {
        if (nodo != null) {
            if (nodo.getDato().getMatricula() < clave) {
                return 1 + getNumMenores(nodo.getIzquierdo(), clave) + getNumMenores(nodo.getDerecho(), clave);
            } else {
                return getNumMenores(nodo.getIzquierdo(), clave);
            }
        }
        return 0;
    }

    // 3.4------------------------------------------------------------------------
    public Alumno getMenorElemento() {
        return getMenorElemento(raiz);
    }

    //el menor elemento del abb se encontrara a la izquierda del arbol ya que no tendra nada a su izquierda
    private Alumno getMenorElemento(NodoArbol nodo) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                return getMenorElemento(nodo.getIzquierdo());
            } else {
                return nodo.getDato();
            }
        } else {
            return null;
        }
    }

    // 3.5------------------------------------------------------------------------
    public Alumno getMenorElementoClave(int clave) {
        return getMenorElementoClave(raiz, clave);
    }

    private Alumno getMenorElementoClave(NodoArbol nodo, int clave) {

        if (nodo != null) {
            if (nodo.getDato().getMatricula() < clave) {
                Alumno aux = getMenorElementoClave(nodo.getDerecho(), clave);
                if (aux != null) { // si el resultado de la funcion en el nodo de la derecha es valido devolvemos ese
                    return aux;
                } else { // si es null devolvemos este ya que a la izquierda seran todos menores
                    return nodo.getDato();
                }
            } else { // si el dato es mayor buscamos por la izquierda
                return getMenorElementoClave(nodo.getIzquierdo(), clave);
            }
        } else {
            return null;
        }

    }

}
