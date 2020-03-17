#include <iostream>
#include "Model.h"
using namespace std;

Model *model = new  Model();
int main() {
    int tickNumber = 0;
    string input;

    cout << "Ticks " << tickNumber << " Input: ";
    cin>>input;
    while (input.compare("exit") !=0){
        model->lambda();
        model->delta(input);

        tickNumber++;
        cout << "\nTicks " << tickNumber << " Input: ";
        cin>>input;
    }
    delete model;
    return 0;
}