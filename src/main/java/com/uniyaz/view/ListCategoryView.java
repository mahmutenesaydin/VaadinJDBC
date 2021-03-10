package com.uniyaz.view;

import com.uniyaz.components.ContentLayout;
import com.vaadin.ui.HorizontalLayout;

import java.awt.*;

public class ListCategoryView extends HorizontalLayout
{
    private com.vaadin.ui.Button btnCategoryList;
    private ContentLayout contentLayout;

    public ListCategoryView()
    {
        btnCategoryList = new com.vaadin.ui.Button();
        btnCategoryList.addClickListener(new com.vaadin.ui.Button.ClickListener() {
            @Override
            public void buttonClick(com.vaadin.ui.Button.ClickEvent clickEvent) {
                ListCategoryView listCategoryView = new ListCategoryView();
                contentLayout.setContentLayout(listCategoryView);
            }
        });
        addComponent(btnCategoryList);
    }
//
//    public void buttonClick(Button.ClickEvent clickEvent) {
//        ListCategoryView listCategoryView = new ListCategoryView();
//        content.setContent(listCategoryView);
//    }
//});
//    addComponent(btnCategoryListMenuButton);
}
