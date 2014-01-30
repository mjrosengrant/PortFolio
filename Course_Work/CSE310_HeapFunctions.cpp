#include <iostream>
#include <math.h>
#include "Heap.h"
using namespace std;

void maxHeapify(Heap heap, int i){
	int n=0;
	int l = 2*i;
	int r = 2*i + 1;
	ELEMENT *left = NULL;
	ELEMENT *right = NULL;

	if(heap.size >= 2*i)
		left = &heap.H[2*i];
	if(heap.size>=2*i+1)
		right = &heap.H[2*i+1];

	//If a node has children, it will have at least a left node, and possibly a right.
	//The if statements deduce whether the left or right child
	//needs to be moved.
	if(left != NULL){
		if(left->key > heap.H[i].key){
			if(right==NULL) 
				n = l;
			else if(left->key >= right->key)
				n = l;
			else if (left->key < right->key)
				n = r;
		}
		else if (right != NULL){
			if(right->key > left->key && right->key > heap.H[i].key)
				n = r;
		}

		if(n!=0){
			ELEMENT *temp = new ELEMENT;
			*temp = heap.H[i];
			heap.H[i] = heap.H[n];
			heap.H[n] = *temp;
			delete temp;
			maxHeapify(heap, n);
		}
	}
};

//Copies the elements in A into heap->H and uses the linear time build heap algorithm
//to obtain a heap of size size(A).	
void buildHeap(Heap heap){
	for(int i = floor(heap.size/2.0); i>=1; i--){
		maxHeapify(heap, i);
	}
};

//Returns an object of type HEAP with capacity n and size 0.
struct Heap initialize(int n){
	Heap newHeap;
	newHeap.capacity = n;
	newHeap.size = 0;
	newHeap.H = new ELEMENT[n];
	return newHeap;
}

//Inserts an element with key equal to k into the max-heap heap
void insert(Heap heap, int k){
	ELEMENT *e = new ELEMENT;
	e->key = k;
	heap.H[heap.size] = *e;
	delete e;
	}

//Deletes the element with maximum key and returns it to the caller.
int deleteMax(Heap heap){
	int max = heap.H[1].key;
	heap.H[1] = heap.H[heap.size];
	heap.size--;
	buildHeap(heap);

	return max;
};

//Increases the key field of element to value, which should not be smaller than the current value. 
//Note that you have to make necessary adjustment to make sure that heap order is maintained.
int increaseKey(Heap heap, ELEMENT element, int value){
	if(element.key < value){
		return value;
	}
};

//prints out the heap information, including capacity, size, and the key fields of the elements 
//in the array with index going from 1 to size.
void printHeap(Heap heap){
	cout<<heap.capacity <<endl;
	cout<<heap.size<<endl;
	for(int i = 1; i<=heap.size; i++){
		cout<<heap.H[i].key <<endl;
	}
}
