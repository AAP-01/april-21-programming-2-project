import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PoliceSystemGUI extends JFrame {

    private ArrayList<PoliceStaff> employees = new ArrayList<>();
    private JTextArea displayArea;

    public PoliceSystemGUI() {
        setTitle("Police Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 650);
        setLocationRelativeTo(null); // Centers the window on screen

        // Create the JTabbedPane
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Add Employee", createAddPanel());
        tabs.addTab("Search", createSearchPanel());
        tabs.addTab("Display All", createDisplayPanel());

        add(tabs, BorderLayout.CENTER);
    }

    private JPanel createAddPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Create form panel with GridLayout
        JPanel form = new JPanel(new GridLayout(13, 2, 10, 10));

        JTextField idField = new JTextField();
        JTextField fNameField = new JTextField();
        JTextField lNameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField badgeField = new JTextField();
        JTextField rankField = new JTextField();
        JTextField serialField = new JTextField();
        JCheckBox armedCheck = new JCheckBox();
        JTextField callsignField = new JTextField();
        JTextField unitField = new JTextField();

        form.add(new JLabel("Employee ID:")); form.add(idField);
        form.add(new JLabel("First Name:")); form.add(fNameField);
        form.add(new JLabel("Last Name:")); form.add(lNameField);
        form.add(new JLabel("Age:")); form.add(ageField);
        form.add(new JLabel("Address:")); form.add(addressField);
        form.add(new JLabel("Phone:")); form.add(phoneField);
        form.add(new JLabel("Department:")); form.add(deptField);
        form.add(new JLabel("Badge Number:")); form.add(badgeField);
        form.add(new JLabel("Rank:")); form.add(rankField);
        form.add(new JLabel("Badge Serial:")); form.add(serialField);
        form.add(new JLabel("Is Armed:")); form.add(armedCheck);
        form.add(new JLabel("Callsign:")); form.add(callsignField);
        form.add(new JLabel("Unit Callsign:")); form.add(unitField);

        JLabel resultLabel = new JLabel(" ");
        resultLabel.setForeground(new Color(0, 153, 0)); // Green text
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton calculateButton = new JButton("Add Patrol Officer");
        calculateButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                int age = Integer.parseInt(ageField.getText().trim());

                PatrolOfficer p = new PatrolOfficer(
                        id, fNameField.getText().trim(), lNameField.getText().trim(), age,
                        LocalDate.now(), addressField.getText().trim(), phoneField.getText().trim(),
                        deptField.getText().trim(), badgeField.getText().trim(), rankField.getText().trim(),
                        serialField.getText().trim(), armedCheck.isSelected(), callsignField.getText().trim(), unitField.getText().trim()
                );

                employees.add(p);
                resultLabel.setText("Employee added successfully!");

                // Clear fields
                idField.setText(""); fNameField.setText(""); lNameField.setText(""); ageField.setText("");
                addressField.setText(""); phoneField.setText(""); deptField.setText(""); badgeField.setText("");
                rankField.setText(""); serialField.setText(""); armedCheck.setSelected(false);
                callsignField.setText(""); unitField.setText("");

            } catch (NumberFormatException ex) {
                showInputError();
            }
        });

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        bottomPanel.add(calculateButton);
        bottomPanel.add(resultLabel);

        panel.add(form, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createSearchPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel topPanel = new JPanel(new FlowLayout());
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Search by ID");

        topPanel.add(new JLabel("Enter ID:"));
        topPanel.add(searchField);
        topPanel.add(searchButton);

        JTextArea resultArea = new JTextArea("Results will appear here.");
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultArea);

        searchButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(searchField.getText().trim());
                for (PoliceStaff p : employees) {
                    if (p.getEmployeeID() == id) {
                        resultArea.setText("Found Employee:\n\n" + p.toString());
                        return;
                    }
                }
                resultArea.setText("Employee not found with ID: " + id);
            } catch (NumberFormatException ex) {
                showInputError();
            }
        });

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createDisplayPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(displayArea);

        JButton refreshButton = new JButton("Refresh List");
        refreshButton.addActionListener(e -> {
            if (employees.isEmpty()) {
                displayArea.setText("No employees found.");
                return;
            }
            StringBuilder sb = new StringBuilder("ALL EMPLOYEES\n\n");
            for (PoliceStaff p : employees) {
                sb.append(p.toString()).append("\n\n");
            }
            displayArea.setText(sb.toString());
            displayArea.setCaretPosition(0);
        });

        panel.add(refreshButton, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void showInputError() {
        JOptionPane.showMessageDialog(this,
                "Please enter valid numeric values for ID and Age.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PoliceSystemGUI frame = new PoliceSystemGUI();
            frame.setVisible(true);
        });
    }
}