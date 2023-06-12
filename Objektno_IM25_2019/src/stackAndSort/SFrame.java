package stackAndSort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dijalog.DRectangle;
import dijalog.DRectangleM;
import geometry.Point;
import geometry.Rectangle;

import javax.swing.JToolBar;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class SFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Stack<Rectangle> stack = new Stack<Rectangle>();
	private Rectangle pravougaonik;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SFrame frame = new SFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Stack and sort");
		setBounds(100, 100, 544, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel stackPanel = new JPanel();
		stackPanel.setBackground(new Color(230, 230, 250));
		stackPanel.setBounds(0, 11, 536, 290);
		contentPane.add(stackPanel);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		stackPanel.add(textArea);
		textArea.setBounds(0, 11, 536, 290);
		
		JButton btnAdd = new JButton("Add Rectangle");
		btnAdd.setBackground(new Color(240, 248, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DRectangleM dlgRect = new DRectangleM();
				dlgRect.setVisible(true);
				int width = Integer.parseInt(dlgRect.getWidthField().getText());
				int height = Integer.parseInt(dlgRect.getHeightField().getText());
				int x = Integer.parseInt(dlgRect.getUpperXField().getText());
				int y = Integer.parseInt(dlgRect.getUpperYField().getText());
				Point upperLeft = new Point(x, y);
				pravougaonik = new Rectangle(upperLeft, width, height);
						
				if(dlgRect.isCommited()) {
					stack.push(pravougaonik);
					//System.out.println(stack);
					String stackString = stack.toString();
		            textArea.setText(stackString);
					
		         
					
				}
				
				
			}
		});
		btnAdd.setBounds(74, 309, 140, 23);
		contentPane.add(btnAdd);
		buttonGroup.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove Rectangle");
		btnRemove.setBackground(new Color(240, 248, 255));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(stack.isEmpty()) {
					JOptionPane.showMessageDialog(null, "The stack is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					Rectangle prom = stack.pop();
					//System.out.println(stack);
					String stackString = stack.toString();
		            textArea.setText(stackString);
					}
				}
		
				
			});
		
		
		btnRemove.setBounds(323, 309, 156, 23);
		contentPane.add(btnRemove);
		buttonGroup.add(btnRemove);
		
		JButton btnSort = new JButton("Sort ASC");
		btnSort.setBackground(new Color(240, 248, 255));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!stack.isEmpty()) {
			        Rectangle[] rectArray = stack.toArray(new Rectangle[stack.size()]);
			        Arrays.sort(rectArray, new Comparator<Rectangle>() {
			            public int compare(Rectangle rect1, Rectangle rect2) {
			                int area1 = rect1.getWidth() * rect1.getHeight();
			                int area2 = rect2.getWidth() * rect2.getHeight();
			                return area1 - area2;
			            }
			        });
			        stack.clear();
			        for (Rectangle rect : rectArray) {
			            stack.push(rect);
			        }
			        String stackString = stack.toString();
			        textArea.setText(stackString);
				} else {
					JOptionPane.showMessageDialog(null, "The stack is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSort.setBounds(224, 309, 89, 23);
		contentPane.add(btnSort);
		
		
		
	}
}
