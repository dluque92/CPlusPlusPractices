//============================================================================
// Name        : Examen_Parcial_2.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX = 10;
typedef int TArray[MAX];

struct TLista {
	TArray elementos;
	unsigned numElem;
};

void leer(TLista& lista) {
	int num;
	do {
		cout << "Cuantos numeros desea introducir en la lista (maximo " << MAX << "):";
		cin >> lista.numElem;
	} while (lista.numElem > MAX);
	cout << "Introduzca " << lista.numElem << " numeros: ";
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

void eliminarTodasApariciones(int elem, TLista& lista, unsigned pos){
	for(unsigned i=pos;i<lista.numElem;i++){
		if(elem==lista.elementos[i]){
			for(unsigned j=i;j<lista.numElem;j++){
				lista.elementos[j]=lista.elementos[j+1];
			}
			lista.numElem--;
		}
		do{
			for(unsigned j=i;j<lista.numElem;j++){
				lista.elementos[j]=lista.elementos[j+1];
			}
			lista.numElem--;
		}while(elem==lista.elementos[i]);
	}
}
void criba(unsigned x, TLista& lista){
	unsigned cont=1;
	for(unsigned i=0; i<lista.numElem; i++){
		for(unsigned j=1; j<lista.numElem; j++){
			if (lista.elementos[i]==lista.elementos[j]){
				cont++;
			}
		}
		if (cont!=x){
			for(unsigned k=i;k<lista.numElem; k++){
				lista.elementos[k]=lista.elementos[k+1];
			}
			lista.numElem--;
		}
	}
	lista.numElem--;
}

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
