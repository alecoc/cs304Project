
public class Book<name, copies> { 
	/***
	 * Creation of a Book tuple, containing the name and the number of copies of a book
	 */
	
  public String name; 
  public int copies; 
  public int callNumber;
  public int status; //0 is on-hold, 1 is in, 2 is out.  Could go about it that way.
  
  public Book(String name, int copies) { 
    this.name = name; 
    this.copies = copies; 
  } 
} 