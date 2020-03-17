//
// Created by narayan on 11/11/19.
//
#include "string"

#ifndef HW5CPP_MODEL_H
#define HW5CPP_MODEL_H
using namespace std;


class Model {
public:
    virtual ~ Model() {};

    virtual string getName() = 0;

    virtual void lambda() = 0;

    virtual void deltaint() = 0;

    virtual void deltaext(double e, int input) = 0;

    virtual void deltacon(int input) = 0;

    virtual double ta() = 0;
};

#endif //HW5CPP_MODEL_H
