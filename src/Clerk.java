
public class Clerk {
	/***
    Check-out items borrowed by a borrower. 
    
    To borrow items, borrowers provide their card number and a list with the call numbers of the items they 
    want to check out. The system determines if the borrower's account is valid and if the library items are available for
    borrowing. 
    
    Then it creates one or more borrowing records and prints a note with the items and their due day 
    (which is giver to the borrower). 
    
    Processes a return. When  an item is returned, the clerk records the return by providing the item's 
    catalogue number. 
    
    The system determines the borrower who had borrowed the item and records that the the 
    item is "in".  If the item is overdue, a fine is assessed for the borrower.  If there is a hold request 
    for this item by another borrower, the item is registered as "on hold" and a message is send to the 
    borrower who made the hold request.
    
    Checks overdue items. The system displays a list of the items that are overdue and the borrowers who 
    have checked them out.  The clerk may decide to send an email messages to any of  them (or to all of them). 

***/
	
	public void addBorrower(int bid, int password, String name, String address, int phone, String emailAddress, int sinOrStNo, int expiryDate, String type){
		
	}
	
	public void checkoutItems(Borrower borrower){
		
	}

}
