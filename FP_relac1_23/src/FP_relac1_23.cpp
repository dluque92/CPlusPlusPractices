//============================================================================
// Name        : FP_relac1_23.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

unsigned fibonacci (unsigned n){
	unsigned res;
	if (n<=2){
		res = 1;
	}else{
		res=fibonacci(n-1)+fibonacci(n-2);
	}
	return res;
}
int main() {
	unsigned n;
	unsigned res;
	cout << "Programa para calcular el n�mero en la Serie de Fibonacci. \n";
	cout << "Introduce el n�mero: ";
	cin >> n;
	res=fibonacci(n);
	cout << "En la posici�n "<<n<< " est� el numero " <<res<< ".";
	return 0;
}
