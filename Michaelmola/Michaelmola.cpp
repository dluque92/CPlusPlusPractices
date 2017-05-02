/*
 *  Alumno: Michael Delgado Beramendi
 *  Titulación: 1º Ingeniería Informática
 *  Grupo: Grupo A, Subgrupo A
 *  Código PC usado: PC322
 */

#include <iostream>
using namespace std;

const unsigned MAX = 10;

typedef int TArray[MAX];

struct TLista {
	TArray elementos;
	unsigned numElem;
};

void leer(TLista& lista);
void escribir(const TLista& lista);
void eliminarTodasApariciones (int elem, TLista& lista, unsigned pos);
void criba (unsigned x, TLista& lista);

// Función Principal
int main() {
	TLista lista;
	unsigned x, elem, pos;

	cout << "Prueba del procedimiento eliminarTodasApariciones\n\n";

	leer(lista);

	cout << "Introduzca el elemento a eliminar: ";
	cin >> elem;

	cout << "Introduzca la posicion a partir de la cual eliminar: ";
	cin >> pos;

	eliminarTodasApariciones(elem,lista,pos);

	escribir(lista);


	cout << "\n\nPrueba del procedimiento criba\n\n";

	leer(lista);

	cout << "Introduzca el valor de x: ";
	cin >> x;

 	criba(x,lista);

	escribir(lista);

	return 0;
}

// Procedimientos y Funciones
void leer(TLista& lista) {
	int num;

	do {
		cout << "Cuantos números desea introducir en la lista (máximo " << MAX << "):";
		cin >> lista.numElem;
	} while (lista.numElem > MAX);
	cout << "Introduzca " << lista.numElem << " números: ";
	for (unsigned cont = 0; cont < lista.numElem; cont++) {
		cin >> num;
		lista.elementos[cont] = num;
	}

}

void escribir(const TLista& lista) {
	cout << "El contenido de la lista es: ";
	for (unsigned i = 0; i < lista.numElem; i++) {
		cout << lista.elementos[i] << " ";
	}
	cout << endl;
}

void eliminarTodasApariciones (int elem, TLista& lista, unsigned pos) {
	for (unsigned i=lista.numElem-1; i>=pos; i--) {
		if (lista.elementos[i]==elem) {
			for (unsigned j=i; j<lista.numElem-1; j++) {
				lista.elementos[j]=lista.elementos[j+1];
			}
			lista.numElem--;
		}
	}
}

void criba (unsigned x, TLista& lista) {
	unsigned cont;
	for (unsigned i=0; i<lista.numElem; i++) {
		cont=0;
		for (unsigned j=0; j<lista.numElem; j++) {
			if (lista.elementos[i]==lista.elementos[j]) {
				cont++;
			}
		}
		if (cont!=x) {
			eliminarTodasApariciones(lista.elementos[i],lista,0);
		}
	}
}
