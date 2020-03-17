#include "Model.h"
#include <vector>
#include "iostream"
#include "VMConstant.cpp"
using namespace std;
VMConstant vmconst;
void Model::deltaint(){
    this->lambda();
    while (getValue() >= vmconst.DOLLAR) {
        setValue(getValue() - vmconst.DOLLAR);
    }
        this->c = this->change(getValue());

        for (string coin : *this->c) {
            if (coin.compare("q") == 0) {
                setQuarter(getQuarter()-1);
                setValue(getValue() - vmconst.QUARTER);
            } else if (coin.compare("d") == 0) {
                setDime(getDime()-1);
                setValue(getValue() - vmconst.DIME);

            } else if (coin.compare("n") == 0) {
                setNickel(getNickel()-1);
                setValue(getValue() - vmconst.NICKEL);

            }
        }
        delete this->c;
    }

void Model::deltaext(char inputValue){
    switch (inputValue) {
        case 'q':
            setQuarter(getQuarter() + 1);
            setValue(getValue() + vmconst.QUARTER);
            break;
        case 'd':
            setDime(getDime() + 1);
            setValue(getValue() + vmconst.DIME);
            break;
        case 'n':
            setNickel(getNickel() + 1);
            setValue(getValue() + vmconst.NICKEL);
            break;
    }
}

void Model::deltacon(char input) {
    this->deltaint();
    this->deltaext(input);
}
void Model::lambda() {
    vector<string> *lambdaOutput = new vector<string>();
    int remainingCoin = getValue();

    while (remainingCoin >= vmconst.DOLLAR) {
        remainingCoin = remainingCoin - vmconst.DOLLAR;
        lambdaOutput->push_back("coffee");
    }

        vector<string> *change = this->change(remainingCoin);
        lambdaOutput->insert(lambdaOutput->end(), change->begin(), change->end());
        delete change;

        cout<<"[ ";
    for(string &str: *lambdaOutput){
        cout<<str<<" ";
    }
    cout<<"]"<<endl;
    delete lambdaOutput;
}

vector<string>* Model::change(int remainingCoin){
    vector<string> *change = new vector<string>;
    while (true)
        if (remainingCoin != 0) {
            if (getQuarter() > 0 && remainingCoin >= vmconst.QUARTER) {
                remainingCoin -= vmconst.QUARTER;
                change->push_back("q");
            } else if (getDime() > 0 && remainingCoin >= vmconst.DIME) {
                remainingCoin -= vmconst.DIME;
                change->push_back("d");

            } else if (getNickel() > 0 && remainingCoin >= vmconst.NICKEL) {
                remainingCoin -= vmconst.NICKEL;
                change->push_back("n");
            } else {
                delete this;
                delete change;
                cout<<"Insuffficient coins, call manager!"<<endl;
                exit(1);
            }
        } else {
            break;
        }
    return change;
}

double Model::timeAdvance() {
    double const INFINITY = numeric_limits<double>::infinity();
    return getValue() > 0 ? 2.0 : INFINITY;
}

void Model::toString(){
    cout<<"{"<<this->getQuarter()<<"," <<this->getDime()<<"," <<this->getNickel()<<"," <<this->getValue()<<"}"<<endl;
};