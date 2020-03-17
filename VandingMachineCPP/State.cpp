//
// Created by narayan on 10/14/19.
//

#include "State.h"

int State::getQuarter() {
    return quarter;
}

void State::setQuarter(int quarter) {
    this->quarter = quarter;
}

int State::getNickel() {
    return nickel;
}

void State::setNickel(int nickel) {
    this->nickel = nickel;
}

int State::getDime() {
    return dime;
}

void State::setDime(int dime) {
    this->dime = dime;
}

int State::getValue() {
    return value;
}

void State::setValue(int value) {
    this->value = value;
}

bool State::isChange() {
    return change;
}

void State::setChange(bool change) {
    this->change = change;
}
