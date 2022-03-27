package ru.vsu.cs.buchnev;



import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Queue;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JButton buttonTask;
    private JButton buttonInput;
    private JTextArea textAreaList;
    private JTextArea textAreaList1;
    private JTextField textFieldCount;
    private JCheckBox checkBoxOn;
    SimpleLinkedQueue<Double> Simqueue1;
    SimpleLinkedQueue<Double> Simqueue2;
    Queue queue1;
    Queue queue2;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);
        textAreaList1.setText("3.0 5.0 7.0");
        textAreaList.setText("1.0 9.0 4.0");
        textFieldCount.setText("0");
        this.pack();


        buttonInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        Simqueue1 = Task.readLinkedListFromFile(fileChooserOpen.getSelectedFile().getPath(),1);
                        Simqueue2 = Task.readLinkedListFromFile(fileChooserOpen.getSelectedFile().getPath(),2);
                        textAreaList.setText(Simqueue2.queueToString());
                        textAreaList1.setText(Simqueue1.queueToString());
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    boolean on = checkBoxOn.isSelected();
                    if(on == false) {
                        SimpleLinkedQueue<Double> queue1 = Task.stringToLinkedQueue(textAreaList1.getText());
                        SimpleLinkedQueue<Double> queue2 = Task.stringToLinkedQueue(textAreaList.getText());
                        int a = Integer.parseInt(textFieldCount.getText());
                        int res = Task.task(queue1, queue2, a);
                        System.out.println(res);
                        textFieldCount.setText("" + res);
                        textAreaList1.setText(queue1.queueToString());
                        textAreaList.setText(queue2.queueToString());
                    }
                    else {
                        queue1 =  Task.stringToLinkedQueue1(textAreaList1.getText());
                        queue2 =  Task.stringToLinkedQueue1(textAreaList.getText());
                        int a = Integer.parseInt(textFieldCount.getText());
                        int res = Task.task2(queue1, queue2, a);
                        System.out.println(res);
                        textFieldCount.setText("" + res);
                        textAreaList1.setText(Task.stringFromQueue(queue1));
                        textAreaList.setText(Task.stringFromQueue(queue2));
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
