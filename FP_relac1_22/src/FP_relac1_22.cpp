//============================================================================
// Name        : FP_relac1_22.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	char c;
	bool text=false;
	cout << "Programa que determina si la cadena 'abc' aparece en una sucesi�n de caracteres. \n";
	cout << "Introduce la sucesi�n: ";
	cin >> c;
	do{
		if(c=='a'){
			cin >> c;
			if(c=='b'){
				cin >> c;
				if(c=='c'){
					text=true;
					cin >> c;
				}
			}
		}else{
			cin >> c;
		}
	}while(c!='.');
	if(text==1){
		cout << "La cadena 'abc' se encuentra en la sucesi�n de caracteres.";
	}else{
		cout << "La cadena 'abc' no se encuentra en la sucesi�n de caracteres.";
	}
}
