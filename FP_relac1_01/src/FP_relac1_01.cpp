//============================================================================
// Name        : FP_relac1_01.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool par;
	unsigned num;
	cout << "Introduce un n�mero para saber si es par: ";
	cin >> num;
	if (num%2==0){
		par = true;
	}else{
		par = false;
	}
	if (par==1){
		cout << "El n�mero "<<num<< " es par.";
	}else{
		cout << "El n�mero "<<num<< " no es par.";
	}
}


