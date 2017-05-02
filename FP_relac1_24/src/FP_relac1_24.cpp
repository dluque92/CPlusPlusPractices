//============================================================================
// Name        : FP_relac1_24.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	unsigned may,men,n,num;
		float media;
		cout << "Introduzca lista de numeros: ";
		cin >> n;
		may = n;
		men = n;
		media = n;
		for(unsigned i=1;i<n;i++){
			cin>>num;
			if(num>may){
				may=num;
			}else if(num<men){
				men=num;
			}
			media = media + num;
		}
		cout << "El mayor es: " << may << endl;
		cout << "El menor es: " << men << endl;
		cout << "La media aritmetica es: " << media/n << endl;
}
