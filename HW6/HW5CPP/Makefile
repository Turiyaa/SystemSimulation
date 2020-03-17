vm: main.o 
	g++ main.o -o vm
main.o: main.cpp
	g++ -c  main.cpp
Event.o : Event.h
	g++ -c Event.h
Model.o: Model.h
	 g++ -c Model.h
Machine.o: Machine.h
	 g++ -c Machine.h
Network.o: Network.h
	g++ -c Network.h
PQ.o: PQ.h
	g++ -c PQ.h
clean:
	rm *.o vm