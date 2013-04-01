
// We need to import the java.sql package to use JDBC
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// for reading from the command line
import java.io.*;

// for the login window
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


/*
 * This class implements a graphical login window and a simple text
 * interface for interacting with the branch table 
 */ 
public class GUI implements ActionListener
{
	public List<Book> bookList = new ArrayList<Book>();
	// command line reader 
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	private Connection con;

	// user is allowed 3 login attempts
	public int loginAttempts = 0;

	// components of the login window
	public JTextField usernameField;
	public JPasswordField passwordField;
	public JTextField searchField;
	public JFrame mainFrame;
	private JTextField nameField;
	private JTextField passwirdField; //I really wanted to call this passwordField, so I spelled it retardedly
	private JTextField IDField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField sinStudentField;
	private JTextField expiryField;
	private JTextField typeField;
	private JLabel lblId;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JLabel lblSinstudent;
	private JLabel lblExpiryDate;
	private JLabel lblType;
	private JButton btnAddBorrower;
	private JLabel lblCheckAccount;
	private JTextField accountID;
	private JLabel lblId_1;
	private JButton btnCheckAccount;
	private JLabel lblLibraryBorrowerGraphical;
	private JLabel lblPlaceHoldRequest;
	private JTextField holdBookName;
	private JLabel lblBookName;
	private JButton btnPlaceHold;
	private JLabel lblPayOutstandingFines;
	private JTextField finesAmount;
	private JLabel lblAmount;
	private JButton btnPayFines;
	
	private JTextArea finesBorrowerID;
	private JLabel lblBorrowerid;
	private JLabel lblBorrowBooks;
	private JTextField BorrowBookID;
	private JTextField Book1;
	private JTextField Book2;
	private JTextField Book3;
	private JLabel lblBorrowerid_1;
	private JLabel lblBookTitle;
	private JLabel lblBookTitle_1;
	private JLabel lblBookTitle_2;
	private JButton btnNewButton;
	
	// Labels for adding books
	private JButton bAddBook;
	private JLabel bCallNumber;
	private JLabel bIsbn;
	private JLabel bTitle;
	private JLabel bMainAuthor;
	private JLabel bPublisher;
	private JLabel bSubject;
	private JLabel bYear;
	private JTextField bCallNumberField;
	private JTextField bIsbnField;
	private JTextField bTitleField;
	private JTextField bMainAuthorField;
	private JTextField bPublisherField;
	private JTextField bSubjectField;
	private JTextField bYearField;




