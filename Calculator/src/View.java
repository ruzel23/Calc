import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements ActionListener {

    JButton b0, b1, b2, b3, b4, b5, b6, b7 ,b8, b9, bminus, bdec,
            bplus, bmult, bdiv, bbrackop, bbrackcl, bdel, bclr,
            bequal;
    JFrame frame;
    JTextField text;
    Controller controller;

    View(){
        controller = new Controller();
        frame = new JFrame("Calculator");
        text = new JTextField();
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bminus = new JButton("-");
        bplus = new JButton("+");
        bdiv = new JButton("/");
        bmult = new JButton("*");
        bbrackop = new JButton("(");
        bbrackcl = new JButton(")");
        bdel = new JButton("<-");
        bclr = new JButton("C");
        bdec = new JButton(".");
        bequal = new JButton("=");

        text.setBounds(30,40,280,40);
        b7.setBounds(40,130,50,40);
        b8.setBounds(110,130,50,40);
        b9.setBounds(180,130,50,40);
        bdiv.setBounds(250,130,50,40);

        b4.setBounds(40,180,50,40);
        b5.setBounds(110,180,50,40);
        b6.setBounds(180,180,50,40);
        bmult.setBounds(250,180,50,40);

        b1.setBounds(40,230,50,40);
        b2.setBounds(110,230,50,40);
        b3.setBounds(180,230,50,40);
        bminus.setBounds(250,230,50,40);

        bbrackop.setBounds( 110,280,50,40);
        b0.setBounds(40,280,50,40);
        bbrackcl.setBounds(180,280,50,40);
        bplus.setBounds(250,280,50,40);

        bdel.setBounds(40,330,50,40);
        bclr.setBounds(110,330,50,40);
        bdec.setBounds(180, 330, 50, 40);
        bequal.setBounds(250, 330, 50, 40);

        frame.add(text);
        frame.add(b0);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(bminus);
        frame.add(bplus);
        frame.add(bdec);
        frame.add(bmult);
        frame.add(bdiv);
        frame.add(bdel);
        frame.add(bclr);
        frame.add(bequal);
        frame.add(bbrackcl);
        frame.add(bbrackop);


        frame.setLayout(null);
        frame.setSize(350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);


        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bminus.addActionListener(this);
        bdec.addActionListener(this);
        bplus.addActionListener(this);
        bmult.addActionListener(this);
        bdiv.addActionListener(this);
        bbrackop.addActionListener(this);
        bbrackcl.addActionListener(this);
        bdel.addActionListener(this);
        bclr.addActionListener(this);
        bequal.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b0)
            text.setText(text.getText().concat("0"));
        if(e.getSource() == b1)
            text.setText(text.getText().concat("1"));
        if(e.getSource() == b2)
            text.setText(text.getText().concat("2"));
        if(e.getSource() == b3)
            text.setText(text.getText().concat("3"));
        if(e.getSource() == b4)
            text.setText(text.getText().concat("4"));
        if(e.getSource() == b5)
            text.setText(text.getText().concat("5"));
        if(e.getSource() == b6)
            text.setText(text.getText().concat("6"));
        if(e.getSource() == b7)
            text.setText(text.getText().concat("7"));
        if(e.getSource() == b8)
            text.setText(text.getText().concat("8"));
        if(e.getSource() == b9)
            text.setText(text.getText().concat("9"));
        if(e.getSource() == bminus)
            text.setText(text.getText().concat("-"));
        if(e.getSource() == bplus)
            text.setText(text.getText().concat("+"));
        if(e.getSource() == bdiv)
            text.setText(text.getText().concat("/"));
        if(e.getSource() == bbrackcl)
            text.setText(text.getText().concat(")"));
        if(e.getSource() == bbrackop)
            text.setText(text.getText().concat("("));
        if(e.getSource() == bmult)
            text.setText(text.getText().concat("*"));
        if(e.getSource() == bdel){
            String str = text.getText();
            if(!str.isEmpty())
            text.setText(str.substring(0, str.length() - 1));
        }
        if(e.getSource() == bdec)
            text.setText(text.getText().concat("."));
        if(e.getSource() == bclr)
            text.setText("");
        if(e.getSource() == bequal){
            controller.runCalculate(text.getText());
            text.setText(controller.getResult());
        }

    }

    public static void main(String[] args){
        new View();
    }

}
