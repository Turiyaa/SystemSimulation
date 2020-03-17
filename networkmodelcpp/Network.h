//
// Created by narayan on 10/27/19.
//
#include <string>
#include "Model.h"
#include "vector"
#include "Pipe.h"
#ifndef NETWORKMODELCPP_NETWORK_H
#define NETWORKMODELCPP_NETWORK_H

using namespace std;
class Network: public Model{
public:
    ~Network(){}
    string name ;
    int output = 0;
    vector<Model*> models;
    Network(string n){
        this->name = n;
    }
    string getName(){
        return name;
    }
    void lambda(){
        cout<< "Network Output \t\t:" << output<<endl;
    }
    void delta(int input){
        this->output = input;
    }

    void coupling(Model *m, Pipe *p, int mPipe) {
        int output;
        if(m->getName().compare("XOR1") == 0){
            output = p->inputValues[0] ^ p->inputValues[1];
            p->output(output);
        }else if(m->getName().compare("XOR2") == 0){
            output = p->storedVal ^ mPipe;
            p->output(output);
            this->output = output;
        }else if(m->getName().compare("Memory") == 0){
            p->output(p->storedVal);
        }
    }
    void debug(){

    }
    int ta(){
        return 1.0;
    }
};
#endif //NETWORKMODELCPP_NETWORK_H
