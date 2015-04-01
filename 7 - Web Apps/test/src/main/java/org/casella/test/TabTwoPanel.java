package org.casella.test;

import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class TabTwoPanel extends Panel {
	 public TabTwoPanel()
	 {
	  super(TabbedPanel.TAB_PANEL_ID);

	  add(new Label("mylabel", "insert firmware details here"));
	 }
}
