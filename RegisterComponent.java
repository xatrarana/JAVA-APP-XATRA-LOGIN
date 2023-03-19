import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;




public class RegisterComponent extends JFrame implements ActionListener {
    private JLabel labelTitle,
            labelName,
            labelEmail,
            labelPhone,
            labelUsername,
            labelPassword,
            labelConfirmPassword;

    private  JTextField textFieldName,
            textFieldEmail,
            textFieldPhone,
            textFieldUsername;

    private JPasswordField passwordField,
            confirmPasswordField;

    private JButton jButtonSubmit,
            jButtonLogin;



    RegisterComponent() {
        Font font = new Font("Open Sans", Font.BOLD, 15);

        labelTitle = new JLabel("User Registration");
        labelTitle.setBounds(250, 10, 200, 30);
        labelTitle.setFont(new Font("Open Sans", Font.BOLD, 20));
        add(labelTitle);

        labelName = new JLabel("Full Name");
        labelName.setBounds(100, 100, 100, 30);
        labelName.setFont(font);
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(200, 100, 400, 30);
        textFieldName.setFont(font);
        add(textFieldName);

        labelEmail = new JLabel("Email");
        labelEmail.setBounds(100, 150, 100, 30);
        labelEmail.setFont(font);
        add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(200, 150, 400, 30);
        textFieldEmail.setFont(font);
        add(textFieldEmail);

        labelPhone = new JLabel("Phone");
        labelPhone.setBounds(100, 200, 100, 30);
        labelPhone.setFont(font);
        add(labelPhone);

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(200, 200, 400, 30);
        textFieldPhone.setFont(font);
        add(textFieldPhone);

        labelUsername = new JLabel("Username");
        labelUsername.setBounds(100, 250, 100, 30);
        labelUsername.setFont(font);
        add(labelUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(200, 250, 400, 30);
        textFieldUsername.setFont(font);
        add(textFieldUsername);

        labelPassword = new JLabel("Password");
        labelPassword.setBounds(100, 300, 100, 30);
        labelPassword.setFont(font);
        add(labelPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 300, 400, 30);
        passwordField.setFont(font);
        add(passwordField);

        labelConfirmPassword = new JLabel("Confirm Password");
        labelConfirmPassword.setBounds(100, 350, 150, 30);
        labelConfirmPassword.setFont(font);
        add(labelConfirmPassword);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(250, 350, 350, 30);
        confirmPasswordField.setFont(font);
        add(confirmPasswordField);

        jButtonSubmit = new JButton("Submit");
        jButtonSubmit.setBounds(200, 400, 150, 30);
        jButtonSubmit.setFont(font);
        add(jButtonSubmit);
        jButtonSubmit.addActionListener(this);

        jButtonLogin = new JButton("Login");
        jButtonLogin.setBounds(350, 400, 150, 30);
        jButtonLogin.setFont(font);
        add(jButtonLogin);
        jButtonLogin.addActionListener(this);


        setLayout(null);
        setTitle("Register");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButtonSubmit){
            boolean isValid=false;
            String name = textFieldName.getText();
            String email = textFieldEmail.getText();
            String phone = textFieldPhone.getText();
            String username = textFieldUsername.getText();
            String password = String.valueOf(passwordField.getPassword());
            String cpassword = String.valueOf(confirmPasswordField.getPassword());
            String [] user = {
                    textFieldName.getText(),
                    textFieldEmail.getText(),
                    textFieldPhone.getText(),
                    textFieldUsername.getText(),
                    String.valueOf(passwordField.getPassword()),
                    String.valueOf(confirmPasswordField.getPassword())
            };
            for (String s : user) {
                isValid = checkField(s);
                if(isValid){
                    break;
                }
            }

            if(!isValid){
                if(!password.equals(cpassword)){
                    JOptionPane.showMessageDialog(this,"password and confirm password didn't match");
                }else{
                    User userData = new User(name,username,email,phone,password);
                        try{
                            new DataFile(userData);
                        }catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }
                    JOptionPane.showMessageDialog(this,"Successfully registered"+userData.getName());
                    setVisible(false);
                    dispose();
                    LoginComponent loginComponent = new LoginComponent();
                    loginComponent.setVisible(true);
                }

            }else{
                JOptionPane.showMessageDialog(this,"Field cant be left blank");
            }


        }else if(e.getSource() == jButtonLogin){
            setVisible(false);
            dispose();
            LoginComponent loginComponent = new LoginComponent();
            loginComponent.setVisible(true);

        }
    }

    public Boolean checkField(String value){
        boolean isLength = false;
        isLength = value.length() == 0;

        return  isLength;
    }
}