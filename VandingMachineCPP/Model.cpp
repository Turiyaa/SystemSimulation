//
// Created by narayan on 10/14/19.
//

#include "Model.h"
#include <vector>
#include "iostream"
#include "VMConstant.cpp"
#include <stdexcept>
using namespace std;
VMConstant vmconst;
void Model::deltaint(string input){
    while (getValue() >= vmconst.DOLLAR) {
        setValue(getValue() - vmconst.DOLLAR);
    }
    if (isChange()) {
        vector<string> *change = this->change(getValue());

        for (string coin : *change) {
            if (coin.compare("q") == 0) {
                setValue(getValue() - vmconst.QUARTER);
            } else if (coin.compare("d") == 0) {
                setValue(getValue() - vmconst.DIME);

            } else if (coin.compare("n") == 0) {
                setValue(getValue() - vmconst.NICKEL);

            }
        }
        delete change;
    }
        bool cancel = false;
        for (int i = 0; i < input.length(); i++) {
            char inputValue = input.at(i);
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
                case 'c':
                    cancel = true;
                    break;
            }
        }

        setChange(cancel);

};

void Model::lambda() {
        vector<string> *lambdaOutput = new vector<string>();
        int remainingCoin = getValue();

        while (remainingCoin >= vmconst.DOLLAR) {
            remainingCoin = remainingCoin - vmconst.DOLLAR;
            lambdaOutput->push_back("coffee");
        }

        if (isChange()) {
            vector<string> *change = this->change(getValue());
            lambdaOutput->insert(lambdaOutput->end(), change->begin(), change->end());
            delete change;
        }

        if (lambdaOutput->size() <= 0) {
            lambdaOutput->push_back("nothing");
        }

        for(string &str: *lambdaOutput){
            cout<<str;
        }
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
                cout<<"Insuffficient coins, call manager!"<<endl;
                exit(1);
            }
        } else {
            break;
        }
        return change;
}