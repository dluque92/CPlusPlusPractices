//============================================================================
// Name        : Practica1Ejercicio9.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
int n1,n2,suma;
int main() {
	cout << "Programa para sumar dos numeros \n";
	cout << "Introduce el primer n�mero ";
	cin >> n1;
	cout << "Introduce el segundo numero ";
	cin >> n2;
	suma=n1+n2;
	cout << "La suma es: " <<suma << endl;
	return 0;
}

/*
Escriba un programa que s�lo declare variables de tipo int. El programa deber� leer
dos n�meros desde el teclado; posteriormente los sumar� y almacenar� el resultado en
una variable; finalmente escribir� por pantalla el resultado de la suma. Ejecute el
programa con datos cualesquiera y verifique que funciona. Despu�s ejecute dicho programa
tomando como datos de entrada 1 y 3000000000. �Por qu� no funciona?

RESPUESTA:
Porque con los bits de datos no puedes dar valores mayores.
*/
