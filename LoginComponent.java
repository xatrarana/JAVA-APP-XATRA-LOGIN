import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginComponent extends JFrame implements ActionListener {
    JLabel labelUsername, labelPassword, labelTitle;
    Font font;

    JTextField textFieldUsername;
    JPasswordField passwordField;

    JButton jButtonSubmit, jButtonRegister;
    LoginComponent(){
        font = new Font("Open Sans", Font.BOLD, 15);
        labelTitle = new JLabel("Login");
        labelTitle.setFont(new Font("Open Sans", Font.BOLD,20));
        labelTitle.setBounds(200,5,150,30);
        add(labelTitle);

        labelUsername = new JLabel("username");
        labelUsername.setBounds(50,50,150,50);
        labelUsername.setFont(font);
        add(labelUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(50,100,250,50);
        textFieldUsername.setFont(font);
        add(textFieldUsername);


        labelPassword = new JLabel("password");
        labelPassword.setBounds(50,150,150,50);
        labelPassword.setFont(font);
        add(labelPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(50,200,250,50);
        passwordField.setFont(font);
        add(passwordField);

        jButtonSubmit = new JButton("submit");
        jButtonSubmit.setBounds(50,280,150,50);
        jButtonSubmit.setFont(font);
        add(jButtonSubmit);
        jButtonSubmit.addActionListener(this);

        jButtonRegister = new JButton("Register");
        jButtonRegister.setBounds(210,280,150,50);
        jButtonRegister.setFont(font);
        add(jButtonRegister);
        jButtonRegister.addActionListener(this);


       // frame.add(textField2);
        setLayout(null);
        setSize(450,470);
        setTitle("Login");
        setFont(font);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButtonSubmit){

                String username = textFieldUsername.getText();
                String password = String.valueOf(passwordField.getPassword());

            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("dataFile/"+username+".txt"));
                User user = (User)objectInputStream.readObject();

                if(!password.equals(user.getPassword())){
                    JOptionPane.showMessageDialog(this,"Password incorrect");
                }else{
                    JOptionPane.showMessageDialog(this,"login successful");
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,"username doesn't exists");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

        }
        else if(e.getSource() == jButtonRegister){
            setVisible(false);
            dispose();

            RegisterComponent registerComponent = new RegisterComponent();
            registerComponent.setVisible(true);
        }
    }
}
