//============================================================================
// Name        : Practica05Ejercicio05.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

bool esprimo (unsigned num, unsigned divisor){
	if ((num==divisor)||(num==1)){
		return true;
	}else{
		if ((num%divisor)!=0){
			return (esprimo(num, divisor+1));
		}else{
			return false;
		}
	}
}

int main (){
	unsigned numero, divisor=2;
	cout<<"Introduzca n�mero:"<<endl;
	cin>>numero;
	if (esprimo(numero, divisor)){
		cout<<"Es primo"<<endl;
	}else{
		cout<<"No es primo"<<endl;
	}
	return 0;

}
