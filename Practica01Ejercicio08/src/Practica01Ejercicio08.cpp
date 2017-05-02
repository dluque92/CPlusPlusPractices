//============================================================================
// Name        : Practica1Ejercicio8.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================
#include <iostream>
using namespace std;
string cadena;
int i;
int main(){
cout << "Programa para convertir cuatro letras en minusculas a mayusculas.\n";
cout << "Introduce las cuatro letras: ";
cin >> cadena;
   for(i = 0; cadena[i]; i++)
      cadena[i] = toupper(cadena[i]); //<--convierte a mayusculas
cout << cadena<< endl;
   return 0;
}
