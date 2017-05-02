//============================================================================
// Name        : Practica06Ejercicio01.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX = 10;
typedef unsigned TVector[MAX];

void leerVector(TVector& a){
	cout << "Introduce los valores del Vector: "<<endl;
	for(unsigned i=0;i<MAX;i++){
		cout << "Dato numero "<<i+1<<": ";
		cin >> a[i];
	}
}

unsigned numeroMAX(const TVector& a){
	unsigned max=0;
	for(unsigned i=0;i<MAX;i++){
		if((a[i])>max){
			max=a[i];
		}
	}
	return max;

}
int main() {
	unsigned max;
	TVector a;
	leerVector(a);
	max=numeroMAX(a);
	cout<< "El número maximo de los que ha introducido es: " <<max;
	return 0;
}
