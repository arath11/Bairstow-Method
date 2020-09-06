import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class myPanelBairstow extends JPanel implements ActionListener{
	
	private Bairstow bMethod;
	private JTextField 	tfDegree,
						tfPolynomial,
						tfDesiredError;
	private JTextArea	tfRoots;
	private JButton		btnAdd,
						btnRun,
						btnSet,
						btnReset;
	private int			counter,
						degcount;
	private double[]		arr;
	
	private String		polynomial="";
	
	public myPanelBairstow(){
		super();
		this.setPreferredSize(new Dimension(600,400));
		this.tfDegree = new JTextField("Degree of the polynomial", 15);
		this.tfPolynomial = new JTextField("Multiples of the polynomial", 15);
		this.tfDesiredError = new JTextField("Desired Error (in form XeN)", 20);
		this.tfRoots = new JTextArea("Roots of the Polynomial", 10, 50);
		this.btnSet=new JButton("Set Degree");
		this.btnAdd = new JButton("ADD Multiple to polynomial");
		this.btnRun = new JButton("RUN METHOD");
		this.btnReset = new JButton("Close");
		
		this.counter=0;
		this.degcount=0;
		
		this.tfRoots.setEditable(false);
		
		this.add(this.tfDegree);
		this.add(this.tfPolynomial);
		this.add(this.tfDesiredError);
		this.add(this.tfRoots);
		this.add(this.btnSet);
		this.add(this.btnAdd);
		this.add(this.btnRun);
		this.add(this.btnReset);
		
		this.btnAdd.addActionListener(this);
		this.btnSet.addActionListener(this);
		this.btnRun.addActionListener(this);
		this.btnReset.addActionListener(this);
		
	}
	
	public void reset() {
		this.tfDegree = new JTextField("Degree of the polynomial", 15);
		this.tfPolynomial = new JTextField("Multiples of the polynomial", 15);
		this.tfDesiredError = new JTextField("Desired Error (in form XeN)", 20);
		this.tfRoots = new JTextArea("Roots of the Polynomial", 10, 50);
		this.btnSet=new JButton("Set Degree");
		this.btnAdd = new JButton("ADD Multiple to polynomial");
		this.btnRun = new JButton("RUN METHOD");
		this.btnReset = new JButton("RESET");
		
		this.counter=0;
		this.degcount=0;
		
		this.tfRoots.setEditable(false);
		
		this.add(this.tfDegree);
		this.add(this.tfPolynomial);
		this.add(this.tfDesiredError);
		this.add(this.tfRoots);
		this.add(this.btnSet);
		this.add(this.btnAdd);
		this.add(this.btnRun);
		this.add(this.btnReset);
		
		this.btnAdd.addActionListener(this);
		this.btnSet.addActionListener(this);
		this.btnRun.addActionListener(this);
		this.btnReset.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnSet) {
			int degree = Integer.parseInt(this.tfDegree.getText());
			arr=new double[degree+1];
			this.degcount=1;
		}
		
		else if(e.getSource()==this.btnAdd) {
			if(degcount==1) {
				if(counter<arr.length) {
					arr[counter]=Double.parseDouble(this.tfPolynomial.getText());
					this.polynomial+=arr[counter]+", ";
					this.tfRoots.setText(this.polynomial);
				}
				counter++;
			}
			
		}
		
		else if(e.getSource()==this.btnRun) {
			double desiredError=Double.parseDouble(this.tfDesiredError.getText());
			int magnitude=arr.length-1;
			this.bMethod=new Bairstow(arr, magnitude, desiredError);
			this.bMethod.solve();
			this.tfRoots.setText(bMethod.getRoots());
		}
		else {
			System.exit(0);
		}
			
	}
		
}
	
	

