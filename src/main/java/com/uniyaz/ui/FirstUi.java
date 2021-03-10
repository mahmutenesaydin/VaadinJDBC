package com.uniyaz.ui;

import com.uniyaz.components.ContentLayout;
import com.uniyaz.components.Main;
import com.uniyaz.components.MenuGetir;
import com.uniyaz.components.SideBar;
import com.uniyaz.view.TableContact;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.table.TableState;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

/**
 * Created by AKARTAL on 8.3.2021.
 */
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class FirstUi extends UI {

    private SideBar sideBar;
    private ContentLayout contentLayout;
    private MenuGetir menuGetir;
    private TableContact tableContact;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Main main = new Main();
        setContent(main);
    }

    public SideBar getSideBar() {
        return sideBar;
    }

    public void setSideBar(SideBar sideBar) {
        this.sideBar = sideBar;
    }

    public ContentLayout getContentLayout() {
        return contentLayout;
    }

    public void setContentLayout(ContentLayout contentLayout) {
        this.contentLayout = contentLayout;
    }

    public TableContact getTableContact() {
        return tableContact;
    }

    public void setTableContact(TableContact tableContact) {
        this.tableContact = tableContact;
    }


    public MenuGetir getMenuGetir() {
        return menuGetir;
    }

    public void setMenuGetir(MenuGetir menuGetir) {
        this.menuGetir = menuGetir;
    }
}