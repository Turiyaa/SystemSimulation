//
// Created by narayan on 10/27/19.
//
#include <iostream>
#include "Model.h"
#include "string.h"
#ifndef NETWORKMODELCPP_XOR_H
#define NETWORKMODELCPP_XOR_H
using namespace std;

class XOR: public Model{
public:
    ~XOR(){}
    string name;
    int s = 0;
    int previousState;

    XOR(string n){
        name = n;
    }
    string getName(){
        return name;
    }

    void lambda(){
        cout<< name << " state \t\t\t: "<<s<<endl;
        previousState = s;
    }

    void delta(int input){
        s = input;
    }

    void debug() {
        if (previousState != s)
        cout<< name << " new state \t\t: "<<s<<endl;
    }

    int ta(){
        return 1.0;
    }
};
#endif //NETWORKMODELCPP_XOR_H
