// Student Name: Jakob Valen
// Student ID #: V00943160
 /*
 * A Huffman Tree.
 * Huffman Trees are built with Huffman Nodes (HNodes)
 */
public class HuffmanTree {
	HNode root;

	public HuffmanTree(HNode root) {
		this.root = root;
	}

	/*
	 * Purpose: Decode the sequence of bits and return the associated string
	 * Parameters: BitQueue input - the input sequence of bits
	 * Returns: String - the decoded text
	 * Example:
	 *   For decoding an input, every time a 0-bit is read,
	 *   the associated letter is found in the left subtree.
	 *   Every time a 1-bit is read, the associated letter
	 *   is found in the right subtree.
	 *
	 *   When a leaf node is detected, a letter can be added
	 *   to the output String. To decode the next sequence of
	 *   bits, start traversing the tree from the root.
	 *
	 *   See the lecture exercise for more details.
	 */
	public String decode(BitQueue input) {
		try {
			return decodeRecursive(root, input,"");
		} catch (DecodeException e) {
			System.out.println(e);
		}
		return "Invalid coding";
	}

	public String decodeRecursive(HNode cur, BitQueue input,String output) throws DecodeException {

		// This is our base case, if our BitQueue is empty we must be at a leaf node,
		// so add the final letter to our output string
		if(input.isEmpty()){

			output = output.concat(cur.letter);

			return output;

		}
		// Check if we are at a leaf node, if so add the letter to output,
		// and reset our current node to the root node
		else if(cur.right == null && cur.left == null){
			output = output.concat(cur.letter);
			return decodeRecursive(root,input,output);

		}else{

		String current_num = input.dequeue();

		// If the current number dequeued is 1, we need to go to the right child
		if(current_num.equals("1")){

			HNode next_node = cur.right;

		  return decodeRecursive(next_node,input,output);

		// Else, go to the left child
		} else if(current_num.equals("0")) {

			HNode next_node = cur.left;
			return decodeRecursive(next_node,input,output);
			}
		}
		return output;
	}

}
