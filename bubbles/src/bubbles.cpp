//============================================================================
// Name        : bubbles.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
// Bubble Sort Function for Descending Order
void bubbleSort(int array[], int n) {
      bool intercambio = true;
      int j = 0;
      int tmp;
      while (intercambio) {
            intercambio = false;
            j++;
            for (int i = 0; i < n - j; i++) {
                  if (array[i] > array[i + 1]) {
                        tmp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = tmp;
                        intercambio = true;
                  }
            }
      }
}

int main() {

	cout << "" << endl; // prints 
	return 0;
}
