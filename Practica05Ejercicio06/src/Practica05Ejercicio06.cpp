//============================================================================
// Name        : Practica05Ejercicio06.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

void decimalABinario (unsigned n){
	if (n>=2){
		decimalABinario(n/2);
		cout<<n%2;
	}else{
		cout<<n;
	}
}

int main(){
	unsigned num;
	cout<<"Introduzca el numero:"<<endl;
	cin>>num;
	cout<<"El n�mero en binario es:";
	decimalABinario(num);
	return 0;
}
