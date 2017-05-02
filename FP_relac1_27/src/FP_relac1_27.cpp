//============================================================================
// Name        : FP_relac1_27.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	unsigned n, mod, resta;
	bool sacar = true;
	do{
		cout << "Introduzca numero de objetos: ";
		cin >> n;
	}while(n<=0);
	if(n%4==1){
		sacar = false;
	}
	do{
		if(!sacar){
			cout << "Sacar 1, 2 o 3 objetos? ";
			do{
				cin >> resta;
			}while((resta<1)||(resta>3)||(resta>n));
			n-=resta;
			cout << "Quedan " << n << " objetos." << endl;
			sacar = true;
		}else{
			mod = n%4;
			switch(mod){
				case 0: cout << "La maquina resta 3. ";
						n-=3;
						cout << "Quedan " << n << " objetos" << endl;
						sacar = false;
						break;
				case 3: cout << "La maquina resta 2. " << endl;
						n-=2;
						cout << "Quedan " << n << " objetos" << endl;
						sacar = false;
						break;
				case 2: cout << "La maquina resta 1. " << endl;
						n-=1;
						cout << "Quedan " << n << " objetos" << endl;
						sacar = false;
						break;
			}
		}
	}while(n!=0);
	cout << "LO SIENTO, HAS PERDIDO. LA MAQUINA GANA!!" << endl;
}
