//============================================================================
// Name        : pruebamia.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

void leerdatos(unsigned x, unsigned y){
	//do{
	cout << "Introduce un l�mite inferior: ";
	cin >> x;
	cout << "Introduce un l�mite superior: ";
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
	cout << "Programa que te dice los n�meros perfectos entre un rango de n�meros. \n";
	leerdatos(n1,n2);
	cout << n1 << n2;

}

