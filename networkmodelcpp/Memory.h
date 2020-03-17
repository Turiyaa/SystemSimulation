//
// Created by narayan on 10/27/19.
//
#include <iostream>
#include "Model.h"
#include "string.h"

#ifndef NETWORKMODELCPP_MEMORY_H
#define NETWORKMODELCPP_MEMORY_H
using namespace std;

class Memory: public Model{
public:
    int q1 = 0;
    int q2 = 0;
    string name;
    int prevSq1;
    int prevSq2;


    Memory(string n){
        this->name = n;
    }

    string getName(){
        return name;
    }

    int getCurrentState(){
        return q1;
    }

    void lambda() {
        cout<< name << " state \t\t: "<<"{"<< q1<<","<<q2<<"}"<<endl;
        prevSq1 = q1;
        prevSq2 = q2;
    }

    void delta(int input) {
        q1= q2;
        q2 = input;
    }
    void debug() {
        if (!(q1 == prevSq1 && q2 == prevSq2))
        cout<< name << " new state \t: "<<"{"<< q1<<","<<q2<<"}"<<endl;

    }

    int ta(){
        return 1.0;
    }

};
#endif //NETWORKMODELCPP_MEMORY_H
