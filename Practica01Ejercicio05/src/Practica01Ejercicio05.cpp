//============================================================================
// Name        : Practica1Ejercicio5.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
char a,b,c,d;
int e,f,g,h;
int main() {
	cout <<"Programa para codificar 4 letras introducidas por teclado:\n";
	cout <<"Introduce las cuatro letras: ";
	cin.get(a);
	cin.get(b);
	cin.get(c);
	cin.get(d);
	e=a+1;
	f=b+1;
	g=c+1;
	h=d+1;
	a=e;
	b=f;
	c=g;
	d=h;
	cout << "Las letras codificadas son: ";
	cout << a;
	cout << b;
	cout << c;
	cout << d << endl; //
	return 0;
}
