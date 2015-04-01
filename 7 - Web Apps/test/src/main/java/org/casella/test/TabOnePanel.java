package org.casella.test;

import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class TabOnePanel extends Panel {
	private static final long serialVersionUID = 1L;

	public TabOnePanel() {
		super(TabbedPanel.TAB_PANEL_ID);

		add(new Label("mylabel", "insert model details here"));
	}
}