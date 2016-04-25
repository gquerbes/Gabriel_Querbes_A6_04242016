package it308.gmu.edu;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 519160
 */
public class MyJTable extends JTable {
        private String[] columnToolTips = {"First Name","Last Name", "Street Address", "State", "Zipcode", "Does he/she live in Apt", "Date of move in"};
    public MyJTable() {
        super();
    }
    
    public MyJTable(AbstractTableModel model) {
        super(model);
    }
    
    public TableCellRenderer getCellRenderer(int row, int column) {
        
        if (column != 5)   //updated     
        return new CustomTableCellRenderer();
         else
        return super.getCellRenderer(row, column);
    }
    
        @Override
    protected JTableHeader createDefaultTableHeader() {
        return new JTableHeader(columnModel) {
            @Override
            public String getToolTipText(MouseEvent e) {
                
                java.awt.Point p = e.getPoint();
                int index = columnModel.getColumnIndexAtX(p.x);
                int realIndex =
                        columnModel.getColumn(index).getModelIndex();
                return columnToolTips[realIndex];
            }
        };
     }
        
    @Override
    public String getToolTipText(MouseEvent me) {
        String text = null;
        Point p = me.getPoint();
        int rowInd = super.rowAtPoint(p);
        int colInd = super.columnAtPoint(p);
        TableModel m_model = super.getModel();

        int realColInd = super.convertColumnIndexToModel(colInd);

        //make sure the rowInd and realColInd are within the boundaries, otherwise you will see ArrayIndexOutofbounds exception.
        Object obj = (Object)  m_model.getValueAt(rowInd, realColInd);

        if (obj instanceof Boolean) {
            text = ((Boolean)obj).toString();
        }

        if (obj instanceof Integer) {
            text = ""+(Integer)obj;
        }

        if (obj instanceof String) {
            text = (String) obj;
        }
        
        if (obj instanceof Date) {
            text = obj.toString();
        }

        return text;
    }

}
