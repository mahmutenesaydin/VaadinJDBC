package com.uniyaz.components;

import com.uniyaz.dao.CategoryDao;
import com.uniyaz.domain.Category;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

public class MenuGetir {
    CategoryDao categoryDao = new CategoryDao();

    public MenuGetir() {

    }

    public CategoryDao getCategoryDao() {
        categoryDao.findAllCategory();
        return categoryDao;
    }

//    private void categoryList() {
//        CategoryDao categoryDao = new CategoryDao();
//        for (Category category : categoryDao.findAllCategory()) {
//            Button btn = new Button();
//            btn.setCaption(String.valueOf(category.getId()));
//            btn.setCaption(category.getCategoryName());
//            addComponent(btn);
//
//            btn.addClickListener(new Button.ClickListener() {
//                @Override
//                public void buttonClick(Button.ClickEvent clickEvent) {
//                }
//            });
}
