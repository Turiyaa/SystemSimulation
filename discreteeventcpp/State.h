//
// Created by narayan on 11/1/19.
//

#ifndef DISCRETEEVENTCPP_STATE_H
#define DISCRETEEVENTCPP_STATE_H

class State {
private:
    int quarter;
    int nickel;
    int dime;
    int value;

public:
    int getQuarter();
    void setQuarter(int quarter);
    int getNickel();
    void setNickel(int nickel);
    int getDime();
    void setDime(int dime);
    int getValue();
    void setValue(int value);

};


#endif //DISCRETEEVENTCPP_STATE_H
