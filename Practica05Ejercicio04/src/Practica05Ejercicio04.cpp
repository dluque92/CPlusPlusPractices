//============================================================================
// Name        : Practica05Ejercicio04.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

void inverso (unsigned n){
	if (n!=0){
		cout<<n%10;
		inverso(n/10);
	}
}

int main(){
	unsigned num;
	cout<<"Introduzca el numero:"<<endl;
	cin>>num;
	cout<<"Los digitos del n�mero en orden invesrso son:";
	inverso(num);
}
