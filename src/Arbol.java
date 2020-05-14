
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
            return getNumElementos(nodo.getIzquierdo()) + getNumElementos(nodo.getDerecho()) + 1; //sumar 1 por cada llamada a la funcion con un nodo != null
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
    // TODO 3.5: Devuelve el elemento con la mayor clave y menor que una clave
    // dada de forma RECURSIVA
	/*public Alumno getMenorElementoClave(int clave) {
		Alumno aux = new Alumno("aux",0);
		NodoArbol record = new NodoArbol(aux);
		Alumno resul = getMenorElementoClave(raiz, clave, record);
		if(resul != aux) {
			return resul;
		}else{
			return null;
		}
	}

	private Alumno getMenorElementoClave(NodoArbol nodo, int clave, NodoArbol record) {
		if(nodo != null) {
			//update record node
			if (nodo.getDato().getMatricula() < clave && nodo.getDato().getMatricula() > record.getDato().getMatricula()) {
				record = nodo;
			}
			//if right child(bigger) exist, and his key number is lower than "clave" call method with it
			if (nodo.getDerecho() != null && nodo.getDerecho().getDato().getMatricula() < clave) {
				return getMenorElementoClave(nodo.getDerecho(), clave, record);
			} else if (nodo.getIzquierdo() != null) {
				return getMenorElementoClave(nodo.getIzquierdo(), clave, record);
			} else {
				return record.getDato();
			}
		}else{
			return null;
		}
	}*/

    public Alumno getMenorElementoClave(int clave) {
        return getMenorElementoClave(clave, raiz);
    }

    private Alumno getMenorElementoClave(int clave, NodoArbol nodo) {

        if (nodo == null) return null;
        if (nodo.getDato().getMatricula() == clave) return nodo.getDato();


        // si el nodo en el que estamos es mayor que la clave hay que bajar por la izquierda
        else if (nodo.getIzquierdo() != null && nodo.getDato().getMatricula() < clave) {
            Alumno aux = getMenorElementoClave(clave, nodo.getDerecho());
            if(aux == null) {
                return nodo.getDato();
            }else{
                return aux;
            }
        }

        else if(nodo.getDato().getMatricula() > clave) {
            return getMenorElementoClave(clave, nodo.getIzquierdo());
        }

        return null; //si no hemos entrado en ningun caso
    }

}
