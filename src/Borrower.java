import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Borrower {
	/***
    Search for books using keyword search on titles, authors and subjects. The result is a list of books that 
    match the search together with the number of copies that are in and out.
    
    Check his/her account. The system will display the items the borrower has currently borrowed and not yet 
    returned, any outstanding fines and the hold requests that have been placed by the borrower.
    
    Place a hold request for a book that is out. When the item is returned, the system sends an email to the 
    borrower and informs the library clerk to keep the book out of the shelves.
    
    Pay a fine.

***/
	    private int Bid;
	    private int Password;
	    private String Name;
	    private String Address;
	    private int Phone;
	    private String Email;
	    private int SinOrStNo;
	    private int ExpiryDate;
	    private String Type;
	    private List ListOfBooks= new ArrayList();
	    List<Map.Entry<String,Integer>> Book= new ArrayList<>();
	    

	    public Borrower (int bid, int password, String name, String address, int phone, String email, int sinOrStNo, int expiryDate, String type){
	        Bid= bid;
	        Password= password;
	        Name= name;
	        Address= address;
	        Phone= phone;
	        Email= email;
	        SinOrStNo= sinOrStNo;
	        ExpiryDate= expiryDate;
	        Type= type;
	    }
	    
	    public void getNumberOfBooks(int bid){}
	    
	    public List search(String keyword){
	    	
			return ListOfBooks;
			}
	    
	    

	}