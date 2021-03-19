package com.uniyaz.components;

import com.uniyaz.ui.FirstUi;
import com.uniyaz.view.TableContact;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;

/**
 * Created by AKARTAL on 8.3.2021.
 */
public class Body extends HorizontalSplitPanel {

    public Body() {

        setSizeFull();
        setSplitPosition(15f);

        buildLayout();
    }

    private void buildLayout() {

        FirstUi firstUi = (FirstUi) UI.getCurrent();

       // TableContact tableContact = new TableContact();
      //  tableContact = firstUi.getTableContact();
      //  setSecondComponent(tableContact);
       // tableContact.removeAllComponents();

//        TableContact tableContact = new TableContact();
//        setSecondComponent(tableContact);
//        firstUi.setTableContact(tableContact);

        ContentLayout contentLayout = new ContentLayout();
        setSecondComponent(contentLayout);
        firstUi.setContentLayout(contentLayout);

        SideBar sideBar = new SideBar(contentLayout);
        setFirstComponent(sideBar);
        firstUi.setSideBar(sideBar);

//        ContentLayout contentLayout = new ContentLayout();
//        setSecondComponent(contentLayout);
//        FirstUi firstUi = (FirstUi) UI.getCurrent();
//        firstUi.setContentLayout(contentLayout);
//
//        SideBar sideBar = new SideBar(contentLayout);
//        setFirstComponent(sideBar);
//        firstUi.setSideBar(sideBar);
    }
}
