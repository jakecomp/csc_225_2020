// Name: Jakob Valen
// Student number: V00943160

public class WordFrequencyBST {
	private TreeNode root;
	private int numElements;

	public WordFrequencyBST() {
		root = null;
		numElements = 0;
	}

	/*
	 * Purpose: Update the BST by handling input word
	 * Parameters: String word - The new word to handle
	 * Returns: Nothing
	 * Explanation: If there is no entry in the tree
	 *   representing the word, then the a new entry
	 *   should be created and placed into the correct
	 *   location of the BST. Otherwise, the existing
	 *   entry for the word should have its frequency
	 *   value incremented.
	 */
	public void handleWord(String word) {

		// First check if our tree is empty, if so
		// simply add the word to the tree
		if(root == null){
			Entry new_root = new Entry(word,1);
			root = new TreeNode(new_root);
			this.numElements++;
			return;
		}
		//Create 2 nodes, current & previous so
		// we can transverse through the bst tree
		TreeNode current = root;
		TreeNode previous_node = null;
		int compare = 0; // our comparison variable between the current node's word
										// and the input word

		// While we our not at a leaf node
		// try to find the word in the bst tree
		while(current!=null){

			compare = current.compareTo(word);

			// If compare = 0, we know we have found our word in the bst tree,
			// therefore increment the nodes frequency.
			if(compare == 0){
				current.addToFrequency();
				return;

			// If compare is <0 we know we need to go the right to keep the
			// alphabetical order of the bst tree
			}else if(compare<0){
				previous_node = current;
				current = current.right;
				continue;

			// If compare is >0 we know we need to go to the left to keep the
			// alphabetical order of the bst tree
			}else if(compare>0){
				previous_node = current;
				current = current.left;
				continue;

			}

		}
		// If we have not found the word in the bst tree,
		// we are already at the correct postion to add the word in the tree
		// due to the previous_node. So all we need to know is if the word needs
		// to be placed on the left or right of the leaf node
		if(compare<0){
			Entry new_word = new Entry(word);
			TreeNode new_node = new TreeNode(new_word);
			previous_node.right = new_node;
			return;

		}else{
			Entry new_word = new Entry(word);
			TreeNode new_node = new TreeNode(new_word);
			previous_node.left = new_node;
			return;

		}
	}
	/*
	 * Purpose: Get the frequency value of the given word
	 * Parameters: String word - the word to find
	 * Returns: int - the word's associated frequency
	 */
	public int getFrequency(String word) {

		TreeNode current = root;
		int return_freq = 0; // Default our return value to 0
		int compare = 0; // Our temporary comparison value

		// While we are still in the bst tree
		// look for the word to return it's frequency
		while(current!=null){

			compare = current.compareTo(word);

			// If compare = 0, we know we have found our word
			if(compare == 0){
				// Return the frequency of the word in the bst tree
				return_freq = current.getData().getFrequency();
				break;

				// If compare is >0 we know we need to go the left child of the
				// current node
			} else if(compare>0){

				current = current.left;
				continue;

			}else{
				// Else we need to go to the right child
				current = current.right;
				continue;

			}
		}
		return return_freq;
	}

	/****************************************************
	* Helper functions for Insertion and Search testing *
	****************************************************/

	public String inOrder() {
		if (root == null) {
			return "empty";
		}
		return "{" + inOrderRecursive(root) + "}";
	}

	public String inOrderRecursive(TreeNode cur) {
		String result = "";
		if (cur.left != null) {
			result = inOrderRecursive(cur.left) + ",";
		}
		result += cur.getData().getWord();
		if (cur.right != null) {
			result += "," + inOrderRecursive(cur.right);
		}
		return result;
	}

	public String preOrder() {
		if (root == null) {
			return "empty";
		}
		return "{" + preOrderRecursive(root) + "}";
	}

	public String preOrderRecursive(TreeNode cur) {
		String result = cur.getData().getWord();
		if (cur.left != null) {
			result += "," + preOrderRecursive(cur.left);
		}
		if (cur.right != null) {
			result += "," + preOrderRecursive(cur.right);
		}
		return result;
	}

	/****************************************************
	* Helper functions to populate a Heap from this BST *
	****************************************************/

	public MaxFrequencyHeap createHeapFromTree() {
		MaxFrequencyHeap maxHeap = new MaxFrequencyHeap(numElements+1);
		addToHeap(maxHeap, root);
		return maxHeap;
	}

	public void addToHeap(MaxFrequencyHeap h, TreeNode n) {
		if (n != null) {
			addToHeap(h, n.left);
			h.insert(n.getData());
			addToHeap(h, n.right);
		}
	}
}
