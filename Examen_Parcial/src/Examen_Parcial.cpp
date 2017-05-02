//============================================================================
// Name        : Examen_Parcial.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

void leerDatos(unsigned& x,unsigned& y, unsigned& z){
	do{
		cout << "Introduce el limite inferior: ";
		cin >> x;
		cout << "Introduce el limite superior: ";
		cin >> y;
	}while(y<x);

	cout << "Introduce el valor de k: ";
	cin >> z;
}

unsigned sumaDivisores(unsigned x){
	unsigned total=0,cont=1;

	while(cont<x){
		if(x%cont==0){
			total=total+cont;
		}
	cont ++;
	}
	return total;
}

int main(){
	unsigned inf,sup,k,cont=0;
	leerDatos(inf,sup,k);
	cout << "Los numeros perfectos que hay entre " << inf << " y " << sup << " son:"<<endl;
	while(inf<=sup && k>cont){
		if(inf==sumaDivisores(inf)){
			cout << " " << inf << endl;
			cont ++;
		}
		inf ++;
	}
	if(cont<k){
		cout << "El rango establecido no tiene " << k << " numeros perfectos";
	}
	return 0;
}
