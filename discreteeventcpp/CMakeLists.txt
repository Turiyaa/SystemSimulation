cmake_minimum_required(VERSION 3.14)
project(discreteeventcpp)

set(CMAKE_CXX_STANDARD 14)

add_executable(discreteeventcpp main.cpp State.cpp State.h Model.cpp Model.h VMConstant.cpp)