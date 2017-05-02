//============================================================================
// Name        : FP_relac2_09.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

unsigned mcd(unsigned P, unsigned Q){
	unsigned res=0;
	if(P==Q){
		res = P;
	}else if(P>Q){
		res = mcd(P-Q,Q);
	}else if(P<Q){
		res = mcd(P,Q-P);
	}
	return res;
}
int main() {
	unsigned p,q,resultado;
	cout << "Programa para calcular el máximo común divisor. \n";
	cout << "Introduzca P: ";
	cin >> p;
	cout << "Introduzca Q: ";
	cin >> q;
	resultado = mcd(p,q);
	cout << "El mcd de " << p << " y " << q << " es: " << resultado << endl;
}
