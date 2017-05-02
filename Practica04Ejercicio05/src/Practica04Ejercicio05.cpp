//============================================================================
// Name        : Practica04Ejercicio05.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
void esc_caracter ( int n, char simb ){
	for (int i = 0; i < n; ++i) {
		cout << simb ;
	}
}
void esc_ascendente ( int a, int b){
	assert (a <= b);
	for (int i = a; i <= b; ++i) {
		cout << (i %10);
	}
}
void esc_descendente ( int a, int b){
	for (int i = a; i >= b; --i) {
		cout << (i %10);
	}
}
void esc_fila ( int f, int nf){
	assert (f <= nf );
	esc_caracter (nf-f, ' ');
	esc_ascendente (f, 2*f- 1);
	esc_descendente (2*f-2, f);
	cout << endl ;
}
void esc_triangulo (int nf){
	for (int f = 1; f <= nf; ++f) {
		esc_fila (f, nf );
	}
}

int main() {
	cout << "Programa que te genera un triángulo según el número de filas. \n";
	cout << "Introduzca numero de filas : ";
	int n_filas ;
	cin >> n_filas ;
	esc_triangulo ( n_filas );
}
