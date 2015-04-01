package org.casella.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
import org.casella.test.MyTabbedPanel.MyTab;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	@SuppressWarnings("unchecked")
	public HomePage(final PageParameters parameters) {

		final List tabs = new ArrayList();

		tabs.add(new MyTab("Model Editor") {
			private static final long serialVersionUID = 1L;

			@Override
			public Panel createPanel() {
				return new TabOnePanel();
			}
		});

		tabs.add(new MyTab("Firmware Bank Editor") {
			private static final long serialVersionUID = 1L;

			@Override
			public Panel createPanel() {
				return new TabTwoPanel();
			}
		});

		final MyTabbedPanel tabpanel = new MyTabbedPanel("tabpanel", tabs);
		add(tabpanel);
	}
}
