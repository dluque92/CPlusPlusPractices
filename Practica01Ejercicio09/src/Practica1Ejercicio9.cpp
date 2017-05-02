//============================================================================
// Name        : Practica1Ejercicio9.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
int n1,n2,suma;
int main() {
	cout << "Programa para sumar dos numeros \n";
	cout << "Introduce el primer número ";
	cin >> n1;
	cout << "Introduce el segundo numero ";
	cin >> n2;
	suma=n1+n2;
	cout << "La suma es: " <<suma << endl;
	return 0;
}

/*
Escriba un programa que sólo declare variables de tipo int. El programa deberá leer
dos números desde el teclado; posteriormente los sumará y almacenará el resultado en
una variable; finalmente escribirá por pantalla el resultado de la suma. Ejecute el
programa con datos cualesquiera y verifique que funciona. Después ejecute dicho programa
tomando como datos de entrada 1 y 3000000000. ¿Por qué no funciona?

RESPUESTA:
Porque con los bits de datos no puedes dar valores mayores.
*/
