import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Extracting the button model");
        frame.setSize(500, 500);

        JButton checkButton = new JButton("label obtained");
        checkButton.setBounds(200, 200, 120, 30); 
        frame.add(checkButton);
        
        ButtonModel model = checkButton.getModel();
        
        // Add a change listener to the ButtonModel to detect changes in its state
        model.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Button state changed!");
                System.out.println("Is pressed? " + model.isPressed());
                System.out.println("Is armed? " + model.isArmed());
                System.out.println("Is enabled? " + model.isEnabled());
                System.out.println("Is selected? " + model.isSelected());
            }
        });

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}




/* 
Property Name                   Value
    
actionCommand                  The action command string associated with this button
    
mnemonic                       The keyboard mnemonic for this button
                                        
    
armed                            true     if the button was pressed and the mouse is still over the
                                        button
    
enabled                            true if the button is selectable
                                           
pressed                              true if the button was pressed but the mouse button hasn’t yet
                                            been released
    
rollover                             true if the mouse is over the button
    
selected                             true if the button has been toggled on (used for checkboxes and
                                    radio buttons)selected


    */
