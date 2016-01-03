package gui.editor;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRenderer extends JButton implements ListCellRenderer<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6677992386337677345L;

	public ComboBoxRenderer() {
        setOpaque(false);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setPreferredSize(new Dimension(75, 75));

    }
	
	
	@Override
	/*
     * This method finds the image and text corresponding
     * to the selected value and returns the label, set up
     * to display the text and image.
     */
    public Component getListCellRendererComponent(
                                       JList<?> list,
                                       Object value,
                                       int index,
                                       boolean isSelected,
                                       boolean cellHasFocus) {
		setBorder(list.getBorder());
//		setBorder(UIManager.getBorder("JLabel.border"));

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setFont(list.getFont());

        ImageIcon icon = (ImageIcon) value;
        if (icon != null) {

            setIcon(icon);
            
        } 
        return this;
    }

}
