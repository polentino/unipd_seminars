package org.casella.test;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class MyTabbedPanel extends Panel {
	private static final long serialVersionUID = 1L;

	private final TabbedPanel tabbedPanel;

	public MyTabbedPanel(String id, List tabs) {
		super(id);
		
		add(HeaderContributor.forCss(MyTabbedPanel.class, "MyTabbedPanel.css"));

		tabbedPanel = new AjaxTabbedPanel("mytabpanel", tabs) {
			private static final long serialVersionUID = 1L;

			// Override newLink to supply an IndicatingAjaxLink (wait cursor)
			@Override
			protected WebMarkupContainer newLink(String linkId, final int index) {
				final WebMarkupContainer c = new IndicatingAjaxLink(linkId) {
					private static final long serialVersionUID = 1L;

					public void onClick(AjaxRequestTarget target) {
						setSelectedTab(index);
						if (target != null) {
							target.addComponent(MyTabbedPanel.this);
						}
						onAjaxUpdate(target);
					}
				};
				return c;
			}
		};
		tabbedPanel.setOutputMarkupId(true);
		MyTabbedPanel.this.setOutputMarkupId(true);
		add(tabbedPanel);
	}

	public static class MyTab extends AbstractTab {
		private static final long serialVersionUID = 1L;

		private Panel p;

		public MyTab(String label) {
			super(new Model(label));
		}

		@Override
		public Panel getPanel(String panelId) {
			if (p == null) {
				// Lazily create the panel
				p = createPanel();
				if (!TabbedPanel.TAB_PANEL_ID.equals(p.getId())) {
					throw new IllegalArgumentException(
							"Panel id must be TabbedPanel.TAB_PANEL_ID");
				}
				p.setOutputMarkupId(true);
			}
			return p;
		}

		protected Panel createPanel() {
			throw new IllegalArgumentException("Must provide a panel");
		}
	}
}
