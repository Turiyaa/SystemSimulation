//
// Created by narayan on 10/14/19.
//
#include <iostream>
#include "State.h"
#include <vector>
#ifndef VANDINGMACHINECPP_MODEL_H
#define VANDINGMACHINECPP_MODEL_H

using namespace std;
using std::vector;

class Model : public State{
public:
    void delta(string input);
    void lambda();
    vector<string> *change(int remainingCoin);
};


#endif //VANDINGMACHINECPP_MODEL_H
