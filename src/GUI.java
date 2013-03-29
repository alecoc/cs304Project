
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblId;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JLabel lblSinstudent;
	private JLabel lblExpiryDate;
	private JLabel lblType;
	private JButton btnAddBorrower;
	private JLabel lblCheckAccount;
	private JTextField textField_9;
	private JLabel lblId_1;
	private JButton btnCheckAccount;
	private JLabel lblLibraryBorrowerGraphical;
	private JLabel lblPlaceHoldRequest;
	private JTextField textField_10;
	private JLabel lblBookName;
	private JButton btnPlaceHold;
	private JLabel lblPayOutstandingFines;
	private JTextField textField_11;
	private JLabel lblAmount;
	private JButton btnPayFines;
	
	

	/*
	 * constructs login window and loads JDBC driver
	 */ 
	public GUI()
	{
		mainFrame = new JFrame("User Login");
		String username = "ora_e4q7";
		String password = "a23056096";
		connect(username, password);

		JLabel searchLabel = new JLabel("Keyword Search");

		usernameField = new JTextField(10);
		passwordField = new JPasswordField(10);
		passwordField.setEchoChar('*');

		searchField = new JTextField(30);

		JButton searchButton = new JButton("Search");

		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		mainFrame.setContentPane(contentPane);


		// layout components using the GridBag layout manager

		GridBagLayout gb = new GridBagLayout();
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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 4;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 5;
		contentPane.add(lblId, gbc_lblId);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 5;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		lblAddress = new JLabel("Address");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 6;
		contentPane.add(lblAddress, gbc_lblAddress);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 6;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		lblPhone = new JLabel("Phone");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.anchor = GridBagConstraints.EAST;
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 7;
		contentPane.add(lblPhone, gbc_lblPhone);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 7;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 8;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 8;
		contentPane.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		lblSinstudent = new JLabel("Sin/Student#");
		GridBagConstraints gbc_lblSinstudent = new GridBagConstraints();
		gbc_lblSinstudent.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinstudent.anchor = GridBagConstraints.EAST;
		gbc_lblSinstudent.gridx = 0;
		gbc_lblSinstudent.gridy = 9;
		contentPane.add(lblSinstudent, gbc_lblSinstudent);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 9;
		contentPane.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		lblExpiryDate = new JLabel("Expiry Date");
		GridBagConstraints gbc_lblExpiryDate = new GridBagConstraints();
		gbc_lblExpiryDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblExpiryDate.anchor = GridBagConstraints.EAST;
		gbc_lblExpiryDate.gridx = 0;
		gbc_lblExpiryDate.gridy = 10;
		contentPane.add(lblExpiryDate, gbc_lblExpiryDate);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 10;
		contentPane.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 11;
		contentPane.add(lblType, gbc_lblType);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 11;
		contentPane.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		btnAddBorrower = new JButton("Add Borrower");
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
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 13;
		contentPane.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		btnCheckAccount = new JButton("Check Account");
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
		
		textField_10 = new JTextField();
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 15;
		contentPane.add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);
		
		btnPlaceHold = new JButton("Place Hold");
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
		gbc_lblAmount.insets = new Insets(0, 0, 0, 5);
		gbc_lblAmount.anchor = GridBagConstraints.EAST;
		gbc_lblAmount.gridx = 0;
		gbc_lblAmount.gridy = 17;
		contentPane.add(lblAmount, gbc_lblAmount);
		
		textField_11 = new JTextField();
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 0, 5);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 1;
		gbc_textField_11.gridy = 17;
		contentPane.add(textField_11, gbc_textField_11);
		textField_11.setColumns(10);
		
		btnPayFines = new JButton("Pay Fines");
		GridBagConstraints gbc_btnPayFines = new GridBagConstraints();
		gbc_btnPayFines.gridx = 2;
		gbc_btnPayFines.gridy = 17;
		contentPane.add(btnPayFines, gbc_btnPayFines);

	

		// register search field and OK button with action event handler

		searchButton.addActionListener(this);

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
	 * event handler for login window
	 */ 
	public void actionPerformed(ActionEvent e) 
	{
		
		if (searchField.getText()!=""){
			Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				ResultSet rs = stmt.executeQuery("SELECT title,mainAuthor,subject,callNumber FROM Book WHERE title LIKE '%" + searchField.getText() + "%' OR mainAuthor LIKE '%" + searchField.getText() + "%' OR subject LIKE '%" + searchField.getText() + "%'");
				//put the resulting book list into variable bookList
				

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
