//
// Created by narayan on 11/11/19.
//

#ifndef HW5CPP_MACHINE_H
#define HW5CPP_MACHINE_H

#include "iostream"
#include "Model.h"
#include "limits"

class Machine : public Model {
public:
    ~Machine() {}

    string name;
    double time;
    int parts;
    double remainingTime;

    Machine(string n, double t) {
        name = n;
        time = t;
        parts = 0;
    }

    string getName() {
        return name;
    }

    void lambda() {

    }

    void deltaint() {
        parts -= 1;
        remainingTime = time;
    }

    void deltaext(double e, int input) {
        if (parts > 0) {
            parts += input;
            remainingTime -= e;
        } else {
            parts += input;
            remainingTime = time;
        }
    }

    void deltacon(int q) {
        deltaint();
        deltaext(0.0, q);
    }

    double ta() {
        double const INFINITY = numeric_limits<double>::infinity();
        return parts > 0 ? remainingTime : INFINITY;
    }
};

#endif //HW5CPP_MACHINE_H
