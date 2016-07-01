package Graphics;

import Database.ConnectDB;
import Logic.CompuerClasses.CPUType;
import Logic.CompuerClasses.Computer;
import Logic.CompuerClasses.DeskTop;
import Logic.ComputerSample;
import Logic.PeopleClasses.Customer;
import sun.applet.Main;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;

import static javax.swing.SwingConstants.*;

/**
 * Created by student on 01-Jul-16.
 */
public class MainProgramme extends JFrame{
    Connection conn;
    String username = "root";
    String password = "Password100";
    String url = "jdbc:mysql://localhost:3306/computershop?UseSSL=false";

    static ArrayList<Customer> customerList;

    JLabel startLabel;


    JMenuBar menuBar;
    JMenu usersMenu;
    JMenuItem newUserMenu,loadUserMenu;

    JTextField firstNameBox, lastNameBox, cpuBox, ramBox, hddBox, gpuBox, makeBox, priceBox, ltSizeBox, ltTypeBox, dtMouseBox, dtKeyboardBox, dtTowerBox;

    JLabel cpuLabel, ramLabel, hddLabel,gpuLabel, makeLabel, priceLabel, ltSizeLabel, ltTypeLabel, dtMouseLabel, dtKeyboardLabel, dtTowerLabel;


    JComboBox<String> pcType;
    JPanel mainPanel = new JPanel(), loadPanel, newUserPanel;
    JTextField newFirstName,newLastName;

    JComboBox<String> usersCombo;

    JButton findButton, listButton, sortButton, buyButton, createUserButton, selectUserButton = new JButton("Select");

    public MainProgramme(){
        super("PC Shop");

        setSize(500,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //set up menu bar
        menuBar = new JMenuBar();
        usersMenu = new JMenu("Users");
        newUserMenu = new JMenuItem("New User");
        newUserMenu.addActionListener(event ->{
            createNewUser();
        });
        loadUserMenu = new JMenuItem("Load User");
        loadUserMenu.addActionListener(event ->{
            loadUser();
        });

        usersMenu.add(newUserMenu);
        usersMenu.add(loadUserMenu);
        menuBar.add(usersMenu);
        setJMenuBar(menuBar);

        setInitialScreen();

        setVisible(true);

        selectUserButton.addActionListener(event -> {
            loadShop();
        });

    }

    public static void main(String[] args){
        new MainProgramme();

        ComputerSample samplePCs = new ComputerSample();
        System.out.println(samplePCs.comp1.getGpu().toString());


    }

    public void setInitialScreen(){
        startLabel = new JLabel("Please select user");
        add(startLabel);
    }

    public void createNewUser(){
        //create a new user and add to the users DB
        newUserPanel = new JPanel();

        if(loadPanel != null){
            loadPanel.setVisible(false);
        }
        if (mainPanel != null){
            mainPanel.setVisible(false);
        }
        startLabel.setVisible(false);

        firstNameBox = new JTextField();
        lastNameBox = new JTextField();
        createUserButton = new JButton("Create User");

        newUserPanel.setLayout(new GridLayout(3,2));

        newUserPanel.add(new JLabel("First Name"));
        newUserPanel.add(firstNameBox);
        newUserPanel.add(new JLabel("Last Name"));
        newUserPanel.add(lastNameBox);
        newUserPanel.add(createUserButton);

        add(newUserPanel);
        newUserPanel.setVisible(true);

        createUserButton.addActionListener(event ->{
            String firstname = firstNameBox.getText();
            String lastname = lastNameBox.getText();

            try {ConnectDB.addUsersToDb(firstname,lastname);}
            catch(Exception e){System.out.println("failed to add users to DB: " + e);}

            loadUser();
        });

    }

    public void loadUser(){
        //load a list of users from the DB
        loadPanel = new JPanel();
        loadPanel.setLayout(new GridLayout(2,2));


        usersCombo = new JComboBox<>();
        usersCombo.addItem("");
            try{customerList = ConnectDB.getCustomersFromDB();}catch(Exception e){System.out.println("Couldn't load list for combobox");}

        for(Customer cust : customerList){
            usersCombo.addItem(cust.getFirstName()+" " +cust.getLastName());
        }

        loadPanel.add(usersCombo);
        loadPanel.add(selectUserButton);
        startLabel.setVisible(false);
        if (newUserPanel != null) {
            newUserPanel.setVisible(false);
        }
        if (mainPanel != null){
            mainPanel.setVisible(false);
        }
        add(loadPanel);
        loadPanel.setVisible(true);

    }

    public void loadShop(){
        //load up shop once a user is selected
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,2));

        JPanel topLeftPanel = new JPanel(), topRightPanel = new JPanel(), bottomLeftPanel = new JPanel(), bottomRightPanel = new JPanel();
        topLeftPanel.setLayout(new GridLayout(6,1));
        topRightPanel.setLayout(new GridLayout(6,1));
        //top left label panel
        topLeftPanel.add(cpuLabel = new JLabel("CPU"));
        topLeftPanel.add(ramLabel = new JLabel("RAM"));
        topLeftPanel.add(hddLabel = new JLabel("HDD Size"));
        topLeftPanel.add(gpuLabel = new JLabel("Graphics Card"));
        topLeftPanel.add(makeLabel = new JLabel("Make"));
        topLeftPanel.add(priceLabel = new JLabel("Price (GBP)"));

        topRightPanel.add(cpuBox = new JTextField());
        topRightPanel.add(ramBox = new JTextField());
        topRightPanel.add(hddBox = new JTextField());
        topRightPanel.add(gpuBox = new JTextField());
        topRightPanel.add(makeBox = new JTextField());
        topRightPanel.add(priceBox = new JTextField());

        bottomRightPanel = new JPanel();
        bottomLeftPanel = new JPanel();


        loadPanel.setVisible(false);
        add(mainPanel);
        mainPanel.add(topLeftPanel);
        mainPanel.add(topRightPanel);
        mainPanel.add(bottomLeftPanel);
        mainPanel.add(bottomRightPanel);

        mainPanel.setVisible(true);
        topLeftPanel.setVisible(true);
        topRightPanel.setVisible(true);



    }



}
