//============================================================================
// Name        : FP_relac3_10.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
const unsigned MAX = 5;
typedef int TArray[MAX];


void LeerDatos(TArray& a){
	cout << "Programa que te devuelve los indices del array ordenado."<<endl;
	cout << "Introduzca los números del Array: ";
	for(unsigned i=0;i<MAX;i++){
		cin >> a[i];
	}
}

int mayor(const TArray& a){
	int m = a[0];
	for(unsigned i=1;i<MAX;i++){
		if(a[i]>m){
			m = a[i];
		}
	}
	return m;
}

int menor(const TArray& a){
	int m = a[0];
	for(unsigned i=0;i<MAX;i++){
		if(a[i]<m){
			m = a[i];
		}
	}
	return m;
}

void introPos(const TArray& a, TArray& b, unsigned& i,int n, unsigned& j){
	for(unsigned k=0;k<MAX;k++){
		if(a[k]==n){
			b[i]=k;
			i--;
			j++;
		}
	}
}

int generarSigNum(const TArray& a, int sup, int inf){
	for(unsigned i=0;i<MAX;i++){
		if((a[i]>=inf)&&(a[i]<sup)){
			inf = a[i];
		}
	}
	return inf;
}

void mostrar(const TArray& b){
	for(unsigned i=0;i<MAX;i++){
		cout << b[i] << " ";
	}
}

int main() {
	TArray a,b;
	unsigned i = MAX-1,j=0;
	int sup, inf;
	LeerDatos(a);
	sup = mayor(a);
	inf = menor(a);
	while(j<=MAX){
		introPos(a,b,i,sup,j);
		sup = generarSigNum(a,sup,inf);
	}
	mostrar(b);
}
