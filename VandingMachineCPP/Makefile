vm: main.o Model.o State.o VMConstant.o
	g++ main.o Model.o State.o VMConstant.o -o vm
main.o: main.cpp
	g++ -c  main.cpp
Model.o : Model.cpp Model.h
	g++ -c Model.cpp
State.o: State.cpp State.h
	 g++ -c State.cpp
VMConstant.o: VMConstant.cpp
	      g++ -c VMConstant.cpp
clean:
	rm *.o vm