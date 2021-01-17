// Name: Jakob Valen
// Student number: V00943160

public class MaxFrequencyHeap implements PriorityQueue {

	private static final int DEFAULT_CAPACITY = 10;
	private Entry[] data;
	private int size;

	public MaxFrequencyHeap() {
		data = new Entry[DEFAULT_CAPACITY];
		size = 0;
	}

	public MaxFrequencyHeap(int size) {
		data = new Entry[size];
		size = 0;
	}

	public void insert(Entry element) {

		// First, check if the maxheap is empty
		if(this.isEmpty()){

			data[0] = element; //place the element at the start of the data array
			this.size++; // update our size counter
			return;

		}
		// check if my data array is full,
		// if so, double the array size for data
		if(this.size == data.length){

			Entry[] temp_data = new Entry[this.size*2];
			// copy data over into my temp_data array
			for(int i=0;i<data.length;i++){

				temp_data[i] = data[i];

			}
			//Set data array to this new data array
			this.data = temp_data;

		}

		int TempIndex = 0;
		// Find the index where my new element should be inserted into the heap
		// array
		while(TempIndex<this.size){
			// If my current entry has a lower priority/frequency then
			// my input element, I know I need to input my element here
			if(data[TempIndex].getFrequency()<=element.getFrequency()){

				// Shift all entrys to the right of my index where I need
				// to insert my new element
				for(int i=this.size-1;i>=TempIndex;i--){
					data[i+1] = data[i];
				}
				// Place the input element into the correct index
				data[TempIndex] = element;
				this.size++; //update our size counter
				return;

			}
			TempIndex++;


		}
		// If the function makes it to this line, we know our input
		// element is the smallest in the maxheap, so insert it at the end
		// of the heap
		data[this.size] = element;
		this.size++; // update our size counter
		return;

	}

	public Entry removeMax() {


		Entry max = data[0]; // The max entry we will return

		// Shift the rest of the entrys in the maxheap to the left
		for(int i=1;i<this.size;i++){
			data[i-1] = data[i];
		}
		this.size--; // update our size counter

		return max;
	}

	public boolean isEmpty() {
		// Our default value will be false
		boolean empty = false;

		//Check if in fact our heap is empty
		if(this.size == 0){
			empty = true;
		}
		return empty;
	}

	public int size() {
		// Simply return our size variable
		return this.size;
	}

}
