//============================================================================
// Name        : FP_relac1_06.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool pertenecex = false;
	bool pertenecey = false;
	unsigned x,y;
	cout << "Programa para saber si el n�mero 'x' pertenece al rango {3,4,6,8,9} \n";
	cout << "o si el numero 'y' pertenece al rango {6,7,8,3}. \n";
	cout << "Introduce un n�mero 'x': ";
	cin >> x;
	cout << "Introduce un n�mero 'y': ";
	cin >> y;
	if(((x>=3)&&(x<=4))||(x==6)||((x>=8)&&(x<=9))){
			pertenecex = true;
	}
	if(((y>=6)&&(y<=8))||(y==3)){
			pertenecey = true;
	}
	if (pertenecex==1){
		cout << "El n�mero "<<x<<" pertenece al rango de x. \n";
	}else{
		cout << "El n�mero "<<x<<" no pertenece al rango de x. \n";
	}
	if (pertenecey==1){
		cout << "El n�mero "<<y<<" pertenece al rango de y.";
	}else{
		cout << "El n�mero "<<y<<" no pertenece al rango de y.";
	}
}
