package it308.gmu.edu;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import it308.gmu.edu.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;


class MyTableModel extends AbstractTableModel
        implements TableModelListener {
private Object[] names = {"Event ID", "Description","Date", "Address", "State", "City", "Zip","Delete"};
private static Vector data = new Vector(10);

private static Object[][] data1 = {
        {"0001", "event1", new Date("01/01/2010"), "1234 ABC Street", "VA", "fairfax","22111", false },
        {"0002", "event2", new Date("04/01/2010"), "1234 fake Street", "VA", "fairfax","22111", false },
    };

public MyTableModel() {
        for (int i = 0; i<1; i++) {
            Event event = new Event();
            
            event.setId((String) data1[i][0]);
            event.setDescription((String) data1[i][1]);
            event.setDate((Date)data1[i][2]);
            event.setAddress((String)data1[i][3]);
            event.setState((String)data1[i][4]);
            event.setCity((String)data1[i][5]);
            event.setZip((String)data1[i][6]);
            event.setDelete(((Boolean)data1[i][7]));
            
            
           data.add(event);
        
        }
}

@Override
public String getColumnName(int i) {
    return (String) names[i];
}

public Object getValueAt(int r, int c) {
        Event event = (Event) data.get(r);
        return event.getValue(c);
 
}

@Override
public Class getColumnClass(int c) {
        if (c == 4) return Integer.class;
        if (c == 5) return Boolean.class;
        if ( c == 6) return Date.class;
        return String.class;
}

@Override
public void setValueAt(Object value, int r, int c) {
//        System.out.println(" Value Changed for Row = " + r + " Col = " + c + " :: " +  value);
//        Address add = (Address) data.get(r);
//        add.setValue(c, value);
}

public int getColumnCount() { return names.length;}

public int getRowCount() {return data.size();}

@Override
public boolean isCellEditable(int r, int c) {
    if (c == 3) return true;
    if (c == 6) return true;
    if (c == 2) return true;
    return false;
}
public void tableChanged(TableModelEvent tme) {
        int row = tme.getFirstRow();
        int col = tme.getColumn();
        int type = tme.getType();
        System.out.println(" Row Changed = " + row);
        System.out.println(" Col Changed = " + col);
        System.out.println(" Operation = " + type);

    }

/**
public void actionPerformed(ActionEvent ae) {
    Address add = (Address) data.get(4);
    add.setValue(0, "John");
    add.setValue(1, "Smith");
    add.setValue(2, "1223 Oak Street");
    add.setValue(3, "VA");
    add.setValue(4, "90876");
    add.setValue(5, true);

    Address add1 = new Address();
    add1.setValue(0, "Roger");
    add1.setValue(1, "Waters");
    add1.setValue(2, "122 Oak Street");
    add1.setValue(3, "VA");
    add1.setValue(4, "90876");
    add1.setValue(5, true);
    data.add(add1);

    super.fireTableDataChanged();
}
**/

//public void editData(ActionEvent ae) {
//        long number = Math.round(Math.random()*10);
//        
//        if (number >= data.size()) {number = data.size() - 1;}
//        
//        Address add = (Address) data.get((int)number);
//        add.setValue(0, "John");
//        add.setValue(1, "Smith");
//        add.setValue(2, "1223 Oak Street");
//        add.setValue(3, "VA");
//        add.setValue(4, "90876");
//        add.setValue(5, true);
//        add.setValue(6, new Date("10/10/2010"));
//
//        super.fireTableRowsUpdated((int)number, (int)number);
//        
//  }

//public void addData(ActionEvent ae) {
//        
//        Event add1 = new Event();
//        add1.setValue(0, "Walter");
//        add1.setValue(1, "Smith");
//        add1.setValue(2, "122 Elm Street");
//        add1.setValue(3, "VA");
//        add1.setValue(4, "90876");
//        add1.setValue(5, true);
//        add1.setValue(6, new Date("10/10/2010"));
//        data.add(add1);
//
//        super.fireTableRowsInserted(data.size()-1, data.size()-1);
//  }

}
