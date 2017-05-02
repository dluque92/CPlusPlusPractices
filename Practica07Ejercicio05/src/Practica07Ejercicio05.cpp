//============================================================================
// Name        : Practica07Ejercicio05.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

const unsigned MAX = 10;
typedef unsigned TVector[MAX];

void LeerVector(TVector& a){
	cout << "Programa que te lee una sucesión de 10 números y te dice"<<endl;
	cout << "cuantas veces se repiten los números y en que posición están."<<endl;
	cout << "Introdude la sucesión de 10 números: ";
	for(unsigned i=0; i<MAX; i++){
		cin >> a[i];
	}
}

unsigned contarNumero(const TVector& a, unsigned num){
	unsigned contador=0;
	for(unsigned i= 0; i < MAX; i++){
		if(a[i]== num){
			contador++;
			}
		}
	return contador;
}

void buscarPosiciones(const TVector& a, unsigned num, unsigned contador){
	unsigned i = 0;
	unsigned c= 0;
	if(contador == 1){
		cout << " vez, en la posición ";
	}else{
		cout << " veces, en posiciones ";
	}
	while(i < MAX  && c <= contador){
		if(a[i]== num){
			cout << i +1 << " ";
			c++;
		}
		i++;
	}
	cout <<"" << endl;
}

unsigned buscarMayor(const TVector& a){
	unsigned mayor = a[0];
	for(unsigned i= 1; i < MAX; i++){
		if(a[i] > mayor){
			mayor = a[i];
		}
	}
	return mayor;
}

void eliminarUsado(TVector& a, unsigned mayor){
	for(unsigned i= 0; i < MAX; i++){
		if(a[i] == mayor){
			a[i] = 0;
		}
	}
}

int main() {
	unsigned mayor, contador;
	TVector a;
	LeerVector(a);
	mayor = buscarMayor(a);
	while(mayor != 0){
		cout << mayor << " aparece ";
		contador = contarNumero(a, mayor);
		cout << contador;
		buscarPosiciones(a, mayor, contador);
		eliminarUsado(a, mayor);
		mayor = buscarMayor(a);
	 }
}
