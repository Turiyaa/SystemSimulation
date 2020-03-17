//
// Created by narayan on 11/1/19.
//
#include "State.h"
#include "vector"
#ifndef DISCRETEEVENTCPP_MODEL_H
#define DISCRETEEVENTCPP_MODEL_H


using namespace std;

class Model : public State{
public:
    vector<string> *c;
    void deltaint();
    void deltaext(char input);
    void deltacon(char input);
    void lambda();
    vector<string> *change(int remainingCoin);
    double timeAdvance();
    void toString();
};


#endif //DISCRETEEVENTCPP_MODEL_H
