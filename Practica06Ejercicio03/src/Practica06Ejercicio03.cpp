//============================================================================
// Name        : Practica06Ejercicio03.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const int MAX = 1000;
typedef int TArray[MAX];


void leerNumeros(TArray& a){
	cout << "Introduce una sucesión de numeros"<<endl;
	int i=0;
	do{
		i++;
		do{
			cin >> a[i];
			}while(a[i]>10);
	}while(a[i]>=0);
	}

int contar(const TArray& a){
	int cont=0;
	int i=0;
	while(a[i]>=0){
	cont++;
	i++;
	};
	return cont;
}
void cuantosNum(const TArray& a, int max){
	int cont;
	for(int i=0;i<10;i++){
		cont=0;
		for(int j=0;j<max;j++){
			if(a[j]==i){
			cont++;
			}
		}
		cout << i <<":" <<cont <<"  ";
	}
}
int main() {
	int max;
	TArray a;
	leerNumeros(a);
	max=contar(a);
	cuantosNum(a,max);

}
