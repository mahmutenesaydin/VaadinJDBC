package com.uniyaz.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 8.3.2021.
 */
public class Footer extends VerticalLayout {

    public Footer() {
        setSizeFull();
        buildLayout();
    }

    private void buildLayout() {
        Label footerLabel = new Label();
        footerLabel.setContentMode(ContentMode.HTML);
        footerLabel.setValue(FontAwesome.COPYRIGHT.getHtml() + "mhmtens13");
        footerLabel.setSizeUndefined();
        addComponent(footerLabel);

        setComponentAlignment(footerLabel, Alignment.MIDDLE_CENTER);
    }
}
