//============================================================================
// Name        : Practica06Ejercicio02.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX = 50;
typedef unsigned TEstaturas[MAX];

void leerEstaturas(TEstaturas& a, unsigned max){
	cout << "Introduce los alturas de los alumnos en cm: "<<endl;
		for(unsigned i=0;i<max;i++){
			cout << "Alumno numero "<<i+1<<": ";
			cin >> a[i];
		}
}

unsigned media(const TEstaturas& a,unsigned max){
	unsigned altura=0;
	for(unsigned i=0;i<max;i++){
		altura=altura+a[i];
		}
	return altura;
}
int main() {
	unsigned altura;
	unsigned max;
	TEstaturas a;
	cout << "Introduce el numero de alumnos de la clase: ";
	cin >> max;
	if((max>0)&&(max<=50)){
	leerEstaturas(a,max);
	altura=media(a,max)/max;
	cout<< "La media de altura de los alumnos es: " <<altura<<"cm";
	}else{
		cout << "Introduce un número entre 1 y 50.";
	}
}
