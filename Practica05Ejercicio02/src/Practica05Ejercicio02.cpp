//============================================================================
// Name        : Practica05Ejercicio02.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

unsigned potencia(unsigned n, unsigned x){
	unsigned resultado=0;
	if(n==0){
		resultado=1;
	}else{
		resultado=x;
		for(unsigned i=1; i<n; i++){
				resultado=resultado*x;
			}
	}
	return resultado;
}

int main() {
	unsigned n;
	unsigned x;
	cout << "Introduce una potencia x ^ n."<<endl;
	cout << "Introduce x: ";
	cin >> x;
	cout << "Introduce n: ";
	cin >> n;
	cout << "El resultado de "<<x<<" elevado a "<<n<<" es: "<<potencia(n,x);
	return 0;
}
