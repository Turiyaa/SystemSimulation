//
// Created by narayan on 10/26/19.
//
#include "string.h"
#ifndef NETWORKMODELCPP_MODEL_H
#define NETWORKMODELCPP_MODEL_H

using namespace std;
class Model{
public:
    virtual ~ Model(){};
    virtual string getName() = 0;
    virtual void lambda()  = 0;
    virtual void delta(int input) = 0;
    virtual void debug() = 0;
    virtual int ta() = 0;
};


#endif //NETWORKMODELCPP_MODEL_H
