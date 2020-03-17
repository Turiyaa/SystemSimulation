//
// Created by narayan on 11/11/19.
//

#ifndef HW5CPP_PQ_H
#define HW5CPP_PQ_H

#include "math.h"

template<class E>
class PQ {
public:
    vector<E> heap;

    PQ() {}

    void push(E e) {
        heap.push_back(e);
        moveUp(heap.size() - 1);
    }

    E poll() {
        E min = heap[0];
        heap[0] = heap.at(heap.size() - 1);
        heap.pop_back();
        moveDown(0);
        return min;
    }

    E peek() {
        return heap.front();
    }

    int left(int parent) {
        int left = 2 * parent + 1;
        if (left < heap.size())
            return left;
        else
            return -1;
    }

    int right(int parent) {
        int r = 2 * parent + 2;
        if (r < heap.size())
            return r;
        else
            return -1;
    }

    int parent(int child) {
        int p = (child - 1) / 2;
        if (child == 0)
            return -1;
        else
            return p;
    }

    void moveUp(int index) {
        if (index >= 0 && parent(index) >= 0 && heap[parent(index)] > heap[index]) {
            E temp = heap[index];
            heap[index] = heap[parent(index)];
            heap[parent(index)] = temp;
            moveUp(parent(index));
        }
    }

    void moveDown(int index) {
        int child = left(index);
        int child1 = right(index);
        if (child >= 0 && child1 >= 0 && heap[child] > heap[child1]) {
            child = child1;
        }
        if (child > 0 && heap[index] > heap[child]) {
            E e = heap[index];
            heap[index] = heap[child];
            heap[child] = e;
            moveUp(child);
        }
    }

    bool isEmpty() {
        return heap.size() > 0 ? false : true;
    }

    //check for confluence case
};

#endif //HW5CPP_PQ_H
