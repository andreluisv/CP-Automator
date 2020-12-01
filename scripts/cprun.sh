#!/bin/bash
cd $CP_PATH
g++ -std=c++17 main.cpp  -o main && ./main < in
