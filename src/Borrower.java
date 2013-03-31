import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Borrower {
	/***
    DONE: Search for books using keyword search on titles, authors and subjects. The result is a list of books that 
    match the search together with the number of copies that are in and out.
    
    DONE IN GUI: Check his/her account. The system will display the items the borrower has currently borrowed and not yet 
    returned, any outstanding fines and the hold requests that have been placed by the borrower.
    
    DONE: Place a hold request for a book that is out. When the item is returned, the system sends an email to the 
    borrower and informs the library clerk to keep the book out of the shelves.
    
    Pay a fine.

***/
	    public int Bid;
	    public int Password;
	    public String Name;
	    public String Address;
	    public int Phone;
	    public String Email;
	    public int SinOrStNo;
	    public int ExpiryDate;
	    public String Type;
	    public int accumulatedFines;
	    public List<Book> ListOfBooks= new ArrayList<Book>(); //list of books throughout the library
	    public List<Book> BorrowerBooks= new ArrayList<Book>(); //list of books in possession of the borrower
	    

	    public Borrower (int bid, int password, String name, String address, int phone, String email, int sinOrStNo, int expiryDate, String type, List<Book> borrowerBooks, int fineTotal){
	        Bid= bid;
	        Password= password;
	        Name= name;
	        Address= address;
	        Phone= phone;
	        Email= email;
	        SinOrStNo= sinOrStNo;
	        ExpiryDate= expiryDate;
	        Type= type;
	        BorrowerBooks= borrowerBooks;
	        accumulatedFines= fineTotal;
	    }
	    
	    public void getNumberOfBooks(int bid){}
	    
	    public List<Book> search(String keyword){
	    	//conduct a search on all book titles, mainAuthors, and subjects using the keyword
	    	List<Book> searchResults = new ArrayList<Book>(); //this is the output list of books
	    	List<Book> weededBookList = bookStatus(searchResults);
			return weededBookList;
			}
	    
	    public List<Book> bookStatus(List<Book> searchResults){
	    	List<Book> bookList = searchResults;
	    	List<Book> subsetOfBooks = new ArrayList<Book>();
	    	
	    	for (Book b : bookList){
	    		if(b.status==1){
	    			subsetOfBooks.add(b);
	    		}
	    	}
	    	
	    	return subsetOfBooks;
	    }
	    
	    public List<Book> checkAccStatus(Borrower borrower){
	    	List<Book> bookList = BorrowerBooks;
	    	
	    	return bookList; //needs to return fines, hold requests, as well
	    }
	    
	    public void placeHoldRequest(Book book, Borrower borrower){
	    	book.status=0;
	    	sendEmail(borrower, book);
	    }
	    
	    public void payFine(Borrower borrower){
	    	borrower.accumulatedFines= 0;
	    }
	    
	    public void sendEmail(Borrower borrower, Book book){
	    	String borrowerEmail= borrower.Email;
	    	//send an email to the borrower about the book
	    }

	}