	/*
	 * constructs login window and loads JDBC driver
	 */ 
	public GUI()
	{
		mainFrame = new JFrame("Borrower UI");
		String username = "ora_e4q7";
		String password = "a23056096";
		connect(username, password);

		JLabel searchLabel = new JLabel("Keyword Search");

		usernameField = new JTextField(10);
		passwordField = new JPasswordField(10);
		passwordField.setEchoChar('*');

		searchField = new JTextField(30);

		//------------------------------------------------------------------------------		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Statement stmt = null;
				try {
					stmt = con.createStatement();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					ResultSet rs = stmt.executeQuery("SELECT title,mainAuthor,subject,callNumber FROM Book WHERE title LIKE '%" 
							+ searchField.getText() + "%' OR mainAuthor LIKE '%" + searchField.getText() + "%' OR subject LIKE '%" 
							+ searchField.getText() + "%'");
					
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Statement stmt = null;
				try {
					stmt = con.createStatement();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					ResultSet rs = stmt.executeQuery("SELECT title,mainAuthor,subject,callNumber FROM Book WHERE title LIKE '%" 
							+ searchField.getText() + "%' OR mainAuthor LIKE '%" + searchField.getText() + "%' OR subject LIKE '%" 
							+ searchField.getText() + "%'");

					while ( rs.next() ) {
						int callNumber = rs.getInt("callNumber");
						System.out.println(callNumber);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		//--------------------------------------------------------------------------------		

					while ( rs.next() ) {
						int callNumber = rs.getInt("callNumber");
						System.out.println(callNumber);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		//--------------------------------------------------------------------------------		

		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		mainFrame.setContentPane(contentPane);


		// layout components using the GridBag layout manager

		GridBagLayout gb = new GridBagLayout();
		gb.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gb.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gb.columnWeights = new double[]{1.0, 1.0, 0.0};
		GridBagConstraints c = new GridBagConstraints();

		contentPane.setLayout(gb);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// place the search label
		c.gridwidth = GridBagConstraints.RELATIVE;
		c.insets = new Insets(0, 0, 0, 0);

		lblLibraryBorrowerGraphical = new JLabel("Library Borrower Graphical User Interface");
		GridBagConstraints gbc_lblLibraryBorrowerGraphical = new GridBagConstraints();
		gbc_lblLibraryBorrowerGraphical.insets = new Insets(0, 0, 5, 5);
		gbc_lblLibraryBorrowerGraphical.gridx = 1;
		gbc_lblLibraryBorrowerGraphical.gridy = 0;
		contentPane.add(lblLibraryBorrowerGraphical, gbc_lblLibraryBorrowerGraphical);
		gb.setConstraints(searchLabel, c);
		GridBagConstraints gbc_searchLabel = new GridBagConstraints();
		gbc_searchLabel.insets = new Insets(0, 0, 5, 5);
		gbc_searchLabel.gridx = 0;
		gbc_searchLabel.gridy = 1;
		contentPane.add(searchLabel, gbc_searchLabel);

		// place the text field for the search
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.insets = new Insets(0, 0, 0, 0);
		gb.setConstraints(searchField, c);
		GridBagConstraints gbc_searchField = new GridBagConstraints();
		gbc_searchField.insets = new Insets(0, 0, 5, 5);
		gbc_searchField.gridx = 1;
		gbc_searchField.gridy = 1;
		contentPane.add(searchField, gbc_searchField);

		// place the search button
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.insets = new Insets(5, 5, 5, 5);
		c.anchor = GridBagConstraints.CENTER;
		gb.setConstraints(searchButton, c);
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.insets = new Insets(0, 0, 5, 0);
		gbc_searchButton.gridx = 2;
		gbc_searchButton.gridy = 1;
		contentPane.add(searchButton, gbc_searchButton);

		JLabel lblAddborrower = new JLabel("AddBorrower");
		GridBagConstraints gbc_lblAddborrower = new GridBagConstraints();
		gbc_lblAddborrower.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddborrower.anchor = GridBagConstraints.EAST;
		gbc_lblAddborrower.gridx = 0;
		gbc_lblAddborrower.gridy = 2;
		contentPane.add(lblAddborrower, gbc_lblAddborrower);

		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 3;
		contentPane.add(lblName, gbc_lblName);

		nameField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		contentPane.add(nameField, gbc_textField);
		nameField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 4;
		contentPane.add(lblPassword, gbc_lblPassword);

		passwirdField = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		contentPane.add(passwirdField, gbc_textField_1);
		GridBagConstraints gbc_Book1 = new GridBagConstraints();
		gbc_Book1.insets = new Insets(0, 0, 5, 5);
		gbc_Book1.fill = GridBagConstraints.HORIZONTAL;
		gbc_Book1.gridx = 1;
		gbc_Book1.gridy = 4;
		contentPane.add(passwirdField, gbc_Book1);
		passwirdField.setColumns(10);

		lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 5;
		contentPane.add(lblId, gbc_lblId);

		IDField = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 5;
		contentPane.add(IDField, gbc_textField_2);
		GridBagConstraints gbc_Book2 = new GridBagConstraints();
		gbc_Book2.insets = new Insets(0, 0, 5, 5);
		gbc_Book2.fill = GridBagConstraints.HORIZONTAL;
		gbc_Book2.gridx = 1;
		gbc_Book2.gridy = 5;
		contentPane.add(IDField, gbc_Book2);
		IDField.setColumns(10);

		lblAddress = new JLabel("Address");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 6;
		contentPane.add(lblAddress, gbc_lblAddress);

		addressField = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 6;
		contentPane.add(addressField, gbc_textField_3);
		GridBagConstraints gbc_Book3 = new GridBagConstraints();
		gbc_Book3.insets = new Insets(0, 0, 5, 5);
		gbc_Book3.fill = GridBagConstraints.HORIZONTAL;
		gbc_Book3.gridx = 1;
		gbc_Book3.gridy = 6;
		contentPane.add(addressField, gbc_Book3);
		addressField.setColumns(10);

		lblPhone = new JLabel("Phone");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.anchor = GridBagConstraints.EAST;
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 7;
		contentPane.add(lblPhone, gbc_lblPhone);

		phoneField = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 7;
		contentPane.add(phoneField, gbc_textField_4);
		phoneField.setColumns(10);

		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 8;
		contentPane.add(lblEmail, gbc_lblEmail);

		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 8;
		contentPane.add(emailField, gbc_emailField);
		emailField.setColumns(10);

		lblSinstudent = new JLabel("Sin/Student#");
		GridBagConstraints gbc_lblSinstudent = new GridBagConstraints();
		gbc_lblSinstudent.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinstudent.anchor = GridBagConstraints.EAST;
		gbc_lblSinstudent.gridx = 0;
		gbc_lblSinstudent.gridy = 9;
		contentPane.add(lblSinstudent, gbc_lblSinstudent);

		sinStudentField = new JTextField();
		GridBagConstraints gbc_sinStudentField = new GridBagConstraints();
		gbc_sinStudentField.insets = new Insets(0, 0, 5, 5);
		gbc_sinStudentField.fill = GridBagConstraints.HORIZONTAL;
		gbc_sinStudentField.gridx = 1;
		gbc_sinStudentField.gridy = 9;
		contentPane.add(sinStudentField, gbc_sinStudentField);
		sinStudentField.setColumns(10);

		lblExpiryDate = new JLabel("Expiry Date");
		GridBagConstraints gbc_lblExpiryDate = new GridBagConstraints();
		gbc_lblExpiryDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblExpiryDate.anchor = GridBagConstraints.EAST;
		gbc_lblExpiryDate.gridx = 0;
		gbc_lblExpiryDate.gridy = 10;
		contentPane.add(lblExpiryDate, gbc_lblExpiryDate);

		expiryField = new JTextField();
		GridBagConstraints gbc_expiryField = new GridBagConstraints();
		gbc_expiryField.insets = new Insets(0, 0, 5, 5);
		gbc_expiryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_expiryField.gridx = 1;
		gbc_expiryField.gridy = 10;
		contentPane.add(expiryField, gbc_expiryField);
		expiryField.setColumns(10);

		lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 11;
		contentPane.add(lblType, gbc_lblType);

		typeField = new JTextField();
		GridBagConstraints gbc_typeField = new GridBagConstraints();
		gbc_typeField.insets = new Insets(0, 0, 5, 5);
		gbc_typeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeField.gridx = 1;
		gbc_typeField.gridy = 11;
		contentPane.add(typeField, gbc_typeField);
		typeField.setColumns(10);

		//---------------------------------------------------------------------------		

		btnAddBorrower = new JButton("Add Borrower");
		btnAddBorrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Statement stmt = null;
				try {
					stmt = con.createStatement();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				int bid = Integer.parseInt(IDField.getText());
				int password = Integer.parseInt(passwirdField.getText());
				String name = nameField.getText();
				String address = addressField.getText();
				int phone = Integer.parseInt(phoneField.getText());
				String email = emailField.getText();
				int sinStudent = Integer.parseInt(sinStudentField.getText());
				int expiry = Integer.parseInt(expiryField.getText());
				String type = typeField.getText();

				try {
					stmt.executeUpdate("INSERT INTO Borrower VALUES (" + bid + "," + password + ",'" + name + "','" + address + "'," + phone + ",'" + email + "'," + sinStudent + "," + expiry + ",'" + type + "')");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		//------------------------------------------------------------------------------		

		GridBagConstraints gbc_btnAddBorrower = new GridBagConstraints();
		gbc_btnAddBorrower.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddBorrower.gridx = 2;
		gbc_btnAddBorrower.gridy = 11;
		contentPane.add(btnAddBorrower, gbc_btnAddBorrower);

		lblCheckAccount = new JLabel("Check Account");
		GridBagConstraints gbc_lblCheckAccount = new GridBagConstraints();
		gbc_lblCheckAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckAccount.gridx = 0;
		gbc_lblCheckAccount.gridy = 12;
		contentPane.add(lblCheckAccount, gbc_lblCheckAccount);

		lblId_1 = new JLabel("             ID");
		GridBagConstraints gbc_lblId_1 = new GridBagConstraints();
		gbc_lblId_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblId_1.anchor = GridBagConstraints.EAST;
		gbc_lblId_1.gridx = 0;
		gbc_lblId_1.gridy = 13;
		contentPane.add(lblId_1, gbc_lblId_1);

		accountID = new JTextField();
		GridBagConstraints gbc_accountID = new GridBagConstraints();
		gbc_accountID.insets = new Insets(0, 0, 5, 5);
		gbc_accountID.fill = GridBagConstraints.HORIZONTAL;
		gbc_accountID.gridx = 1;
		gbc_accountID.gridy = 13;
		contentPane.add(accountID, gbc_accountID);
		accountID.setColumns(10);

		//---------------------------------------------------------------------
		btnCheckAccount = new JButton("Check Account");
		btnCheckAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Statement stmt = null;
				String bid = accountID.getText();
				try {
					stmt = con.createStatement();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					ResultSet rs = stmt.executeQuery("SELECT bid,password,name,address,phone,emailAddress,sinOrStNo,expiryDate,type FROM Borrower WHERE bid= " + bid + "");

					while ( rs.next() ) {
						int ID = rs.getInt("bid");
						int password = rs.getInt("password");
						String name = rs.getString("name");
						String address = rs.getString("address");
						int phone = rs.getInt("phone");
						String emailAddress = rs.getString("emailAddress");
						int sinOrStNo = rs.getInt("sinOrStNo");
						int expiryDate = rs.getInt("expiryDate");
						String type = rs.getString("type");

						System.out.println("ID provided: " + ID);
						System.out.println("password: " + password);
						System.out.println("name: " + name);
						System.out.println("address: " + address);
						System.out.println("phone: " + phone);
						System.out.println("emailAddress: " + emailAddress);
						System.out.println("sinOrStNo: " + sinOrStNo);
						System.out.println("expiryDate: " + expiryDate);
						System.out.println("type: " + type);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		//--------------------------------------------------------------------------		

		GridBagConstraints gbc_btnCheckAccount = new GridBagConstraints();
		gbc_btnCheckAccount.insets = new Insets(0, 0, 5, 0);
		gbc_btnCheckAccount.gridx = 2;
		gbc_btnCheckAccount.gridy = 13;
		contentPane.add(btnCheckAccount, gbc_btnCheckAccount);

		lblPlaceHoldRequest = new JLabel("Place Hold Request");
		GridBagConstraints gbc_lblPlaceHoldRequest = new GridBagConstraints();
		gbc_lblPlaceHoldRequest.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaceHoldRequest.gridx = 0;
		gbc_lblPlaceHoldRequest.gridy = 14;
		contentPane.add(lblPlaceHoldRequest, gbc_lblPlaceHoldRequest);

		lblBookName = new JLabel("Book Name");
		GridBagConstraints gbc_lblBookName = new GridBagConstraints();
		gbc_lblBookName.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookName.anchor = GridBagConstraints.EAST;
		gbc_lblBookName.gridx = 0;
		gbc_lblBookName.gridy = 15;
		contentPane.add(lblBookName, gbc_lblBookName);

		holdBookName = new JTextField();
		GridBagConstraints gbc_holdBookName = new GridBagConstraints();
		gbc_holdBookName.insets = new Insets(0, 0, 5, 5);
		gbc_holdBookName.fill = GridBagConstraints.HORIZONTAL;
		gbc_holdBookName.gridx = 1;
		gbc_holdBookName.gridy = 15;
		contentPane.add(holdBookName, gbc_holdBookName);
		holdBookName.setColumns(10);

		//-------------------------------------------------------------------		
		btnPlaceHold = new JButton("Place Hold");
		btnPlaceHold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (searchField.getText()!=""){ //searching for a book and retrieving the call number
					Statement stmt = null;
					Statement stmt2 = null;
					int callNumber = 5;
					try {
						stmt = con.createStatement();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						ResultSet rs = stmt.executeQuery("SELECT title,mainAuthor,subject,callNumber FROM Book WHERE title LIKE '%" 
								+ searchField.getText() + "%' OR mainAuthor LIKE '%" + searchField.getText() + "%' OR subject LIKE '%" 
								+ searchField.getText() + "%'");

						while ( rs.next() ) {
							callNumber = rs.getInt("callNumber");

						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					//at this point, call number has been found for the book, now we must change the status to on-hold

					try {
						stmt2 = con.createStatement();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					try {
						stmt2.executeQuery("UPDATE BookCopy SET status=0 WHERE callNumber= " + callNumber + "");

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		//--------------------------------------------------------------------		

		GridBagConstraints gbc_btnPlaceHold = new GridBagConstraints();
		gbc_btnPlaceHold.insets = new Insets(0, 0, 5, 0);
		gbc_btnPlaceHold.gridx = 2;
		gbc_btnPlaceHold.gridy = 15;
		contentPane.add(btnPlaceHold, gbc_btnPlaceHold);

		lblPayOutstandingFines = new JLabel("Pay Outstanding Fines");
		GridBagConstraints gbc_lblPayOutstandingFines = new GridBagConstraints();
		gbc_lblPayOutstandingFines.insets = new Insets(0, 0, 5, 5);
		gbc_lblPayOutstandingFines.gridx = 0;
		gbc_lblPayOutstandingFines.gridy = 16;
		contentPane.add(lblPayOutstandingFines, gbc_lblPayOutstandingFines);

		lblAmount = new JLabel("Amount");
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.anchor = GridBagConstraints.EAST;
		gbc_lblAmount.gridx = 0;
		gbc_lblAmount.gridy = 17;
		contentPane.add(lblAmount, gbc_lblAmount);

		finesAmount = new JTextField();
		GridBagConstraints gbc_finesAmount = new GridBagConstraints();
		gbc_finesAmount.insets = new Insets(0, 0, 5, 5);
		gbc_finesAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_finesAmount.gridx = 1;
		gbc_finesAmount.gridy = 17;
		contentPane.add(finesAmount, gbc_finesAmount);
		finesAmount.setColumns(10);

		btnPayFines = new JButton("Pay Fine");

		//----------------------------------------------------------------------------------		
		btnPayFines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1. get the borrower ID borid, and use that to access the fine table and get the amount
				try {
					Statement stmt = null;
					Statement stmt2 = null;
					int remainingAmount = 0;
					String borrowerID = finesBorrowerID.getText();
					int quantity;
					
					stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT fid,borid,amount FROM Fine WHERE borid=" + borrowerID + "");
					System.out.println(borrowerID);
					
					while ( rs.next() ) {
						quantity = rs.getInt("amount");
						System.out.println("Fine amount retrieved: " + quantity);
						
						String amountPaid = finesAmount.getText();
						int amountPaidInt = Integer.parseInt(amountPaid);
						System.out.println("amountpaid: " + amountPaidInt);
						
						remainingAmount = quantity-amountPaidInt;
						System.out.println("remainingAmount: " + remainingAmount);
					}
					
					stmt2 = con.createStatement();
					System.out.println("remainingAmount: " + remainingAmount);
					stmt2.executeUpdate("UPDATE Fine SET amount=" + remainingAmount + " WHERE borid= " + borrowerID + "");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		//---------------------------------------------------------------------------	

		GridBagConstraints gbc_btnPayFines = new GridBagConstraints();
		gbc_btnPayFines.insets = new Insets(0, 0, 5, 0);
		gbc_btnPayFines.gridx = 2;
		gbc_btnPayFines.gridy = 17;
		contentPane.add(btnPayFines, gbc_btnPayFines);

		lblBorrowerid = new JLabel("                BorrowerID");
		GridBagConstraints gbc_lblBorrowerid = new GridBagConstraints();
		gbc_lblBorrowerid.insets = new Insets(0, 0, 0, 5);
		gbc_lblBorrowerid.gridx = 0;
		gbc_lblBorrowerid.gridy = 18;
		contentPane.add(lblBorrowerid, gbc_lblBorrowerid);

		finesBorrowerID = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 18;
		contentPane.add(finesBorrowerID, gbc_textArea);

		//---------------------------------------------------------------------------	
		
		bCallNumber = new JLabel("Call Number");
		GridBagConstraints gbc_bCallNumber = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 3;
		contentPane.add(bCallNumber, gbc_bCallNumber);

		bCallNumberField = new JTextField();
		GridBagConstraints gbc_text = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		contentPane.add(bCallNumberField, gbc_text);
		nameField.setColumns(10);

		bIsbn = new JLabel("ISBN");
		GridBagConstraints gbc_bIsbn = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 4;
		contentPane.add(bIsbn, gbc_bIsbn);

		bIsbnField = new JTextField();
		GridBagConstraints gbc_text_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		contentPane.add(bIsbnField, gbc_text_1);
		passwirdField.setColumns(10);

		bTitle = new JLabel("Title");
		GridBagConstraints gbc_bTitle = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 5;
		contentPane.add(bTitle, gbc_bTitle);

		bTitleField = new JTextField();
		GridBagConstraints gbc_text_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 5;
		contentPane.add(bTitleField, gbc_text_2);
		IDField.setColumns(10);
		
		bMainAuthor = new JLabel("Main Author");
		GridBagConstraints gbc_bMainAuthor = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 6;
		contentPane.add(bMainAuthor, gbc_bMainAuthor);

		bMainAuthorField = new JTextField();
		GridBagConstraints gbc_text_3 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 6;
		contentPane.add(bMainAuthor, gbc_text_3);
		IDField.setColumns(10);
		
		bPublisher = new JLabel("Title");
		GridBagConstraints gbc_bPublisher = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 7;
		contentPane.add(bPublisher, gbc_bPublisher);

		bPublisherField = new JTextField();
		GridBagConstraints gbc_text_4 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 7;
		contentPane.add(bPublisherField, gbc_text_4);
		IDField.setColumns(10);
		
		bSubject = new JLabel("Subject");
		GridBagConstraints gbc_bSubject = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 8;
		contentPane.add(bSubject, gbc_bSubject);

		bSubjectField = new JTextField();
		GridBagConstraints gbc_text_5 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 8;
		contentPane.add(bSubjectField, gbc_text_5);
		IDField.setColumns(10);
		
		bYear = new JLabel("Year");
		GridBagConstraints gbc_bYear = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 9;
		contentPane.add(bYear, gbc_bYear);

		bYearField = new JTextField();
		GridBagConstraints gbc_text_6 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 9;
		contentPane.add(bYearField, gbc_text_6);
		IDField.setColumns(10);
		

		bAddBook = new JButton("Add Book");
		bAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Statement stmt = null;
				Statement stmt2 = null;
				Statement stmt3 = null;
				
				try {
					stmt = con.createStatement();
					stmt2 = con.createStatement();
					stmt3 = con.createStatement();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
					
				int callNumber = Integer.parseInt(bCallNumber.getText());
				int isbn = Integer.parseInt(bIsbn.getText());
				String title = bTitle.getText();
				String mainAuthor = bMainAuthor.getText();
				String publisher = bPublisher.getText();
				String subject = bSubject.getText();
				int year = Integer.parseInt(bYear.getText());

				try {
					ResultSet rs = stmt.executeQuery("SELECT CopyNumber FROM BookCopy WHERE callNumber LIKE '%" 
							+ isbn + "%'");
					int maxCopy = 0;
					while ( rs.next() ) {
						if (maxCopy < rs.getInt("CopyNumber")) {
							maxCopy = rs.getInt("CopyNumber");
						}
						
						if (maxCopy > 0) {
							try {
								stmt2.executeUpdate("INSERT INTO Book VALUES (" + callNumber + "," + isbn + ",'" + title + "','" + mainAuthor + "','" + publisher + "','" + subject + "'," + ")");

							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							try {
							stmt3.executeUpdate("INSERT INTO BookCopy VALUES (" + callNumber + "," + 1 + "," + 0 + ")");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						} else { 
							stmt3.executeUpdate("INSERT INTO BookCopy VALUES (" + callNumber + "," + (maxCopy+1) + "," + 0 + ")");
						}
			}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});


//---------------------------------------------------------------------------
	
		bAddBook = new JButton("Print Books Out");
		bAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				Statement stmt = null;
				Statement stmt2 = null;
				Statement stmt3 = null;
				
				try {
					stmt = con.createStatement();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				try {
					ResultSet rs = stmt.executeQuery("SELECT bid,outDate,inDate FROM Borrowing");
					while ( rs.next() ) {
						int callNumber = rs.getInt("bid");
						String inDate = rs.getString("inDate");
						String outDate = rs.getString("outDate");
						System.out.println("Book ID: " + callNumber + " :: Date Out: " + outDate + " :: Date Due: " + inDate);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
							
//---------------------------------------------------------------------------	
		
		String yumiko = "^_^";
		String alec = "awesome";
		double alecawesome = 0.0;
		
		gbc_lblBorrowerid.insets = new Insets(0, 0, 5, 5);
		gbc_lblBorrowerid.gridx = 0;
		gbc_lblBorrowerid.gridy = 18;
		contentPane.add(lblBorrowerid, gbc_lblBorrowerid);

		finesBorrowerID = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 18;
		contentPane.add(finesBorrowerID, gbc_textArea);
		
		lblBorrowBooks = new JLabel("Borrow Books");
		GridBagConstraints gbc_lblBorrowBooks = new GridBagConstraints();
		gbc_lblBorrowBooks.insets = new Insets(0, 0, 5, 5);
		gbc_lblBorrowBooks.gridx = 0;
		gbc_lblBorrowBooks.gridy = 19;
		contentPane.add(lblBorrowBooks, gbc_lblBorrowBooks);
		
		lblBorrowerid_1 = new JLabel("BorrowerID");
		GridBagConstraints gbc_lblBorrowerid_1 = new GridBagConstraints();
		gbc_lblBorrowerid_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBorrowerid_1.anchor = GridBagConstraints.EAST;
		gbc_lblBorrowerid_1.gridx = 0;
		gbc_lblBorrowerid_1.gridy = 20;
		contentPane.add(lblBorrowerid_1, gbc_lblBorrowerid_1);
		
		BorrowBookID = new JTextField();
		GridBagConstraints gbc_BorrowBookID = new GridBagConstraints();
		gbc_BorrowBookID.insets = new Insets(0, 0, 5, 5);
		gbc_BorrowBookID.fill = GridBagConstraints.HORIZONTAL;
		gbc_BorrowBookID.gridx = 1;
		gbc_BorrowBookID.gridy = 20;
		contentPane.add(BorrowBookID, gbc_BorrowBookID);
		BorrowBookID.setColumns(10);
		
		lblBookTitle = new JLabel("Book Title 1");
		GridBagConstraints gbc_lblBookTitle = new GridBagConstraints();
		gbc_lblBookTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookTitle.anchor = GridBagConstraints.EAST;
		gbc_lblBookTitle.gridx = 0;
		gbc_lblBookTitle.gridy = 21;
		contentPane.add(lblBookTitle, gbc_lblBookTitle);
		
		Book1 = new JTextField();
		GridBagConstraints gbc_Book11 = new GridBagConstraints();
		gbc_Book11.insets = new Insets(0, 0, 5, 5);
		gbc_Book11.fill = GridBagConstraints.HORIZONTAL;
		gbc_Book11.gridx = 1;
		gbc_Book11.gridy = 21;
		contentPane.add(Book1, gbc_Book11);
		Book1.setColumns(10);
		
		lblBookTitle_1 = new JLabel("Book Title 2");
		GridBagConstraints gbc_lblBookTitle_1 = new GridBagConstraints();
		gbc_lblBookTitle_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookTitle_1.anchor = GridBagConstraints.EAST;
		gbc_lblBookTitle_1.gridx = 0;
		gbc_lblBookTitle_1.gridy = 22;
		contentPane.add(lblBookTitle_1, gbc_lblBookTitle_1);
		
		Book2 = new JTextField();
		GridBagConstraints gbc_Book21 = new GridBagConstraints();
		gbc_Book21.insets = new Insets(0, 0, 5, 5);
		gbc_Book21.fill = GridBagConstraints.HORIZONTAL;
		gbc_Book21.gridx = 1;
		gbc_Book21.gridy = 22;
		contentPane.add(Book2, gbc_Book21);
		Book2.setColumns(10);
		
		lblBookTitle_2 = new JLabel("Book Title 3");
		GridBagConstraints gbc_lblBookTitle_2 = new GridBagConstraints();
		gbc_lblBookTitle_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblBookTitle_2.anchor = GridBagConstraints.EAST;
		gbc_lblBookTitle_2.gridx = 0;
		gbc_lblBookTitle_2.gridy = 23;
		contentPane.add(lblBookTitle_2, gbc_lblBookTitle_2);
		
		Book3 = new JTextField();
		GridBagConstraints gbc_Book31 = new GridBagConstraints();
		gbc_Book31.insets = new Insets(0, 0, 0, 5);
		gbc_Book31.fill = GridBagConstraints.HORIZONTAL;
		gbc_Book31.gridx = 1;
		gbc_Book31.gridy = 23;
		contentPane.add(Book3, gbc_Book31);
		Book3.setColumns(10);
		

//-------------------------------------------------------------------------------	
		
		btnNewButton = new JButton("Checkout Book ;)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (searchField.getText()!=""){ //searching for a book and retrieving the call number
					Statement stmt = null;
					Statement stmt2 = null;
					Statement stmt3 = null;
					
					String bookTitle1 = Book1.getText();
					String bookTitle2 = Book2.getText();
					String bookTitle3 = Book3.getText();
					
					String borrowerNum = BorrowBookID.getText();
					
					int callNumber = 5;
					
					try {
						stmt = con.createStatement();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						ResultSet rs = stmt.executeQuery("SELECT title,callNumber FROM Book WHERE title LIKE '%" 
								+ bookTitle1 + "%' OR title LIKE '%" + bookTitle2 + "%' OR title LIKE '%" 
								+ bookTitle3 + "%'");

						while ( rs.next() ) {
							callNumber = rs.getInt("callNumber");

						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					//at this point, call number has been found for the book, now we must change the status to out

					try {
						stmt2 = con.createStatement();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					try {
						stmt2.executeQuery("UPDATE BookCopy SET status=2 WHERE callNumber= " + callNumber + "");

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					//now attach the checked-out book to the borrower via the BID field. Create a row in Borrowing
					
					try {
						stmt3 = con.createStatement();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					int borid = 5;
					int bid = Integer.parseInt(borrowerNum);
					int bookNumber = callNumber;
					int copyNumber = 1;
					int outDate = 1;
					int inDate = 2;

					try {
						stmt3.executeUpdate("INSERT INTO Borrowing VALUES (" + borid + "," + bid + ",'" + bookNumber + "','" + copyNumber + "'," + outDate + ",'" + inDate + "')");

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	
//---------------------------------------------------------------------------------------------
		

//---------------------------------------------------------------------------------------------
		

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 23;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		String yumiko = "^_^";
		String alec = "awesome";
		double alecawesome = 0.0;
		
		// anonymous inner class for closing the window
		mainFrame.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{ 
				System.exit(0); 
			}
		});

		// size the window to obtain a best fit for the components
		mainFrame.pack();

		// center the frame
		Dimension d = mainFrame.getToolkit().getScreenSize();
		Rectangle r = mainFrame.getBounds();
		mainFrame.setLocation( (d.width - r.width)/2, (d.height - r.height)/2 );

		// make the window visible
		mainFrame.setVisible(true);

		// place the cursor in the text field for the username
		usernameField.requestFocus();

		try 
		{
			// Load the Oracle JDBC driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
			System.exit(-1);
		}
	}


	/*
	 * connects to Oracle database named ug using user supplied username and password
	 */ 
	public boolean connect(String username, String password)
	{
		String connectURL = "jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug"; 

		try 
		{
			con = DriverManager.getConnection(connectURL,username,password);

			System.out.println("\nConnected to Oracle!");
			return true;
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
			return false;
		}
	}


	/*
	 * event handler for button press
	 */ 
	public void actionPerformed(ActionEvent e) 
	{
		if (searchField.getText()!=""){ //searching for a book and retrieving the call number
			Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				ResultSet rs = stmt.executeQuery("SELECT title,mainAuthor,subject,callNumber FROM Book WHERE title LIKE '%" 
						+ searchField.getText() + "%' OR mainAuthor LIKE '%" + searchField.getText() + "%' OR subject LIKE '%" 
						+ searchField.getText() + "%'");

				while ( rs.next() ) {
					int callNumber = rs.getInt("callNumber");
					System.out.println(callNumber);
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	/*
	 * displays simple text interface
	 */ 
	private void showMenu()
	{
		int choice;
		boolean quit;

		quit = false;

		try 
		{
			// disable auto commit mode
			con.setAutoCommit(false);

			while (!quit)
			{
				System.out.print("\n\nPlease choose one of the following: \n");
				System.out.print("1.  Insert branch\n");
				System.out.print("2.  Delete branch\n");
				System.out.print("3.  Update branch\n");
				System.out.print("4.  Show branch\n");
				System.out.print("5.  Quit\n>> ");

				choice = Integer.parseInt(in.readLine());

				System.out.println(" ");

				switch(choice)
				{
				case 1:  insertBranch(); break;
				case 2:  deleteBranch(); break;
				case 3:  updateBranch(); break;
				case 4:  showBranch(); break;
				case 5:  quit = true;
				}
			}

			con.close();
			in.close();
			System.out.println("\nGood Bye!\n\n");
			System.exit(0);
		}
		catch (IOException e)
		{
			System.out.println("IOException!");

			try
			{
				con.close();
				System.exit(-1);
			}
			catch (SQLException ex)
			{
				System.out.println("Message: " + ex.getMessage());
			}
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
		}
	}


	/*
	 * inserts a branch
	 */ 
	private void insertBranch()
	{
		int                bid;
		String             bname;
		String             baddr;
		String             bcity;
		int                bphone;
		PreparedStatement  ps;

		try
		{
			ps = con.prepareStatement("INSERT INTO branch VALUES (?,?,?,?,?)");

			System.out.print("\nBranch ID: ");
			bid = Integer.parseInt(in.readLine());
			ps.setInt(1, bid);

			System.out.print("\nBranch Name: ");
			bname = in.readLine();
			ps.setString(2, bname);

			System.out.print("\nBranch Address: ");
			baddr = in.readLine();

			if (baddr.length() == 0)
			{
				ps.setString(3, null);
			}
			else
			{
				ps.setString(3, baddr);
			}

			System.out.print("\nBranch City: ");
			bcity = in.readLine();
			ps.setString(4, bcity);

			System.out.print("\nBranch Phone: ");
			String phoneTemp = in.readLine();
			if (phoneTemp.length() == 0)
			{
				ps.setNull(5, java.sql.Types.INTEGER);
			}
			else
			{
				bphone = Integer.parseInt(phoneTemp);
				ps.setInt(5, bphone);
			}

			ps.executeUpdate();

			// commit work 
			con.commit();

			ps.close();
		}
		catch (IOException e)
		{
			System.out.println("IOException!");
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
			try 
			{
				// undo the insert
				con.rollback();	
			}
			catch (SQLException ex2)
			{
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
	}


	/*
	 * deletes a branch
	 */ 
	private void deleteBranch()
	{
		int                bid;
		PreparedStatement  ps;

		try
		{
			ps = con.prepareStatement("DELETE FROM branch WHERE branch_id = ?");

			System.out.print("\nBranch ID: ");
			bid = Integer.parseInt(in.readLine());
			ps.setInt(1, bid);

			int rowCount = ps.executeUpdate();

			if (rowCount == 0)
			{
				System.out.println("\nBranch " + bid + " does not exist!");
			}

			con.commit();

			ps.close();
		}
		catch (IOException e)
		{
			System.out.println("IOException!");
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());

			try 
			{
				con.rollback();	
			}
			catch (SQLException ex2)
			{
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
	}


	/*
	 * updates the name of a branch
	 */ 
	private void updateBranch()
	{
		int                bid;
		String             bname;
		PreparedStatement  ps;

		try
		{
			ps = con.prepareStatement("UPDATE branch SET branch_name = ? WHERE branch_id = ?");

			System.out.print("\nBranch ID: ");
			bid = Integer.parseInt(in.readLine());
			ps.setInt(2, bid);

			System.out.print("\nBranch Name: ");
			bname = in.readLine();
			ps.setString(1, bname);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0)
			{
				System.out.println("\nBranch " + bid + " does not exist!");
			}

			con.commit();

			ps.close();
		}
		catch (IOException e)
		{
			System.out.println("IOException!");
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());

			try 
			{
				con.rollback();	
			}
			catch (SQLException ex2)
			{
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}	
	}


	/*
	 * display information about branches
	 */ 
	private void showBranch()
	{
		String     bid;
		String     bname;
		String     baddr;
		String     bcity;
		String     bphone;
		Statement  stmt;
		ResultSet  rs;

		try
		{
			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT * FROM branch");

			// get info on ResultSet
			ResultSetMetaData rsmd = rs.getMetaData();

			// get number of columns
			int numCols = rsmd.getColumnCount();

			System.out.println(" ");

			// display column names;
			for (int i = 0; i < numCols; i++)
			{
				// get column name and print it

				System.out.printf("%-15s", rsmd.getColumnName(i+1));    
			}

			System.out.println(" ");

			while(rs.next())
			{
				// for display purposes get everything from Oracle 
				// as a string

				// simplified output formatting; truncation may occur

				bid = rs.getString("branch_id");
				System.out.printf("%-10.10s", bid);

				bname = rs.getString("branch_name");
				System.out.printf("%-20.20s", bname);

				baddr = rs.getString("branch_addr");
				if (rs.wasNull())
				{
					System.out.printf("%-20.20s", " ");
				}
				else
				{
					System.out.printf("%-20.20s", baddr);
				}

				bcity = rs.getString("branch_city");
				System.out.printf("%-15.15s", bcity);

				bphone = rs.getString("branch_phone");
				if (rs.wasNull())
				{
					System.out.printf("%-15.15s\n", " ");
				}
				else
				{
					System.out.printf("%-15.15s\n", bphone);
				}      
			}

			// close the statement; 
			// the ResultSet will also be closed
			stmt.close();
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
		}	
	}


	public static void main(String args[])
	{
		GUI dc = new GUI();
	}
}
