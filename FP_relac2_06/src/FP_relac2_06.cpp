//============================================================================
// Name        : FP_relac2_06.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

bool esPrimo(unsigned num){
	bool loes = true ;
	unsigned i = 2;
	while((loes == true) && (i <=(num/2))){
		if(num != i){
			if(num%i == 0){
				loes = false;
			}
		}
		i++;
	}
	return loes;
}
bool goldbach(unsigned n){
	bool encontrado = false;
	unsigned cont = 2;
	while((cont<=n/2)&&(!encontrado)){
		encontrado = esPrimo(cont)&& esPrimo(n-cont);
		cont++;
	}
	return encontrado;
}
void leerDatos(unsigned& n, unsigned& m){
	do{
		cout << "Introduce un límite inferior y superior: \n";
		cout << "Introducir limite inferior: ";
		cin >> n;
		cout << "Introducir limite superior: ";
		cin >> m;
	}
	while((n>m)||(n<=2));
}
int main() {
	unsigned n,m,cont;
	cout << "Programa que ejecuta la conjetura de Goldbach. \n";
	leerDatos(n,m);
	if(n%2==0){
		cont=n;
	}else{
		cont=n+1;
	}
	while ((cont<=m)&&goldbach(cont)){
		cont=cont+2;
	}
	if (cont > m){
		cout << "Todos los pares del rango cumplen la conjetura.";
	}else{
		cout << "El par "<<cont<<" no cumple la conjetura.";
	}
	return 0;
}
