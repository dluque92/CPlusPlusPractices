//============================================================================
// Name        : Practica06Ejercicio06.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

struct TComplejo {
	double p_real, p_imaginaria;
};

void leerComplejo(TComplejo& complejo){
	cout << "Introduce parte real: ";
	cin >> complejo.p_real;
	cout << "Parte imaginaria: ";
	cin >> complejo.p_imaginaria;
}

void sumar(TComplejo &resultado, const TComplejo &a, const TComplejo &b){
	resultado.p_real= a.p_real +b.p_real;
	resultado.p_imaginaria= a.p_imaginaria + b.p_imaginaria;
}

void restar(TComplejo &resultado, const TComplejo &a, const TComplejo &b){
	resultado.p_real= a.p_real - b.p_real;
	resultado.p_imaginaria= a.p_imaginaria - b.p_imaginaria;
}

void multiplicar(TComplejo &resultado, const TComplejo &a, const TComplejo &b){
	resultado.p_real = (a.p_real*b.p_real)-(a.p_imaginaria*b.p_imaginaria);
	resultado.p_imaginaria = (a.p_real*b.p_imaginaria)+(a.p_imaginaria*b.p_real);
}

void dividir(TComplejo &resultado, const TComplejo &a, const TComplejo &b){
	resultado.p_real = ((a.p_real*b.p_real)+(a.p_imaginaria*b.p_imaginaria))/(b.p_real*b.p_real + b.p_imaginaria*b.p_imaginaria);
	resultado.p_imaginaria = (a.p_imaginaria*b.p_real-a.p_real*b.p_imaginaria)/(b.p_real*b.p_real + b.p_imaginaria*b.p_imaginaria);
}

void mostrarComplejo(TComplejo &a){
	cout << a.p_real << "+" << a.p_imaginaria <<"i" << endl;
}

int main() {
	cout << "Operaciones con números complejos." << endl;
	TComplejo a, b, resultado;
	cout << "Introduce dos numeros complejos a operar." << endl;
	leerComplejo(a);
	leerComplejo(b);
	cout << "Resultado de su suma: ";
	sumar(resultado, a, b);
	mostrarComplejo(resultado);
	cout << "Resultado de su resta: ";
	restar(resultado, a, b);
	mostrarComplejo(resultado);
	cout << "Resultado de su multiplicacion: ";
	multiplicar(resultado, a, b);
	mostrarComplejo(resultado);
	cout << "Resultado de su division: ";
	dividir(resultado, a, b);
	mostrarComplejo(resultado);
	return 0;
}
