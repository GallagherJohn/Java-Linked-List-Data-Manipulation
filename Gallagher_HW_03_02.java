//John Gallagher
//COSC_237
//HW_3_2
//Unordered Linked lists merge

public class DoubleLinkedList<T> 
{
//Double linked list node class 
  public class DoubleLinkedListNode<T>
  {
    T info;    
    DoubleLinkedListNode<T> next;
    DoubleLinkedListNode<T> back;
        public DoubleLinkedListNode()
     
    {
        info = null;
         next = null;
          back = null;
        }
       public String toString()
        {
        return info.toString();
        }
     }
    protected int count; //number of nodes
    protected DoubleLinkedListNode<T> first; //reference to first node
    protected DoubleLinkedListNode<T> last; //reference to last node
    
  //Initialize the list
    public void initializeList()
    {
      first=last=null;
      count=0;
    }
    
 
  //return true if emtpy
  public boolean isEmptyList()
  {
    if(first==null)     
      return true;   
    else      
      return false;   
  }  
  
//Returns the first element in the list 
  public T front()
  {
    return first.info; 
  }
  
//Last element in the list
  public T back()
  { 
    return last.info;   
  }
  
  
//Length of list
  public int length()  {  
    return count;  
  }
  
//Display list 
  public void print() {
    
    DoubleLinkedListNode<T> currentNode=first;

    while(currentNode!=null)   //start traversing the lsit
    { 

      System.out.println(currentNode.info.toString()+" "); //print ndoe

      currentNode=currentNode.next;    //next ndoe
    }      
  } 
  
//Displays the list in reverse order
  public void reversePrint() { 
    
    DoubleLinkedListNode<T> tempNode=last;

    while(tempNode!=null)  //traverses list backwards
    {  

      System.out.println(tempNode.info.toString()+" "); // print current node

      tempNode=tempNode.back; //next node
    } 
  }
  

