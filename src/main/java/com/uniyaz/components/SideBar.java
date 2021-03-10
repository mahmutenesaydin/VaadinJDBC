package com.uniyaz.components;

import com.uniyaz.dao.CategoryDao;
import com.uniyaz.domain.Category;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by AKARTAL on 8.3.2021.
 */
public class SideBar extends VerticalLayout {

    private ContentLayout contentLayout;
    // private MenuGetir menuGetir;


    public SideBar(ContentLayout contentLayout) {
        this.contentLayout = contentLayout;
        categoryList();
        contentLayout.setWidth(100,Unit.PERCENTAGE);
        buildLayout();
    }

    private void categoryList() {
        CategoryDao categoryDao = new CategoryDao();
        for (Category category : categoryDao.findAllCategory()) {
            Button btn = new Button();
            btn.setCaption(String.valueOf(category.getId()));
            btn.setCaption(category.getCategoryName());
            addComponent(btn);

            btn.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                }
            });
        }
    }

    private void buildLayout()
    {

    }
}
