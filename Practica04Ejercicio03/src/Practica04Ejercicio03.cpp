//============================================================================
// Name        : Practica04Ejercicio03.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

void leerDatos(unsigned& n, unsigned& m){
	do{
		cout << "Introduzca n (n < m) : ";
	 	cin >> n;
		cout << "Introduzca m (n < m) : ";
	 	cin >> m;
	}while (m < n);
	}

unsigned SumaDivisores(unsigned num){
	unsigned suma = 1;
	for(unsigned i= 2; i < num; i++){
		if(num%i == 0){
			suma = suma + i;
		}
	}
	return suma;
}
bool sonAmigos(unsigned a, unsigned b){
	bool son = false;
	if((SumaDivisores(a) == b) && (SumaDivisores(b)== a)){
		son = true;
	}
	return son;
}
void imprimirParejas(unsigned n, unsigned m){
	for(unsigned i = n; i <= m-1; i++){
		for(unsigned j = i+1; j <= m; j++){
			if(sonAmigos(i, j)){
				cout << i << " y "<< j;
				cout << " son amigos."<< endl;
				cout<<" Suma de divisores de "<<i<<" es "<<SumaDivisores(i)<<" = "<<j<<endl;
				cout<<" Suma de divisores de "<<j<<" es "<<SumaDivisores(j)<<" = "<<j<<endl;
			}
		}
	}
}
int main() {
	unsigned n, m;
	cout << "Programa que muestra en la pantalla todas las parejas de números amigos que existan en el intervalo determinado por n y m." << endl; // prints !!!Hello World!!!
	leerDatos(n, m);
	imprimirParejas(n,m);
	return 0;
}
