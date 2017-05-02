//============================================================================
// Name        : pruebamia.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

void leerdatos(unsigned x, unsigned y){
	//do{
	cout << "Introduce un límite inferior: ";
	cin >> x;
	cout << "Introduce un límite superior: ";
	cin >> y;
	//}while((x>=y)||(x<0));
}
unsigned sumadivisores(unsigned x){
	unsigned res=0;
	for(unsigned i=1;i<x;i++){
		if(x%i==0){
			res=res+i;
		}
	}
	return res;
}
bool perfecto(unsigned n){
	return (sumadivisores(n)== n);
}
int main() {
	unsigned n1,n2;
	cout << "Programa que te dice los números perfectos entre un rango de números. \n";
	leerdatos(n1,n2);
	cout << n1 << n2;

}

