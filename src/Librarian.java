import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Librarian {
	/***
    DONE: Adds a new book or new copy of an existing book to the library. The librarian provides the information for 
    the new book, and the system adds it to the library.
    
    Generate a report with all the books that have been checked out. For each book the report shows the date 
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
		
		public Report (Book b, Date out, Date due) {
			this.book = b;
			this.dateOut = out;
			this.dateDue = due;
		}
	}
	
	public Librarian (Borrower b) {
		// Maybe make Librarian like borrower
	}
 
	public void addBook (Book b) {
		// b is the book to add
		// book is the name of each book that is compared to b to make sure you do not add redundant books
		// Adds a book to the list if books
		int updateDone = 0;
		for (Book book : ListOfBooks) {
			if (book == b) {
				book = new Book( book.name, book.copies + 1);
				updateDone += 1;
			}
		}	
		if (updateDone == 0) {
			ListOfBooks.add(b);
		}
	}  // if update is not 0 or 1 you would have a problem because that would mean there are redundant books
	   // which would be a pre-existing error. 	
			
	public List<Report> BookReport() {
		List<Report> finalReport = new ArrayList<Report>();
		for (Book b : ListOfBooks) {
			if (b.status == 2) {
				// need to finish what to do when book is found
			}
	}
		return finalReport;
	}
}
