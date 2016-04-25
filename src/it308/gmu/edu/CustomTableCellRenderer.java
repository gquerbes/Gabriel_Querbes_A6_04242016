package it308.gmu.edu;


import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class CustomTableCellRenderer extends JLabel implements TableCellRenderer {
    public CustomTableCellRenderer() {
             super();
         }

    @Override
    public Component getTableCellRendererComponent(
                            JTable table, Object obj,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {

        Object value =  table.getValueAt(row, column);
        if (value instanceof Boolean) {
            return new JLabel( ((Boolean)value).toString());
        } else {
            return new JLabel("");
        }
    }
}
