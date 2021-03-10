package com.uniyaz.components;

import com.uniyaz.db.DbOperations;
import com.uniyaz.domain.Category;
import com.uniyaz.services.CategoryService;
import com.uniyaz.ui.FirstUi;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

/**
 * Created by AKARTAL on 8.3.2021.
 */
public class Header extends HorizontalLayout {

    DbOperations dbOperations = new DbOperations();
    private DbOperations dbO;


    public Header() {
        setSizeFull();

        buildLayout();
    }

    private void buildLayout()
    {

        MenuBar menuBar = new MenuBar();
        menuBar.setWidth(100.0f, Unit.PERCENTAGE);

        MenuBar.MenuItem category = menuBar.addItem("Kategori",null,null);
        MenuBar.MenuItem addCategory=category.addItem("Katogori Ekle", FontAwesome.EDIT,new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {

                final FirstUi firstUi = (FirstUi) UI.getCurrent();
                ContentLayout contentLayout = firstUi.getContentLayout();
                contentLayout.removeAllComponents();

//                TextField txtId = new TextField();
//                txtId.setCaption("Id");
//                contentLayout.addComponent(txtId);

                TextField txtCategory = new TextField();
                txtCategory.setCaption("Kategori Adı");
                contentLayout.addComponent(txtCategory);

                Button btnAdd = new Button("Ekle");
                contentLayout.addComponent(btnAdd);

                btnAdd.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {

                        if (txtCategory.getValue() != null)
                        {
                            Category category1 = new Category(txtCategory.getValue());
                            CategoryService  categoryService = new CategoryService();
                            categoryService.addKategori(txtCategory.getValue());

                            Button contentButton = new Button();
                            contentButton.setCaption(txtCategory.getValue());
                            contentButton.setSizeUndefined();
                            firstUi.getSideBar().addComponent(contentButton);
                        }
                    }
                });
            }
        });

        MenuBar.MenuItem deleteCategory = category.addItem("Kategori Sil", FontAwesome.ERASER, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                final FirstUi firstUi = (FirstUi) UI.getCurrent();
                ContentLayout contentLayout = firstUi.getContentLayout();
                contentLayout.removeAllComponents();

                TextField txtId = new TextField();
                txtId.setCaption("Id");
                contentLayout.addComponent(txtId);

                Button btnDelete = new Button("Sil");
                contentLayout.addComponent(btnDelete);

                btnDelete.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {

                        if (txtId.getValue() != null)
                        {
                            Category category1 = new Category(txtId.getValue());
                            CategoryService  categoryService = new CategoryService();
                            categoryService.deleteKategori(Integer.parseInt(txtId.getValue()));
                        }
                    }
                });
            }
        });

        MenuBar.MenuItem icerik = menuBar.addItem("İçerik", null,null);
        MenuBar.MenuItem addIcerik = icerik.addItem("İçerik Ekle", null);
        MenuBar.MenuItem deleteIcerik = icerik.addItem("İcerik sil",null);

        addComponent(menuBar);
    }
}
