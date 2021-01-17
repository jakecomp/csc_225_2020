// Name: Jakob Valen
// Student number: V00943160

public class WordFrequencyReport {
	private static final int CAPACITY = 5;

	/*
	 * Purpose: Obtain the 5 most frequent words found
	 * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
	 * Returns: Entry[] - an array containing the top 5 entries (which are the
	 *     word, frequency pairs with the maximum frequency values)
	 */
	public static Entry[] overallMostFrequent(MaxFrequencyHeap h) {
		Entry[] top5 = new Entry[CAPACITY];

		int top5_counter = 0; // our temporary top5 counter

		// Iterate through our maxheap until we find the top 5 words
		while(top5_counter<5){
			// If our heap is empty simply return the top5 array
			if(h.isEmpty()){
				break;

			}else{
				// Add the current max word from our heap using remove max
				top5[top5_counter] = h.removeMax();
				top5_counter++; // Increment our top 5 counter
			}
		}

		return top5;
	}

	/*
	 * Purpose: Obtain the 5 most frequent words found that are at least n charaters long
	 * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
	 *             int n - minimum word length to consider
	 * Returns: Entry[] - an array containing the top 5 entries (which are the
	 *     word, frequency pairs with the maximum frequency values of words
	 *     that are at least n characters long)
	 */
	public static Entry[] atLeastLength(MaxFrequencyHeap h, int n) {
		Entry[] top5 = new Entry[CAPACITY];

		int counter = 0;

		// While our heap is not empty and we
		// havent found the top 5 words of the minimum length n
		// remove the max word from our heap
		while(h.size()>0 && counter!=5){

			Entry current_entry = h.removeMax();

			String current_word = current_entry.getWord();

			// If the current max word has a lenght at least the size of n,
			// add that entry to our top5 array
			if(current_word.length()>=n){

				top5[counter] = current_entry;
				counter++;
			}
		}
		return top5;
	}

	/*
	 * Purpose: Obtain the 5 most frequent words found that begin with the given letter
	 * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
	 *             char letter - only words that begin with given letter are considered
	 * Returns: Entry[] - an array containing the top 5 entries (which are the
	 *     word, frequency pairs with the maximum frequency values of words
	 *     that begin with the given letter)
	 */
	public static Entry[] startsWith(MaxFrequencyHeap h, char letter) {
		Entry[] top5 = new Entry[CAPACITY];

		int counter = 0;

		// While our heap is not empty and we
		// havent found the top 5 words of the minimum length n
		// remove the max word from our heap
		while(h.size()>0 && counter!=5){

			Entry current_entry = h.removeMax();

			String current_word = current_entry.getWord();

			// If the current entry word starts with the letter we are looking for
			// add the entry to our top5 array
			if(current_word.charAt(0)==letter){

				top5[counter] = current_entry;
				counter++;
			}
		}

		return top5;
	}

}
