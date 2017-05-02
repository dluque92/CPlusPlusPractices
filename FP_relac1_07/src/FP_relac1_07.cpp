//============================================================================
// Name        : FP_relac1_07.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool pertenecex = false;
	bool pertenecey = false;
	unsigned x,y;
	cout << "Programa para saber si los números 'x' e 'y' no son mayores que 10. \n";
	cout << "Introduce un número 'x': ";
	cin >> x;
	cout << "Introduce un número 'y': ";
	cin >> y;
	for(unsigned i=1;i<=10;i++){
		if (i==x){
			pertenecex = true;
		}
	}
	for(unsigned i=1;i<=10;i++){
			if (i==y){
				pertenecey = true;
			}
	}
	if ((pertenecex==1)&&(pertenecey==1)){
		cout << "Los números "<<x<<" y "<<y<<" no son mayores que 10. \n";
	}else if((pertenecex==0)&&(pertenecey==1)){
		cout << "El numero "<<x<<" es mayor que 10 y "<<y<<" no es mayor que 10. \n";
	}else if((pertenecex==1)&&(pertenecey==0)){
		cout << "El numero "<<x<<" no es mayor que 10 y "<<y<<" es mayor que 10. \n";
	}else{
		cout << "Los números "<<x<<" y "<<y<<" son mayores que 10. \n";
	}
}
