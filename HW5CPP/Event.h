//
// Created by narayan on 11/11/19.
//

#ifndef HW5CPP_EVENT_H
#define HW5CPP_EVENT_H


#include "Model.h"

class Event {
public:
    ~Event() {}

    enum EventType {
        INT, EXT, CON
    };
    double time;
    EventType type;
    Model *model;

    Event(double t, Model *m, EventType tp) {
        time = t;
        type = tp;
        model = m;
    }

    double getTime() {
        return time;
    }

    void setTime(double time) {
        this->time = time;
    }

    EventType getType() {
        return type;
    }

    void setType(EventType type) {
        this->type = type;
    }

    bool operator<(Event rhs) {
        return this->time < rhs.time;
    }

    bool operator>(Event rhs) {
        return this->time > rhs.time;
    }
};

#endif //HW5CPP_EVENT_H
