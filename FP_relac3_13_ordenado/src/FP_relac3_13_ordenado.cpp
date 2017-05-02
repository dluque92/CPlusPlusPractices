//============================================================================
// Name        : FP_relac3_13_ordenado.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX=1000;
typedef int TNumeros[MAX];

struct Vector {
TNumeros numeros; // array de enteros
unsigned tam; // numero de celdas ocupadas
};

void LeerVector(Vector& v){
	cout << "Introduce el tamaño de tu Vector:";
	do{
	cin >> v.tam;
	}while((v.tam>MAX)||(v.tam<=0));
	cout << "Introduce una sucesión de números:";
	for(unsigned i=0; i<v.tam;i++){
		cin >> v.numeros[i];
	}
}

void ordenar(Vector& v){
	if(v.tam<MAX){
		for(unsigned i=0;i<v.tam;i++){
			for(unsigned j=i+1;j<v.tam;j++){
				if(v.numeros[i]<v.numeros[j]){
					unsigned tem;
					tem=v.numeros[i];
					v.numeros[i]=v.numeros[j];
					v.numeros[j]=tem;
				}
			}
		}
	}
}

void borrar(Vector& v, int k){
	for (unsigned i=0; i<v.tam; i++){
		if(v.numeros[i]==k){
			if(i==v.tam-1){
				v.tam--;
				break;
			}else{
				v.numeros[i]=v.numeros[v.tam-1];
				v.tam--;
				break;
			}
		}
	}
}

void insertar(Vector& v, int k){
	if(v.tam<MAX){
		v.numeros[v.tam]=k;
		v.tam++;
	}
}

void mostrar(const Vector& v){
	for(unsigned i=0; i<v.tam; i++){
			cout << v.numeros[i] << " ";
	}
	cout <<endl;
}

int main() {
	Vector v;
	int k;
	int opcion;
	LeerVector(v);
	ordenar(v);
	do{
	cout << "Introduzca la opción que quiere realizar:"<<endl;
	cout << "1. Borrar un número."<<endl;
	cout << "2. Insertar un número."<<endl;
	cout << "3. Terminar."<<endl;
	cin >> opcion;
	switch(opcion){
	case 1:
		cout << "Escriba el número que quiere borrar: ";
		cin >> k;
		borrar(v,k);
		ordenar(v);
		mostrar(v);
		break;
	case 2:
		cout << "Escriba el número que quiera insertar: ";
		cin >> k;
		insertar(v,k);
		ordenar(v);
		mostrar(v);
		break;
	}
	}while(opcion!=3);
	cout << "Hasta Luego.";
}