  //Search retrns true if item is found
  public boolean search(T searchItem) {  
    
    DoubleLinkedListNode<T> tempNode=first;   

    
    while(tempNode!=null)     {      
      
      
      if(tempNode.info.toString()==searchItem.toString())        
        return true; // if found     
 
      tempNode=tempNode.next;      
    }    
 
    return false; //if item is not found  
  }  

  
  public void insertNode(T insertItem)    
  {
    
    DoubleLinkedListNode<T> newNode=new DoubleLinkedListNode<T>();   
    newNode.info=insertItem;   
    DoubleLinkedListNode<T> currentNode=first;   
    DoubleLinkedListNode<T> previousNode=null;   
    boolean foundPosition=false;  
    
    
    if(first==null)    
    {    
      first=last=newNode;    
      count++;  
    }    
    //if the list is not empty    
    else      
    {      
      //Start traversing      
      while((currentNode!=null) && (foundPosition == false))       
      {       

        Comparable<T> temp=(Comparable<T>) currentNode.info;  //make current node info      
             
        if(temp.compareTo(insertItem)>=0)        
        {        
          foundPosition=true;        
          break;        
        }     
        //Keep tract of previous and next nodes
        previousNode=currentNode;        

        currentNode=currentNode.next;       
      }
      
     
      //insert item before first node
      if(currentNode==first) {     
        newNode.next=first;       
        first.back=newNode;       
        first=newNode;        
        count++;       
      }
      
      
      
      //insert item after last node      
      else if(currentNode==null) {       
        previousNode.next=newNode;       
        newNode.back=previousNode;       
        last=newNode;       
        count++;       
      }
      
      
      //Insert in middle 
      else {       
        previousNode.next=newNode;       
        newNode.back=previousNode;        
        newNode.next=currentNode;        
        currentNode.back=newNode;        
        count++;        
      }      
    }        
  }
 
  
//Deletes an item from the list  
  public void deleteNode(T deleteItem) {    
    DoubleLinkedListNode<T> currentNode=first;    
    DoubleLinkedListNode<T> previousNode=null;    
    boolean foundItem=false;   
    if(first.info.toString()==deleteItem.toString())     {  
      
      if(first==last)        {      
        
        first=last=null;       
        count=0;       
      }      
      
      else {  
        
        first=first.next;       
        first.back=null;      
        count--;       
      }      
    }    
    else {  
      
      while(currentNode!=null) {
        
        if(currentNode.info.equals(deleteItem)) {   
          
          foundItem=true;          
          break;         
        }        
        previousNode=currentNode;       
        currentNode=currentNode.next;      
      } 
      
      if(currentNode!=null)   {     
        if(currentNode==last){          
          last=last.back;         
          last.next=null;          
          count--;         
        }       
        else {        
          currentNode.next.back=previousNode;          
          previousNode.next=currentNode.next;         
          count--;         
        }        
      }     
      else {        
        System.out.println(deleteItem.toString()+" does not exist in the list");       
      }      
    }   
  }
  
  
//Returns all elements as String 
  public String recursiveString() {    
    return recursiveString(first);  
  } 
  
  
//Recursive returns String
  private String recursiveString(DoubleLinkedListNode<T> head)  
  { 
    if(head==null) 
      return "-[tail]"; 
    else 
      return head.info.toString()+" "+recursiveString(head.next);
  }
  
  
//Returns String in reverse order 
  public String backwardsString() {  
    String tempString="[tail]-";  
    DoubleLinkedListNode<T> tempNode=last;       
    while(tempNode!=null)    {      
      tempString+=tempNode.info.toString()+" ";     
      tempNode=tempNode.back;  
    }
    
    return tempString+"-[head]";
    
  }
  
//Returns String in reverse order 
  public String recursiveBackString() {  
    return "[tail]-"+recursiveBackString(last);    
  }
 
//Recursive returns String reverse order
  private String recursiveBackString(DoubleLinkedListNode<T> tail) {   
    if(tail==null)     
    {    
      return "";   
    }
    else
      return tail.info.toString()+" "+recursiveBackString(tail.back);  
  }
  
//Copy list
  public void copy(DoubleLinkedList<T> otherList) {  
    DoubleLinkedListNode<T> newNode;
    DoubleLinkedListNode<T> currentNode=otherList.first;     
    if(otherList.first==null) 
    { 
      this.first=this.last=null;
      count=0;
    }
    else 
    
      this.first=this.last=null;
      this.count=otherList.count;      
      this.first=new DoubleLinkedListNode();     
      this.first.info=currentNode.info;      
      this.first.next=null;      
      this.last=this.first;      
      currentNode=currentNode.next;     
      while(currentNode!=null)        {       
        newNode=new DoubleLinkedListNode();
        newNode.info=currentNode.info;        
        newNode.back=this.last;        
        this.last.next=newNode;       
        this.last=newNode;        
        currentNode=currentNode.next;        
      }      
    }           
  
 
//Copy list backwards
  public void reversedCopy(DoubleLinkedList<T> otherList)    
  {    
    DoubleLinkedListNode<T> newNode;    
    DoubleLinkedListNode<T> currentNode=otherList.last;          
    if(otherList.first==null)      {     
      this.first=this.last=null;      
      count=0;      
    }    
    else      
    {      
      this.first=this.last=null;      
      this.count=otherList.count;      
      this.first=new DoubleLinkedListNode();     
      this.first.info=currentNode.info;    
      this.first.next=null;    
      this.last=this.first;    
      currentNode=currentNode.back;     
      while(currentNode!=null)      
      {       
        newNode=new DoubleLinkedListNode();       
        newNode.info=currentNode.info;        
        newNode.back=this.last;       
        this.last.next=newNode;       
        this.last=newNode;      
        currentNode=currentNode.back;     
      }
      
    }
    
  }
  
//Returns all elements as a string  
  public String toString()
    
  {   
    String tempString="[head]-";    
    DoubleLinkedListNode<T> tempNode=first;  
    while(tempNode!=null) {    
      tempString+=tempNode.info+" ";     
      tempNode=tempNode.next;    
    }     
    return tempString+"-[tail]";   
  }
}