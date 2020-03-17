//
// Created by narayan on 11/11/19.
//
#include "iostream"
#include "Model.h"
#include "vector"
#include "Event.h"
#include "queue"
#include "PQ.h"

#ifndef HW5CPP_NETWORK_H
#define HW5CPP_NETWORK_H
using namespace std;

class Network : public Model {
public:
    ~Network() {}

    double globalTime;
    string name;
    int output = 0;
    vector<Model *> models;
    PQ<Event> *pq = new PQ<Event>;

    Network(string n) {
        this->name = n;
    }

    string getName() {
        return name;
    }

    void lambda() {
        if (output == 1) {
            cout << "Output: time = " << globalTime << +" Washer\n" << endl;
        }
//        for (int i = 0; i < models.size(); i++) {
//            //str = name+" = "+"("+parts+", "+time+")";
//
//            cout<<"State: time = "<<globalTime <<", "<< "name "
//            <<models.at(i)->getName()<<endl;
//        }
        output = 0;
    }

    void deltaint() {

    }

    void deltaext(double e, int input) {
    }

    void deltacon(int input) {

    }

    double ta() {
        return 0;
    }

    void coupling(double b1, Model *m, Event e) {
        Model *press = models.at(0);
        Model *drill = models.at(1);
        globalTime += m->ta();
        if (m->getName().compare(this->getName()) == 0) {
            e.model = press;
            press->deltaext(globalTime - b1, 1);
            e.setType(Event::INT);
            pq->push(e);
        } else if (m->getName().compare(press->getName()) == 0) {
            e.model = drill;
            e.setTime(globalTime);
            e.setType(Event::INT);
            press->deltaint();
            drill->deltaext(globalTime - b1, 1);
            pq->push(e);
        } else if (m->getName().compare(drill->getName()) == 0) {
            drill->deltaint();
            output = 1;
        }
    }

};

#endif //HW5CPP_NETWORK_H
