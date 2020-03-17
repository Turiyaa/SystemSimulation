
#include "iostream"
#include "Network.h"
#include "XOR.h"
#include "Memory.h"
int main() {
    Network *network = new Network("Network");
    XOR *XOR1 = new XOR("XOR1");
    XOR *XOR2 = new XOR("XOR2");
    Memory *M = new Memory("Memory");
    Pipe *p = new Pipe();

    std::cout <<network->getName()<< std::endl;
    std::cout <<XOR1->getName()<< std::endl;
    std::cout <<XOR2->getName()<< std::endl;
    std::cout <<M->getName()<< std::endl;

    network->models.push_back(XOR1);
    network->models.push_back(XOR2);
    network->models.push_back(M);

    while(true){
        int b1 = 0;
        int b2 = 0;
        cout<<"Input 1:";
        cin>> b1;
        cout<<"Input 2:";
        cin>>b2;

        p->inputValues[0] = b1;
        p->inputValues[1] = b2;

        network->lambda();
        for(Model* m: network->models){
            m->lambda();
        }

        for(int i = 0; i < 3; i++){
            int pipe = M->getCurrentState();
            for(int j = 0; j < network->models.size(); j++){
                network->coupling(network->models.at(j), p, pipe);
                network->models.at(i)->delta(p->storedVal);

            }
        }

        for(int k = 0; k < network->models.size(); k++){
            network->models.at(k)->debug();
        }
        // exit if input is not (0 or 1)
        if(b1 != 0 && b1 != 1){
            break;
        }
    }
    delete p;
    delete network;
    delete XOR1;
    delete XOR2;
    delete M;
    return 0;
}