public class Node {
	private String word;
	private int frequency;
	private Node leftChild;
	private Node rightChild;
		//Dustin Rickert
		//Project 3
	public Node(){
	}
		//constructor 
		public Node(String w){
		word=w;
		frequency=1;
		}
		
		//returns word
		public String getWord(){
			return word;
		}
		
		//reference to left node
		public Node getLeft(){
			return leftChild;
		}
		
		//reference to right node
		public Node getRight(){
			return rightChild;
		}
		
		//returns frequency
		public int getFreq(){
			return frequency;
		}
		
		//sets right node
		public void setRight(Node right){
			rightChild=right;
		}
		
		//sets left node
		public void setLeft(Node left){
			leftChild=left;
		}
		
		//increases frequency
		public void increaseFreq(){
			frequency++;
		}
		
		//returns a toString for displaying contents of node.
		public String toString(){
			String s="The Word "+word+" has a frequency of "+ frequency;
			return s;
		}
}
