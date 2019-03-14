public class BinarySearchTree {
	private Node root;
	private int size;
	//constructor
	public BinarySearchTree(){
		root=null;
		size=0;
	}
	public boolean isEmpty(){
		return root==null;
	}
	
	//adds node to the tree or increases frequency if same word is found
	public void insert(String word){
		size++;   //using this for jgrasp
		Node hold=new Node(word);
		if(isEmpty()==true){ //initially sets up the first root
			root=hold;
		}
		else{
			add(root, hold); //starts building the tree
		}
	}
	//a recursive algorithm to compare and populate the tree in order
	void add(Node subroot,Node hold){
		
		if(hold.getWord().equals(subroot.getWord())){
			subroot.increaseFreq();
		}
		//left
		else if(hold.getWord().compareTo(subroot.getWord())<0){
			if(subroot.getLeft()==null){
				subroot.setLeft(hold);
			}
			else{
				
				add(subroot.getLeft(),hold);
			}
		}
		//right
		else{
			if(subroot.getRight()==null){
				subroot.setRight(hold);
			}
			else{
				add(subroot.getRight(),hold);
			}
		}
	}
	//searches tree for the word
	public void search(String word){
		System.out.println("The word you are looking for is "+ word);
		if(word.equals(root.getWord())){
			System.out.println(root.toString());
		}
		else{
			search(root, word);
		}
	}
	
	void search(Node subroot,String word){
			System.out.println("-------------");//to show the new iteration
		//left			
		if(word.compareTo(subroot.getWord())<0){
			if(subroot.getLeft()==null){
			System.out.println("The word "+word+" does not exist in the database");	
			}
			else if(word.equals(subroot.getLeft().getWord())){
				System.out.println(subroot.getLeft().toString());
			}
			else{
				search(subroot.getLeft(),word);
			}
		}
		//right
		else if(word.compareTo(subroot.getWord())>0){
			if(subroot.getRight()==null){
			System.out.println("The word "+word+" does not exist in the database");	
			}
			else if(word.equals(subroot.getRight().getWord())){
				System.out.println(subroot.getRight().toString());
			}
			else{
				search(subroot.getRight(),word);
			}
		}
		else{
			System.out.println(subroot.toString());
		}
	}
	
	//prints Preorder	Root->Left subtree->Right Subtree
	public void printPreOrder(){
         System.out.println("\nPrinting PreOrder");
			printPreOrder(root);	
	}
	void printPreOrder(Node subroot){
		//Initially Has Left
		if(subroot.getLeft()!=null){
			System.out.println(subroot.toString());
			printPreOrder(subroot.getLeft());
			if(subroot.getRight()!=null){
				printPreOrder(subroot.getRight());
			}
		}
		//Initially has right
		else if(subroot.getRight()!=null){
			System.out.println(subroot.toString());
			printPreOrder(subroot.getRight());
		}
		//root only
		else{
			System.out.println(subroot.toString());
		}
			
	}
	//Left->Root->Right
	public void printInOrder(){
      System.out.println("\nPrinting InOrder");
      printInOrder(root);
	}
   void printInOrder(Node subroot){
	   //go left till you cant
      if(subroot.getLeft()!=null){
         printInOrder(subroot.getLeft());
         
         if(subroot.getRight()!=null){
        	 //print root
            System.out.println(subroot.toString());
            //go right after left
            printInOrder(subroot.getRight());
         }
         else{
        	 //no right
            System.out.println(subroot.toString());           
         }
      }
      //no Left to go
      else if(subroot.getRight()!=null){
         System.out.println(subroot.toString());
         printInOrder(subroot.getRight());
      }
      else{
    	  //No left or Right
         System.out.println(subroot.toString());
      }
   }
   	//Left->Right->Root
	public void printPostOrder(){
      System.out.println("\nPrinting PostOrder");
      printPostOrder(root);
	}
   void printPostOrder(Node subroot){
	   //starts left
      if(subroot.getLeft()!=null){
         printPostOrder(subroot.getLeft());
         
         //right after left
         if(subroot.getRight()!=null){
            printPostOrder(subroot.getRight());
         }
         
         //prints if no more right or after right has been followed
         System.out.println(subroot.toString());
      }
      //no initial left
      else if(subroot.getRight()!=null){
         printPostOrder(subroot.getRight());
         System.out.println(subroot.toString());
      }
      else{
    	  //no left or right
      System.out.println(subroot.toString());
      }
   }  

   
}
		 
