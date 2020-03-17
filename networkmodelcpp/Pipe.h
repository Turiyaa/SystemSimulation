//
// Created by narayan on 10/27/19.
//

#ifndef NETWORKMODELCPP_PIPE_H
#define NETWORKMODELCPP_PIPE_H
using namespace std;

class Pipe {
public:
    int storedVal= 0;
    int inputValues[2];
    int mp = 0;
    int output(int val){
        this->storedVal = val;
        return storedVal;
    }

    int* input() {
        return this->inputValues;
    }

    int memoryPipe() {
        return mp;
    }
};
#endif //NETWORKMODELCPP_PIPE_H
