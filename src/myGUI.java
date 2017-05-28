import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import java.awt.Component;

public class myGUI extends JFrame {
	
	SQLiteDB DB = new SQLiteDB();

	private JPanel contentPane;
	private JTextField fname_TB;
	private JTextField lname_TB;

	DoubleLinkedList dll = new DoubleLinkedList();
	private JTextField symptoms_TB;
	private JTextField priority_TB;
	private JTextField treatmentSummary_TF;
	private JTextField nextOfKin_TF;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myGUI frame = new myGUI();
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
	public myGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(2, 13, 326, 336);
		contentPane.add(tabbedPane);
		
		JPanel ReceptionAdmin = new JPanel();
		tabbedPane.addTab("Administration", null, ReceptionAdmin, null);
		ReceptionAdmin.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 13, 62, 16);
		ReceptionAdmin.add(lblFirstName);
		
		fname_TB = new JTextField();
		fname_TB.setBounds(112, 13, 197, 22);
		ReceptionAdmin.add(fname_TB);
		fname_TB.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(12, 63, 76, 16);
		ReceptionAdmin.add(lblLastName);
		
		symptoms_TB = new JTextField();
		symptoms_TB.setBounds(112, 189, 197, 22);
		ReceptionAdmin.add(symptoms_TB);
		symptoms_TB.setColumns(10);
		
		JLabel lblSymptoms = new JLabel("Symptoms");
		lblSymptoms.setBounds(10, 192, 60, 16);
		ReceptionAdmin.add(lblSymptoms);
		
		lname_TB = new JTextField(10);
		lname_TB.setBounds(111, 60, 198, 22);
		ReceptionAdmin.add(lname_TB);
		lname_TB.setColumns(10);
		
				
				
				JButton btnSave = new JButton("Save Patient");
				btnSave.setBounds(10, 236, 116, 25);
				ReceptionAdmin.add(btnSave);
				
				JLabel patientAdded_Label = new JLabel("");
				patientAdded_Label.setBounds(12, 277, 297, 16);
				ReceptionAdmin.add(patientAdded_Label);
				
				JLabel lblAge = new JLabel("Age");
				lblAge.setBounds(10, 111, 56, 16);
				ReceptionAdmin.add(lblAge);
				
				JSpinner age_Spinner = new JSpinner();
				age_Spinner.setBounds(51, 108, 30, 22);
				ReceptionAdmin.add(age_Spinner);
				
				JLabel lblNextOfKin = new JLabel("Next of Kin");
				lblNextOfKin.setBounds(10, 143, 76, 16);
				ReceptionAdmin.add(lblNextOfKin);
				
				nextOfKin_TF = new JTextField();
				nextOfKin_TF.setBounds(112, 140, 197, 22);
				ReceptionAdmin.add(nextOfKin_TF);
				nextOfKin_TF.setColumns(10);
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String fname = fname_TB.getText();
						String lname = lname_TB.getText();
						String symptoms = symptoms_TB.getText();
						int age = (int) age_Spinner.getValue();
						String nextOfKin = nextOfKin_TF.getText();
						
						Patient tmp = new Patient(fname, lname, symptoms, age, nextOfKin);
						dll.add(tmp);
						DB.insert(fname, lname, age, nextOfKin, symptoms);
						
						patientAdded_Label.setText(fname + " " + lname + " was added.");
						System.out.println("Patient: " + fname + " " + lname + " is aged " + age + 
								" their next of kin is " + nextOfKin + ", and they have symptoms: " + symptoms);
						
						fname_TB.setText("");
						lname_TB.setText("");
						symptoms_TB.setText("");
						age_Spinner.setValue(0);
						nextOfKin_TF.setText("");
					}
				});
		
		JPanel TraigeNurse = new JPanel();
		tabbedPane.addTab("Triage Nurse", null, TraigeNurse, null);
				TraigeNurse.setLayout(null);
		
				JLabel lblPriority = new JLabel("Priority ( 1 - 9)");
				lblPriority.setBounds(12, 242, 101, 16);
				TraigeNurse.add(lblPriority);
				
				priority_TB = new JTextField(10);
				priority_TB.setBounds(125, 239, 75, 22);
				TraigeNurse.add(priority_TB);
				priority_TB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				priority_TB.setColumns(10);
				
						JLabel symptomsOutput_LBL = new JLabel("");
						symptomsOutput_LBL.setBounds(12, 141, 297, 70);
						TraigeNurse.add(symptomsOutput_LBL);
						
						JButton NextPatient_Button = new JButton("Next Patient");
						NextPatient_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
						NextPatient_Button.setBounds(98, 13, 116, 25);
						TraigeNurse.add(NextPatient_Button);
						
						JLabel lblPatientSymptoms = new JLabel("Patient Symptoms:");
						lblPatientSymptoms.setBounds(12, 112, 116, 16);
						TraigeNurse.add(lblPatientSymptoms);
						
						JLabel patientNameOutput = new JLabel("");
						patientNameOutput.setBounds(98, 64, 116, 16);
						TraigeNurse.add(patientNameOutput);
						
						JLabel priorityUpdate_Button = new JLabel("");
						priorityUpdate_Button.setBounds(12, 277, 297, 16);
						TraigeNurse.add(priorityUpdate_Button);
						NextPatient_Button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
							
								Node node = dll.updatePriority();
								
								if (node == null) {
									patientNameOutput.setText("There are no patients right now!");
								} 
								else {
									patientNameOutput.setText(((Patient)node.getData()).firstname + " " + ((Patient)node.getData()).lastname);
									symptomsOutput_LBL.setText(((Patient)node.getData()).symptoms);
								}
							}
						});
						
						JButton btnSetPriotity = new JButton("Set Priotity");
						btnSetPriotity.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								int enter = Integer.parseInt(priority_TB.getText());
								
								Node node = dll.updatePriority();
								
								if (enter < 1 || enter > 9){
									priorityUpdate_Button.setText("Please ensure priorty is an Integer between 1 and 9");
								}
								else {
									((Patient)node.getData()).priority = enter;
									String fullname = ((Patient)node.getData()).firstname + " " + ((Patient)node.getData()).lastname;
									priorityUpdate_Button.setText("Patient " + fullname + " assigned priority " + enter);
								}
								patientNameOutput.setText("");
								symptomsOutput_LBL.setText("");
								priority_TB.setText("");
							}
						});
						btnSetPriotity.setBounds(212, 238, 97, 25);
						TraigeNurse.add(btnSetPriotity);
						
						
						
					
		
		JPanel Doctor = new JPanel();
		tabbedPane.addTab("Doctor", null, Doctor, null);
		Doctor.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Summary of Treatment");
		lblNewLabel.setBounds(12, 129, 144, 16);
		Doctor.add(lblNewLabel);
		
		treatmentSummary_TF = new JTextField();
		treatmentSummary_TF.setBounds(12, 158, 297, 97);
		Doctor.add(treatmentSummary_TF);
		treatmentSummary_TF.setColumns(10);
		
		JLabel lblPatientSymptoms_1 = new JLabel("Symptoms:");
		lblPatientSymptoms_1.setBounds(12, 51, 297, 41);
		Doctor.add(lblPatientSymptoms_1);
		
		JLabel lblPatientName_1 = new JLabel("Patient: ");
		lblPatientName_1.setBounds(142, 17, 167, 16);
		Doctor.add(lblPatientName_1);
		
		JButton btnNextPatient = new JButton("Next Patient");
		btnNextPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (dll.size > 0){
					Node node = dll.findHighestPriority();
					
					lblPatientSymptoms_1.setText("Symptoms: " + ((Patient)node.getData()).symptoms);
					lblPatientName_1.setText("Patient: " + ((Patient)node.getData()).firstname + " " + ((Patient)node.getData()).lastname);
				}
				else if (dll.size == 0){
					lblPatientName_1.setText("There are no more patients.");
				}
			}
		});
		btnNextPatient.setBounds(12, 13, 118, 25);
		Doctor.add(btnNextPatient);
		
		
		JButton btnSubmitSummary = new JButton("Submit Summary");
		btnSubmitSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String summary = treatmentSummary_TF.getText();
				Node node = dll.findHighestPriority();
				
				String fname = ((Patient)node.getData()).firstname;
				String lname = ((Patient)node.getData()).lastname;
				
				((Patient)node.getData()).setTreatment(summary);
				DB.addTreatment(summary, fname, lname);
				
				int pos = dll.findByPosition(node);
				
				dll.remove(pos);
				
				lblPatientName_1.setText("Patient:");
				lblPatientSymptoms_1.setText("Symptoms:");
				treatmentSummary_TF.setText("");
				
			}
		});
		btnSubmitSummary.setBounds(12, 268, 144, 25);
		Doctor.add(btnSubmitSummary);


	}
}
