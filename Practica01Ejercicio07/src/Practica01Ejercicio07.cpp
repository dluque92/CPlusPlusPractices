//============================================================================
// Name        : Practica01Ejercicio07.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
const double PI=3.1416;
double longitud,area;
int radio;
int main(){
cout << "Hola \n";
cout << "Este programa calcula la longitud y el �rea de un c�rculo \n";
cout << "Radio = ";
cin >> radio;
longitud = 2*PI*radio;
area = PI*(radio*radio);
cout << "Area = "<< area << endl;
cout << "Longitud = "<< longitud << endl;
return 0; // Valor de retorno al S.O.
}
