//============================================================================
// Name        : Practica01Ejercicio12.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
int main()
{
int a=6, b=14;
//int auxiliar;
cout << "a vale " << a << " y b vale " << b << endl;
// ¿Qué hacen estas tres sentencias?
a = a + b;
b = a - b;
a = a - b;
cout << "a vale " << a << " y b vale " << b << endl;
return 0;
}

/*
Este programa hace que con la diferencia de los dos, hagan que cambie de sitio.
En el primer caso, hace que a valga el valor de los dos, en este caso 20.
En el segundo caso hace que b, valga 20 que es el nuevo valor de a menos el antiguo
valor de b que es 14.
En el tercer caso, hace que a, valga el nuevo valor de a que es 20 menos el nuevo valor
de b, que en este caso es 6 y hace que a tenga el valor de 14.
*/
