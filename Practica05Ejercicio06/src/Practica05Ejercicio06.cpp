//============================================================================
// Name        : Practica05Ejercicio06.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
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
	cout<<"El número en binario es:";
	decimalABinario(num);
	return 0;
}
