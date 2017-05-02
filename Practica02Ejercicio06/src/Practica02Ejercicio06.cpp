//============================================================================
// Name        : Practica02Ejercicio06.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
const float t1=0.5, t2=0.35, t3=0.25;
int main() {
	int total,num1,num2;
	float parte1,parte2,parte3,importetotal;
	cout << "Programa para calcular el importe total segun el gasto de luz. \n";
	cout << "Introduce el primer número del contador: ";
	cin >> num1;
	cout << "Introduce el segundo número del contador: ";
	cin >> num2;
	if (num1<num2){
		cout << "El primer número tiene que ser mayor que el segundo.";
	}else{
		total=num1-num2;
		if (total<=100){
			importetotal=total*t1+1;
			cout << "El importe total es: "<<importetotal <<endl;
		}else if(total <=250){
			parte1=t1*100;
			parte2=(total-100)*t2;
			importetotal=parte1+parte2+1;
			cout << "El importe total es: "<<importetotal <<endl;
		}else{
			parte1=t1*100;
			parte2=t2*150;
			parte3=(total-250)*t3;
			importetotal=parte1+parte2+parte2+1;
			cout << "El importe total es: "<<importetotal <<endl;
		}
	}
	return 0;
}
