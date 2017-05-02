//============================================================================
// Name        : Practica1Ejercicio10.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
int segundos,minutos,horas,dias,semanas,num,restosemanas,restodias,restohoras;
int main() {
	cout <<"Programa para pasar de Segundos a Semanas, Dias, Horas, Minutos y Segundos.\n";
	cout <<"Introduce los Segundos: ";
	cin >>num;
	semanas=num/604800;
	restosemanas=num%604800;
	dias=restosemanas/86400;
	restodias=restosemanas%86400;
	horas=restodias/3600;
	restohoras=restodias%3600;
	minutos=restohoras/60;
	segundos=restohoras%60;
	cout << num << " Segundos son "<<semanas<< " Semanas, " <<dias<< " Dias, "<<horas<<
			" Horas, " <<minutos<< " Minutos y " <<segundos<< " Sengundos." << endl;
	return 0;
}

