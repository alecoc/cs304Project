
public class Book<name, copies> { 
	/***
	 * Creation of a Book tuple, containing the name and the number of copies of a book
	 */
	
  public final String name; 
  public final int copies; 
  public Book(String name, int copies) { 
    this.name = name; 
    this.copies = copies; 
  } 
} 