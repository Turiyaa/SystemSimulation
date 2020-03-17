cmake_minimum_required(VERSION 3.14)
project(VandingMachineCPP)
set(CMAKE_CXX_STANDARD 14)
add_executable(VandingMachineCPP main.cpp Model.cpp Model.h State.cpp State.h VMConstant.cpp)