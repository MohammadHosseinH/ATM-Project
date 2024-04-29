import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//I read about layout managers, JPasswordField class, JTextField class Action listeners in javatpoint.com & geeksforgeeks.org


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ATM");
        frame.setSize(700,500);
        Font font = new Font("Lalezar", Font.PLAIN, 20);
        Color color = new Color(0x181E3B);

        //******************* Language Page ********************
        JPanel languagePanel = new JPanel();
        languagePanel.setBackground(color);
        JButton englishButton = new JButton("English");
        JButton persianButton = new JButton("فارسی");
        JLabel languageLabel = new JLabel("   choose language    زبان خود را انتخاب کنید   ");
        languageLabel.setFont(font);
        languageLabel.setForeground(Color.ORANGE);
        languagePanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0,50,0,50);
        constraints.gridx = 0;
        constraints.gridy = 0;
        languagePanel.add(englishButton,constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        languagePanel.add(languageLabel,constraints);
        constraints.gridx = 2;
        constraints.gridy = 0;
        languagePanel.add(persianButton,constraints);

        frame.add(languagePanel);

        //******************* Password Page ******************
        JPanel passwordPanel = new JPanel(null);
        englishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(languagePanel);
                frame.add(passwordPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        passwordPanel.setBackground(color);
        JLabel passwordLabel = new JLabel("Enter your password");
        JPasswordField entryPassField = new JPasswordField();
        JButton passConfirmButton = new JButton("Confirm");

        passwordPanel.add(passwordLabel);
        passwordLabel.setBounds(270,200,200,20);
        passwordLabel.setForeground(Color.orange);
        passwordLabel.setFont(font);

        passwordPanel.add(entryPassField);
        entryPassField.setBounds(250,230,200,20);

        passwordPanel.add(passConfirmButton);
        passConfirmButton.setBounds(250,410,200,50);


        //******************* Menu Page *******************
        JPanel menuPanel = new JPanel(new GridBagLayout());

        passConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.remove(passwordPanel);
                frame.add(menuPanel);
                frame.repaint();
                frame.revalidate();
            }
        });

        JButton withdrawalButton = new JButton("Cash Withdrawal");
        JButton balanceButton = new JButton("Balance");
        JButton transferButton = new JButton("Transferring");
        JButton changePassButton = new JButton("Change Password");

        constraints.insets = new Insets(75, 200 , 75, 200);
        constraints.gridx = 0;
        constraints.gridy = 0;
        menuPanel.add(withdrawalButton,constraints);
        constraints.gridx = 1;
        menuPanel.add(balanceButton,constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        menuPanel.add(transferButton,constraints);
        constraints.gridx = 1;
        menuPanel.add(changePassButton,constraints);
        menuPanel.setBackground(new Color(0x181E3B));

        //******************* Withdrawal Page ********************
        JPanel withdrawalPanel = new JPanel(new GridBagLayout());
        withdrawalPanel.setBackground(color);
        withdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(menuPanel);
                frame.add(withdrawalPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        JButton firstAmountButton = new JButton("500,000");
        JButton secondAmountButton = new JButton("1,000,000");
        JButton thirdAmountButton = new JButton("1,500,000");
        JButton fourthAmountButton = new JButton("2,000,000");

        constraints.insets = new Insets(50, 200 , 50, 200);
        constraints.gridx = 0;
        constraints.gridy = 0;
        withdrawalPanel.add(firstAmountButton,constraints);
        constraints.gridx = 1;
        withdrawalPanel.add(secondAmountButton,constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        withdrawalPanel.add(thirdAmountButton,constraints);
        constraints.gridx = 1;
        withdrawalPanel.add(fourthAmountButton,constraints);

        JButton withdrawalBackButton = new JButton("Back");
        withdrawalBackButton.setForeground(Color.red);
        withdrawalBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(withdrawalPanel);
                frame.add(menuPanel);
                frame.repaint();
                frame.revalidate();
            }
        });

        constraints.gridx = 1;
        constraints.gridy = 2;
        withdrawalPanel.add(withdrawalBackButton,constraints);

        //***************** Balance Page ***************
        JPanel balancePanel = new JPanel(null);
        balancePanel.setBackground(color);
        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(menuPanel);
                frame.add(balancePanel);
                frame.repaint();
                frame.revalidate();
            }
        });

        Random randomBalance = new Random();
        JLabel balanceLabel = new JLabel("Your Account Balance : " + Integer.toString((randomBalance.nextInt(1000) + 1) * 1000) + "$");
        balanceLabel.setForeground(Color.orange);
        balanceLabel.setFont(font);
        balanceLabel.setBounds(230,200,300,100);
        balancePanel.add(balanceLabel);
        JButton balanceBackButton = new JButton("Back");
        balanceBackButton.setForeground(Color.red);
        balanceBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(balancePanel);
                frame.add(menuPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        balanceBackButton.setBounds(250,410,200,50);
        balancePanel.add(balanceBackButton);


        //********************* Transfer Page **********************
        JPanel transferPanel = new JPanel(null);
        transferPanel.setBackground(color);
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(menuPanel);
                frame.add(transferPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        JLabel enterAmount = new JLabel("Enter The Amount:");
        enterAmount.setForeground(Color.orange);
        enterAmount.setFont(font);
        JTextField amountField = new JTextField();
        JLabel enterCredit = new JLabel("Enter The Credit Num:");
        enterCredit.setForeground(Color.orange);
        enterCredit.setFont(font);
        JTextField creditField = new JTextField();
        JButton transferConfirmButton = new JButton("Confirm");
        enterAmount.setBounds(250,80,200,30);
        amountField.setBounds(250,130,200,20);
        enterCredit.setBounds(250,250,200,30);
        creditField.setBounds(250,300,200,20);
        transferPanel.add(enterAmount);
        transferPanel.add(amountField);
        transferPanel.add(enterCredit);
        transferPanel.add(creditField);
        transferConfirmButton.setBounds(300,410,100,50);
        transferPanel.add(transferConfirmButton);

        JButton transferBackButton = new JButton("Back");
        transferBackButton.setForeground(Color.red);
        transferBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(transferPanel);
                frame.add(menuPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        transferBackButton.setBounds(580,410,100,50);
        transferPanel.add(transferBackButton);


        //********************** Change Password Page *************************
        JPanel changePassPanel = new JPanel(null);
        changePassPanel.setBackground(color);
        changePassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(menuPanel);
                frame.add(changePassPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        JLabel enterNewPassLabel = new JLabel("Enter Your New Password");
        enterNewPassLabel.setFont(font);
        enterNewPassLabel.setForeground(Color.orange);
        enterNewPassLabel.setBounds(250,100,300,20);
        changePassPanel.add(enterNewPassLabel);
        JPasswordField newPassField = new JPasswordField();
        newPassField.setBounds(255,150,200,30);
        changePassPanel.add(newPassField);
        JButton changePassConfirmButton = new JButton("Confirm");
        changePassConfirmButton.setBounds(300,430,100,30);
        changePassPanel.add(changePassConfirmButton);

        JButton changePassBackButton = new JButton("Back");
        changePassBackButton.setForeground(Color.red);
        changePassBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(changePassPanel);
                frame.add(menuPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        changePassBackButton.setBounds(580,430,100,30);
        changePassPanel.add(changePassBackButton);


        //****************** Success Page ************************
        JPanel successPanel = new JPanel(null);
        successPanel.setBackground(color);
        JLabel successMessage = new JLabel("Mission Successful!");
        successMessage.setForeground(Color.orange);
        successMessage.setFont(font);
        successMessage.setBounds(260,200,300,40);
        successPanel.add(successMessage);

        firstAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(withdrawalPanel);
                frame.add(successPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        secondAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(withdrawalPanel);
                frame.add(successPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        thirdAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(withdrawalPanel);
                frame.add(successPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        fourthAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(withdrawalPanel);
                frame.add(successPanel);
                frame.repaint();
                frame.revalidate();
            }
        });

        transferConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(transferPanel);
                frame.add(successPanel);
                frame.repaint();
                frame.revalidate();
            }
        });

        changePassConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(changePassPanel);
                frame.add(successPanel);
                frame.repaint();
                frame.revalidate();
            }
        });

        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setVisible(true);


    }
}