//============================================================================
// Name        : Practica05Ejercicio03.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

unsigned producto(unsigned x, unsigned y){
	unsigned resultado;
	resultado=x*y;
	return resultado;
}

int main() {
	unsigned x;
	unsigned y;
	cout << "Introduce un producto x * y"<<endl;
	cout << "Introduce x: ";
	cin >> x;
	cout << "Introduce n: ";
	cin >> y;
	cout << "El resultado de "<<x<<" x "<<y<<" es: "<<producto(x,y);
}
