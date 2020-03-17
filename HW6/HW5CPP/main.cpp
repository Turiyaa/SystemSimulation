#include <iostream>
#include "vector"
#include "Event.h"
#include "Machine.h"
#include "Network.h"

int main() {

    Machine *press = new Machine("press", 1);
    Machine *drill = new Machine("drill", 2);

    Network *network = new Network("network");

    network->models.push_back(press);
    network->models.push_back(drill);

    while (true) {
        double time;
        int parts;
        char space;
        cout << "Time" << " " << "Parts" << endl;
        cin >> time >> parts;
        for (int i = 0; i < parts; i++) {
            Event *e = new Event(time, network, Event::EXT);
            network->pq->push(*e);
        }
        if(time == 0.0){
            break;
        }
    }
    network->globalTime = network->pq->peek().time;
    while(!network->pq->isEmpty()){
        network->lambda();
        Event e = network->pq->poll();
        if (e.getTime() > network->globalTime)
            network->globalTime= e.getTime();

        network->coupling(network->globalTime, e.model, e);
    }
    network->lambda();


    delete press;
    delete drill;
    delete network;
        return 0;
    }