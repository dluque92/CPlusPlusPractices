//============================================================================
// Name        : Practica01Ejercicio07.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
const double PI=3.1416;
double longitud,area;
int radio;
int main(){
cout << "Hola \n";
cout << "Este programa calcula la longitud y el área de un círculo \n";
cout << "Radio = ";
cin >> radio;
longitud = 2*PI*radio;
area = PI*(radio*radio);
cout << "Area = "<< area << endl;
cout << "Longitud = "<< longitud << endl;
return 0; // Valor de retorno al S.O.
}
