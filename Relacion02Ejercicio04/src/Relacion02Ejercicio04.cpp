//============================================================================
// Name        : Relacion02Ejercicio04.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
int n_digitos ( int n){
	int resto = n;
	int i = 1;
	while ( resto > 9) {
		++i;
		resto /= 10;
	}
	return i;
	}
int digito ( int n, int i){
	int resto = n;
	for (int j = 0; ( resto > 0)&&(j < i); ++j) {
		resto /= 10;
	}
	return resto % 10;
}
void imprimir_suma_digitos (int n){
	int nd = n_digitos (n);
	for (int i = 0; i < nd / 2; ++i) {
		int di = digito (n, i);
		int df = digito (n, nd-i-1);
		cout << di << " + " << df << " = " << (di+df) << ", ";
	}
	if (nd %2 != 0) {
		cout << digito (n, nd / 2);
	}
	cout << endl ;
}

int main (){
	cout << "Programa que te suma los dígitos de un numero, primero con final. \n";
	cout << "Introduzca número : ";
	int num;
	cin >> num ;
	imprimir_suma_digitos ( num );
}
