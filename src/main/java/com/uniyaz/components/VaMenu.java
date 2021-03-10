package com.uniyaz.components;

import com.uniyaz.ui.FirstUi;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

public class VaMenu extends MenuBar
{
    public VaMenu()
    {
//        final Label label = new Label("-");
//
//        MenuBar.Command command = new Command() {
//            MenuItem menuItem1 = null;
//            @Override
//            public void menuSelected(MenuItem menuItem) {
//                label.setValue("sfssvs" + menuItem.getText()+"afaeaf");
//
//                if (menuItem1 != null)
//                    menuItem1.setStyleName(null);
//                menuItem.setStyleName("highlight");
//                menuItem1 = menuItem;
//            }
//        };
//
//        addItem("kjnjnvrs", null,command);
//        addItem("sbvsnlsb", null,command);
//        addItem("ıhgıoewıowgıo", null,command);

        MenuBar menuBar = new MenuBar();
        menuBar.setWidth(100.0f, Unit.PERCENTAGE);

        MenuBar.MenuItem category = menuBar.addItem("Kategori",null,null);
        MenuBar.MenuItem addCategory=category.addItem("Katogori Ekle", new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {

                TextField txtAdd = new TextField();
                txtAdd.setCaption("Id");

                TextField txtCategory = new TextField();
                txtAdd.setCaption("Kategori Adı");

                Button btnAdd = new Button();
                btnAdd.setCaption("Kaydet");

                btnAdd.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        Button contentButton = new Button();
                        contentButton.setCaption(txtAdd.getValue());
                        contentButton.setSizeUndefined();
                        ((FirstUi)UI.getCurrent()).getSideBar().addComponent(contentButton);
                    }
                });
            }
        });


        MenuBar.MenuItem deleteCategory = category.addItem("Kategori Sil",null);


        MenuBar.MenuItem icerik = menuBar.addItem("İçerik", null,null);
        MenuBar.MenuItem addIcerik = icerik.addItem("İçerik Ekle", null);
        MenuBar.MenuItem deleteIcerik = icerik.addItem("İcerik sil",null);
    }
}
