import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
public class SliderFrame {
    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;
    private JFrame frame;
    public SliderFrame(){
        frame=new JFrame("Slider Demo");
        sliderPanel=new JPanel();
        sliderPanel.setLayout(new GridBagLayout());

        listener=event ->{
            JSlider source=(JSlider) event.getSource();
            textField.setText(""+source.getValue());
        };


        JSlider slider=new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Ticks");

        slider=new  JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Snap to ticks");

        slider=new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);
        addSlider(slider,"No Track");

        slider=new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider,"Inverted");

        slider=new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Labels");

        slider=new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        Dictionary<Integer,Component> labelTable=new Hashtable<>();
        labelTable.put(0,new JLabel("A"));
        labelTable.put(20,new JLabel("B"));
        labelTable.put(40,new JLabel("C"));
        labelTable.put(60,new JLabel("D"));
        labelTable.put(80,new JLabel("E"));
        labelTable.put(100,new JLabel("F"));

        slider.setLabelTable(labelTable);
        addSlider(slider,"Custom labels");


        slider=new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);

        labelTable=new Hashtable<Integer,Component>();

        labelTable.put(0,new JLabel(new ImageIcon("nine.gif")));
        labelTable.put(20,new JLabel(new ImageIcon("ten.gif")));
        labelTable.put(40,new JLabel(new ImageIcon("jack.gif")));
        labelTable.put(60,new JLabel(new ImageIcon("queen.gif")));
        labelTable.put(80,new JLabel(new ImageIcon("king.gif")));
        labelTable.put(100,new JLabel(new ImageIcon("ace.gif")));

        slider.setLabelTable(labelTable);
        addSlider(slider,"Icon labels");

        textField=new JTextField();
        frame.add(sliderPanel,BorderLayout.CENTER);
        frame.add(textField,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.pack();
    }
    public void addSlider(JSlider s,String description){
        s.addChangeListener(listener);
        JPanel panel=new JPanel();
        panel.add(s);
        panel.add(new JLabel(description));
        panel.add(new JLabel(description));
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.gridy=sliderPanel.getComponentCount();
        gbc.anchor=GridBagConstraints.WEST;
        sliderPanel.add(panel,gbc);
    }
    public static void main(String args[]){
        new SliderFrame();
    }
}
