import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class MyFrame extends JFrame implements ListSelectionListener,ActionListener
{
    private JSplitPane jsp;
    private JScrollPane sp;
    private JList <String>lst;
    private Vector <String>v;
    private JPanel p;
    private JTextField txt;
    private JButton b;
    private JLabel lbl_sel_index,lbl_sel_item;


  public MyFrame()
  {
    //left part
    v=new Vector<String>();
    String arr[]={"JACK","JAMES","WILLIAM"};

    for(String item:arr)
        v.add(item);
    lst=new JList<String>(v);
    lst.addListSelectionListener(this);
    sp=new JScrollPane(lst);

    //rigth part

    p=new JPanel();
    p.setLayout(new GridLayout(4,2));

    p.add(new JLabel("Enter Name:"));
    txt=new JTextField();
    p.add(txt);

    String str[]={"ADD","DELETE"};
    for(String item:str)
    {
        b=new JButton(item);
        p.add(b);
        b.addActionListener(this);
    }

    p.add(new JLabel("Selected Index :"));
    lbl_sel_index=new JLabel();
    p.add(lbl_sel_index);

    p.add(new JLabel("Selected Item :"));
    lbl_sel_item=new JLabel();
    p.add(lbl_sel_item);

    //JSplitPane

     jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sp,p);
     jsp.setDividerLocation(150);
     jsp.setDividerSize(2);
     this.add(jsp,BorderLayout.CENTER);

      this.setVisible(true);
      this.setSize(600,250);
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
  @Override
  public void actionPerformed(ActionEvent e)
   {
      String name=txt.getText().trim().toUpperCase();
      txt.setText("");

      String text=e.getActionCommand();
      switch(text)
      {
         case"ADD":
            v.add(name);
            
            lst.setListData(v);
            break;
          case"DELETE":
             v.remove(name);
              lst.setListData(v);
             break;
      }

   }
   @Override
  public void valueChanged(ListSelectionEvent e)
  {
      int index=lst.getSelectedIndex();
      String value=lst.getSelectedValue();

      lbl_sel_item.setText(value);
      lbl_sel_index.setText(index+"");
  }
}
class JListExample
{
    public static void main(String[] args) {
        new MyFrame();
    }
}