//
// Created by narayan on 10/14/19.
//

#ifndef VANDINGMACHINECPP_STATE_H
#define VANDINGMACHINECPP_STATE_H
class State {
private:
    int quarter;
    int nickel;
    int dime;
    int value;
    bool change;

public:
    int getQuarter();
    void setQuarter(int quarter);
    int getNickel();
    void setNickel(int nickel);
    int getDime();
    void setDime(int dime);
    int getValue();
    void setValue(int value);
    bool isChange();
    void setChange(bool change);

};

#endif //VANDINGMACHINECPP_STATE_H
