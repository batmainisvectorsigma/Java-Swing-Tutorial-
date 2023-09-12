import java.awt.*;
import java.beans.*;
import java.lang.reflect.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventTracer {
    private InvocationHandler handler;

    public EventTracer() {
        handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) {
                System.out.println(method + ":" + args[0]);
                return null;
            }
        };
    }

    public void add(Component c) {
        try {
            BeanInfo info = Introspector.getBeanInfo(c.getClass());
            EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
            for (EventSetDescriptor eventSet : eventSets)
                addListener(c, eventSet);
        } catch (IntrospectionException ignored) {
        }

        if (c instanceof Container) {
            for (Component comp : ((Container) c).getComponents())
                add(comp);
        }
    }

    public void addListener(Component c, EventSetDescriptor eventSet) {
        Object proxy = Proxy.newProxyInstance(null, new Class[] { eventSet.getListenerType() }, handler);
        Method addListenerMethod = eventSet.getAddListenerMethod();
        try {
            addListenerMethod.invoke(c, proxy);
        } catch (ReflectiveOperationException ignored) {
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("EventTracer Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JButton button = new JButton("Click me!");
        JTextField textField = new JTextField(20);

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(textField);

        frame.add(panel);

        EventTracer tracer = new EventTracer();
        tracer.add(frame);

        frame.setVisible(true);
    }
}

