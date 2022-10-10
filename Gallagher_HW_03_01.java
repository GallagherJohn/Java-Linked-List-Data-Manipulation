//John Gallagher
//COSC_237
//HW_3_1
//Unordered Linked lists 

package COSC_237_HW_3_1; 

public class UnorderedLinkedListInt extends LinkedListIntClass {

public UnorderedLinkedListInt() {
  super(); 
 
}


//Search
public boolean search(int searchItem) {
  LinkedListNode current;
    current = first;
    while (current != null) {
    
      if (current.info == (searchItem)){
      return true;
      }
      else {
      current = current.link;
      }}
return false;
}


//Create new Node and insert First
public void insertFirst(int newItem) {
  LinkedListNode newNode; 
  newNode = new LinkedListNode(newItem, first);
  first = newNode;
  if (last == null)
    last = newNode;
  count++;
}


//Create new Node and insert last 
public void insertLast(int newItem) {
  LinkedListNode   newNode; 
  newNode = new LinkedListNode(newItem, null);
  if (first == null) {
    first = newNode;
    last = newNode;
  }
  else {
    last.link = newNode;
    last = newNode;
  }
  count++;
}


public void deleteNode(int deleteItem) {
  LinkedListNode current; 
  LinkedListNode trailCurrent; 
  boolean found;
//Case 1? the list is empty
  if ( first == null)
    System.out.println("Cannot delete from an empty list.");
  else {
//Case 2: the node to be deleted is first
    if (first.info ==(deleteItem)) {
      first = first.link;
      if (first == null) 
        last = null;
      count = count - 1; 
    }
    else { 
      found = false;
      trailCurrent = first; 
      current = first.link; 
      while (current != null && !found) {
        if (current.info == (deleteItem))
          found = true;
        else {
          trailCurrent = current;
          current = current.link;
        }
      }
//Case 3? if found, delete the node
      if (found) {
        count = count - 1; 
        trailCurrent.link = current.link;
        if (last == current) 
          last = trailCurrent;
      }
      else
        System.out.println("Item to be deleted is not in the list.");
    }
  }
}


//Merge 1
public void merge(  UnorderedLinkedListInt list2 ) {
  UnorderedLinkedListInt list1 = this;
  
  UnorderedLinkedListInt.LinkedListNode node = list1.first;
  do {
    
    list2.insertLast(node.info);
    list1.first = list1.first.link; 
    
    node = node.link; 
  } while (node != null);
  
  
  
  
  
  
  
}

//Merge 2
public UnorderedLinkedListInt merge2 (UnorderedLinkedListInt list2 ) {
  UnorderedLinkedListInt list3 = new UnorderedLinkedListInt();
  UnorderedLinkedListInt list1 = this;
  while (list1.first != null) {
    list3.insertLast(list1.first.info);
    list1.first = list1.first.link; 
  }
  while (list2.first != null) {
    list3.insertFirst(list2.first.info);
    list2.first = list2.first.link;
  }
  return list3;
}
//Split 
public void split(UnorderedLinkedListInt list3, UnorderedLinkedListInt list1, int key) {
  UnorderedLinkedListInt list2 = this;
  
  UnorderedLinkedListInt.LinkedListNode node = list2.first;
  
  do {
    if (node.info > key)
      list3.insertFirst(node.info);
    else
      list1.insertFirst(node.info);
    node = node.link;
  } while (node != null);
}
}



