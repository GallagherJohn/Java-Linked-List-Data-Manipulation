//John Gallagher
//COSC_237
//HW_3_1
//Unordered Linked lists merge

package COSC_237_HW_3_1; 
import java.util.*;
public class Merge1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    UnorderedLinkedListInt list1 = new UnorderedLinkedListInt();
    UnorderedLinkedListInt list2 = new UnorderedLinkedListInt(); 
    UnorderedLinkedListInt list3 = new UnorderedLinkedListInt(); 
    int num;
    System.out.println("Enter integers (999 to stop)");
    try {
      num = input.nextInt();//valid??
      while (num != 999) {
        list1.insertLast((Integer) num);
        num = input.nextInt();//valid??
      }
      
      
      System.out.println("Enter integers for the second list(999 to stop)");
      num = input.nextInt();
      while (num != 999) {
        list2.insertLast((Integer) num);
        num = input.nextInt();
      } 
      
      
      System.out.print("\nThe first list is: ");
      list1.print();
      System.out.print("\nThe length of the first list is: " + list1.length());
      if (!list1.isEmptyList()) {
        System.out.print("\nFirst element of list1: " + list1.front());
        System.out.println("\nLast element of list1: " + list1.back());
      }
      
      System.out.print("\nThe second list is: ");
      list2.print();
      System.out.print("\nThe length of the second list is: " + list2.length());
      if (!list2.isEmptyList()) {
        System.out.print("\nFirst element of list2: " + list2.front());
        System.out.println("\nLast element of list 2 : " + list2.back());
      }
      
      list1.merge(list2); 
      System.out.print("\nThe list merged with the (public void merge(UnorderedLinkedListInt list2))" +
                       "function: \n");  
      list2.print();  
      
      System.out.println("Enter key for split: ");
      num = input.nextInt();
      list2.split(list3, list1, num);
      System.out.print("\nThe first list after split is: ");
      list1.print();
      System.out.print("\nThe second list after split is: ");
      list3.print();
      System.out.println();
      
      
      
      
    } catch (InputMismatchException e) {
      System.out.println("Please only enter integer values. \n" 
                           + "Restart program to try again"); 
      
      
      
    }}
}
