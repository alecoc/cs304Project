import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Librarian {
	/***
    DONE: Adds a new book or new copy of an existing book to the library. The librarian provides the information for 
    the new book, and the system adds it to the library.
    
    Done (Without Table Use): Generate a report with all the books that have been checked out. For each book the report shows the date 
    it was checked out and the due date. 
    
    The system flags the items that are overdue. The items are ordered by the book call number.  If a subject 
    is provided the report lists only books related to that subject, otherwise all the books that are out are 
    listed by the report.
    
    Generate a report with the most popular items in a given year.  The librarian provides a year and a 
    number n. The system lists out the top n books that where borrowed the most times during that year. 
    The books are ordered by the number of times they were borrowed.
    
***/
	
	// as a not list of all books is not final, just a place holder for now.
	public List<Book> ListOfBooks = new ArrayList<Book>(); 
	public class Report <book, dateOut, dateDue> {
		// Creation of a Report Since it is local to Librarian it is not a separate class
		public Book book;
		public Date dateOut;
		public Date dateDue;
		
		}
	}
	
	public Librarian (Borrower b) {
		// Maybe make Librarian like borrower
	}
 
			
	public List<Report> BookReport() {
		List<Report> finalReport = new ArrayList<Report>();
		for (Book b : ListOfBooks) { // these books are from the borrowing table
			if (b.status == 2) {
				finalReport.add(new Report(bid, outDate, inDate)) 
			}
	}
		return finalReport;
	}
	
	public 
}
