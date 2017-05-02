//============================================================================
// Name        : Practica08Ejercicio03.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX_ALUMNOS = 20;
const unsigned N_EVALUACIONES = 3;
typedef double notasAlumno[N_EVALUACIONES];

struct TAlumnos{
	string nombre;
	notasAlumno notas;
};

typedef TAlumnos Alumnos[MAX_ALUMNOS];

unsigned LeerNAlumnos(){
	unsigned num;
	cout <<"Introduce el número de alumnos: ";
	cin >> num;
	while(num>MAX_ALUMNOS||num<0){
		cout <<"Introduce el número de alumnos: ";
		cin >> num;
	}
	return num;
}

void LeerAlumnos(Alumnos& alumnos, unsigned n){
	for (unsigned i=0; i<n; i++){
		cout << "Introduce el Nombre y las 3 notas: ";
		getline(cin,alumnos[i].nombre,' ');
		for (unsigned j=0; j<N_EVALUACIONES; j++){
			cin >> alumnos[i].notas[j];
		}
	}
	cout <<endl;
}

void NotasAlumnos(Alumnos& alumnos, unsigned n){
	cout << "Alumno \t Nota 1 \t Nota 2 \t Nota 3" << endl;
	cout << "-------------------------------------------------------" <<endl;
	for (unsigned i=0; i<n; i++){
		cout << alumnos[i].nombre <<"\t";
		for (unsigned j=0; j<N_EVALUACIONES; j++){
			if (alumnos[i].notas[j]<5){
				cout << "Suspenso \t";
			}else{
				cout << "Aprobado \t";
			}
		}
	}
}

int main() {
	Alumnos alumnos;
	unsigned n;
	cout << "Programa que dice si el alumno está aprobado o suspenso."<<endl;
	n=LeerNAlumnos();
	LeerAlumnos(alumnos,n);
	NotasAlumnos(alumnos,n);
	return 0;
}
