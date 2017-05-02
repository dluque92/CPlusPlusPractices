//============================================================================
// Name        : ejem.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
unsigned F(unsigned n){
	unsigned res;
	if (n==0){
		res=0;
	}else{
		res=n+F(n-1);
	}
	return res;
}

int main() {
unsigned n;
cout << "Introduce un número: ";
cin >> n;
cout << F(n);
	return 0;
}
