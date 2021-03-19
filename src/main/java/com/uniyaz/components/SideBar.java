package com.uniyaz.components;

import com.uniyaz.dao.CategoryDao;
import com.uniyaz.domain.Category;
import com.uniyaz.domain.Icerik;
import com.uniyaz.services.IcerikService;
import com.uniyaz.view.IcerikGrid;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKARTAL on 8.3.2021.
 */
public class SideBar extends VerticalLayout {

    private ContentLayout contentLayout;
    private IcerikService icerikService = new IcerikService();

    public SideBar(ContentLayout contentLayout)     {
        this.contentLayout = contentLayout;
       // categoryList();
        fillSidebar();
        contentLayout.setWidth(100,Unit.PERCENTAGE);
        buildLayout();
    }

//    private void categoryList()
//    {
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
//        }
//    }


    public void fillSidebar() {
        this.removeAllComponents();
        List<Icerik> icerikList = new ArrayList<Icerik>();
        icerikList = icerikService.icerikList();
        for (Icerik icerik : icerikList) {
            Button button = new Button(icerik.getBaslik());
            button.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    IcerikGrid icerikGrid = new IcerikGrid(contentLayout);
                    contentLayout.setContentLayout(icerikGrid);
                }
            });
            this.addComponent(button);
        }
    }

    private void buildLayout()
    {

    }
}
