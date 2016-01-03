package project;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class KalenderWindow extends JFrame{

		DefaultTableModel model;
		Calendar _kalender = new GregorianCalendar();
		JLabel label;
		JButton	anmeldung;
		JButton	tagesansicht;
		JButton	wochenansicht;
		JButton	monatsansicht;
		JButton	jahresansicht;

		public KalenderWindow(){

				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setTitle("Kalender");
				this.setSize(600,600);
				this.setLayout(new BorderLayout());
				this.setVisible(true);

				label = new JLabel();
				label.setHorizontalAlignment(SwingConstants.CENTER);

				JButton zurueck = new JButton("einen Monat zurück");
				zurueck.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae) {
								_kalender.add(Calendar.MONTH, -1);
								updateMonth();
						}
				});

				JButton vor = new JButton("einen Monat vor");
				vor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae) {
								_kalender.add(Calendar.MONTH, +1);
								updateMonth();
						}
				});

				JPanel panel = new JPanel();
				panel.setLayout(new BorderLayout());
				panel.add(zurueck,BorderLayout.WEST);
				panel.add(label,BorderLayout.CENTER);
				panel.add(vor,BorderLayout.EAST);

				String [] columns = {"So","Mo","Di","Mi","Do","Fr","Sa"};
				model = new DefaultTableModel(null,columns);
				JTable table = new JTable(model);
				table.setGridColor(Color.GRAY);
				for(int i=0; i<7; i++){
						table.getColumnModel().getColumn(i).setPreferredWidth(100);
						table.setRowHeight(100);
				}
				JScrollPane pane = new JScrollPane(table);

				this.add(panel,BorderLayout.NORTH);
				this.add(pane,BorderLayout.CENTER);

				this.updateMonth();

/**				// Instanzieren Button:
				anmeldung = new JButton("Anmeldung");
				tagesansicht = new JButton("Tagesansicht");
				wochenansicht = new JButton("Wochenansicht");
				monatsansicht = new JButton("Monatsansicht");
				jahresansicht = new JButton("Jahresansicht");

				// Positionen festlegen
				anmeldung.setBounds(100,110,100,30);
				tagesansicht.setBounds(200,110,100,30);
				wochenansicht.setBounds(300,110,100,30);
				monatsansicht.setBounds(400,110,100,30);
				jahresansicht.setBounds(500,110,100,30);

				// Elemente dem Fenster hinzufügen:
				this.getContentPane().add(anmeldung);
				this.getContentPane().add(tagesansicht);
				this.getContentPane().add(wochenansicht);
				this.getContentPane().add(monatsansicht);
				this.getContentPane().add(jahresansicht);

				this.pack();		*/
		}

		void updateMonth() {
		    _kalender.set(Calendar.DAY_OF_MONTH, 1);

		    String monat = _kalender.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		    int jahr = _kalender.get(Calendar.YEAR);
		    label.setText(monat + " " + jahr);

		    int startTag = _kalender.get(Calendar.DAY_OF_WEEK);
		    int anzahlTage = _kalender.getActualMaximum(Calendar.DAY_OF_MONTH);
		    int anzahlWochen = _kalender.getActualMaximum(Calendar.WEEK_OF_MONTH);

		    model.setRowCount(0);
		    model.setRowCount(anzahlWochen);

		    int i = startTag-1;
		    for(int tag=1; tag<=anzahlTage; tag++){
//						if(Calendar.DAY_OF_MONTH*Calendar.WEEK_OF_MONTH == tag){
//								table.getColumn(table.getColumnName()).setBackground(Color.Red);
//		    		}
		      	model.setValueAt(tag, i/7 , i%7 );
		      	i = i + 1;
	  		}
		}

}
