//============================================================================
// Name        : Fibonacci.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
unsigned parejas (unsigned n){
	unsigned res;
	if (n<=2){
		res = 1;
	}else{
		res=parejas(n-1)+parejas(n-2);
	}
	return res;
}
int main() {
	unsigned n;
	unsigned res;
	cout << "Programa para saber el numero de parejas que tendr�s al cabo de x meses. \n";
	cout << "Introduce el n�mero de meses: ";
	cin >> n;
	res=parejas(n);
	cout << "Al mes "<<n<< " hay " <<res<< " parejas." <<endl;
	return 0;
}
