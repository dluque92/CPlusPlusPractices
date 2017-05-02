//============================================================================
// Name        : Practica1Ejercicio6.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
int mb,kb,bytes,num,restomb;
int main() {
	cout <<"Programa para pasar de Bytes a MegaBytes, KiloBytes y Bytes.\n";
	cout <<"Introduce los Bytes: ";
	cin >>num;
	mb=num/1048576;
	restomb=num%1048576;
	kb=restomb/1024;
	bytes=restomb%1024;
	cout << num << " Bytes son "<<mb<< " MegaBytes, " <<kb<< " KBytes y "<<bytes<< " Bytes."<< endl;
	return 0;
}
