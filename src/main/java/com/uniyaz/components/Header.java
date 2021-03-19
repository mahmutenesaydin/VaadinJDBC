package com.uniyaz.components;

import com.uniyaz.IcerikAdd;
import com.uniyaz.dao.CategoryDao;
import com.uniyaz.dao.IcerikDao;
import com.uniyaz.db.DbOperations;
import com.uniyaz.domain.Category;
import com.uniyaz.domain.Icerik;
import com.uniyaz.fields.CategoryCombo;
import com.uniyaz.services.CategoryService;
import com.uniyaz.services.IcerikService;
import com.uniyaz.ui.FirstUi;
import com.uniyaz.view.*;
import com.vaadin.client.ui.VFilterSelect;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

import java.util.List;

/**
 * Created by AKARTAL on 8.3.2021.
 */
public class Header extends HorizontalLayout {

//    DbOperations dbOperations = new DbOperations();
//    private DbOperations dbO;

    ContentLayout contentLayout1 = new ContentLayout();

    public Header() {
        setSizeFull();
        buildLayout();
    }

    private void buildLayout() {

        ContentLayout contentLayout = new ContentLayout();

        MenuBar menuBar = new MenuBar();
        menuBar.setWidth(100.0f, Unit.PERCENTAGE);

//        MenuBar.MenuItem category = menuBar.addItem("Kategori", null, null);
//        MenuBar.MenuItem addCategory = category.addItem("Katogori Ekle", FontAwesome.EDIT, new MenuBar.Command() {
//            @Override
//            public void menuSelected(MenuBar.MenuItem menuItem) {
//
//                final FirstUi firstUi = (FirstUi) UI.getCurrent();
//                ContentLayout contentLayout = firstUi.getContentLayout();
//                contentLayout.removeAllComponents();
//
////                TextField txtId = new TextField();
////                txtId.setCaption("Id");
////                contentLayout.addComponent(txtId);
//
//                TextField txtCategory = new TextField();
//                txtCategory.setCaption("Kategori Adı");
//                contentLayout.addComponent(txtCategory);
//
//                Button btnAdd = new Button("Ekle");
//                contentLayout.addComponent(btnAdd);
//
//                btnAdd.addClickListener(new Button.ClickListener() {
//                    @Override
//                    public void buttonClick(Button.ClickEvent clickEvent) {
//
//                        if (txtCategory.getValue() != null) {
//                            Category category1 = new Category(txtCategory.getValue());
//                            CategoryService categoryService = new CategoryService();
//                            categoryService.addKategori(txtCategory.getValue());
//
//                            Button contentButton = new Button();
//                            contentButton.setCaption(txtCategory.getValue());
//                            contentButton.setSizeUndefined();
//                            firstUi.getSideBar().addComponent(contentButton);
//                        }
//                    }
//                });
//            }
//        });
//
//        MenuBar.MenuItem deleteCategory = category.addItem("Kategori Sil", FontAwesome.ERASER, new MenuBar.Command() {
//            @Override
//            public void menuSelected(MenuBar.MenuItem menuItem) {
//                final FirstUi firstUi = (FirstUi) UI.getCurrent();
//                ContentLayout contentLayout = firstUi.getContentLayout();
//                contentLayout.removeAllComponents();
//
//                TextField txtId = new TextField();
//                txtId.setCaption("Id");
//                contentLayout.addComponent(txtId);
//
//                Button btnDelete = new Button("Sil");
//                contentLayout.addComponent(btnDelete);
//
//                btnDelete.addClickListener(new Button.ClickListener() {
//                    @Override
//                    public void buttonClick(Button.ClickEvent clickEvent) {
//
//                        if (txtId.getValue() != null) {
//                            Category category1 = new Category(txtId.getValue());
//                            CategoryService categoryService = new CategoryService();
//                            categoryService.deleteKategori(Integer.parseInt(txtId.getValue()));
//                        }
//                    }
//                });
//            }
//        });
//
//        MenuBar.MenuItem listCategory = category.addItem("Kategori Listele", FontAwesome.LIST, new MenuBar.Command() {
//                    @Override
//                    public void menuSelected(MenuBar.MenuItem menuItem) {
//                        Table table = new Table("Kategori LISTESI");
//                        table.addContainerProperty("ID", Integer.class, null);
//                        table.addContainerProperty("CATEGORY_NAME", String.class, null);
//                        table.addContainerProperty("SIL", Button.class, null);
//                        table.addContainerProperty("", ContentLayout.class, null);
//
//                        CategoryDao categoryDao = new CategoryDao();
//                        List<Category> categoryList = categoryDao.findAllCategory();
//
//                        for (Category category : categoryList) {
//                            Integer itemId = new Integer(category.getId());
//                            Object newItemId = table.addItem();
//                            Item row1 = table.getItem(newItemId);
//                            row1.getItemProperty("ID").setValue(category.getId());
//                            row1.getItemProperty("CATEGORY_NAME").setValue(category.getCategoryName());
//
//                            Button deleteButton = new Button("SİL");
//                            deleteButton.setData(itemId);
//                            deleteButton.addClickListener(new Button.ClickListener() {
//                                @Override
//                                public void buttonClick(Button.ClickEvent event) {
//                                    Category category1 = new Category();
//                                    CategoryDao categoryDao1 = new CategoryDao();
//
//                                    Integer id = (Integer) event.getButton().getData();
//                                    categoryDao1.deleteCategory(category1.getId());
//                                    Notification.show(id.intValue() + "KAYIT SİLİNDİ");
//
////                            Category category1 = new Category(txtId.getValue());
////                            CategoryService categoryService = new CategoryService();
////                            categoryService.deleteKategori(Integer.parseInt(txtId.getValue()));
//
//                                }
//                            });
//                            //contentLayout.removeAllComponents();
//                            contentLayout.addComponents(deleteButton);
//                            row1.getItemProperty("").setValue(contentLayout);
//                            addComponent(table);
//                        };
//                    }


        MenuBar.MenuItem icerik = menuBar.addItem("İçerik", null, null);
        MenuBar.MenuItem addIcerik = icerik.addItem("İçerik Ekle", FontAwesome.EDIT, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                final FirstUi firstUi = (FirstUi) UI.getCurrent();
                ContentLayout contentLayout = firstUi.getContentLayout();
                contentLayout.removeAllComponents();

                IcerikAdd icerikAdd = new IcerikAdd(new Icerik());
                contentLayout.setContentLayout(icerikAdd);
            }
        });

        MenuBar.MenuItem updateIcerik = icerik.addItem("Guncelle", FontAwesome.EDIT, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                final FirstUi firstUi = (FirstUi) UI.getCurrent();
                ContentLayout contentLayout = firstUi.getContentLayout();
                contentLayout.removeAllComponents();

                IcerikUpdate icerikUpdate = new IcerikUpdate(new Icerik());
                contentLayout.setContentLayout(icerikUpdate);
            }
        });

        MenuBar.MenuItem listIcerik = icerik.addItem("Listele", FontAwesome.LIST, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                final FirstUi firstUi = (FirstUi) UI.getCurrent();
                ContentLayout contentLayout = firstUi.getContentLayout();
                contentLayout.removeAllComponents();

               IcerikListPage icerikList = new IcerikListPage();
               contentLayout.setContentLayout(icerikList);
            }
        });
        addComponent(menuBar);
    }
}


//
//                Icerik icerik1 = new Icerik();
//                BeanItem<Icerik> itemIcerik = new BeanItem<>(icerik1);
//                TextField baslikTxt = new TextField("Başlık", itemIcerik.getItemProperty("baslik"));
//                TextField detayTxt = new TextField("Detay", itemIcerik.getItemProperty("detay"));
//                TextField categoryTxt = new TextField("Kategori", itemIcerik.getItemProperty("categoryID"));
//                contentLayout.addComponents(baslikTxt,detayTxt,categoryTxt);
//
//
//                TextField txtBaslik = new TextField("Başlık");
//                addComponent(txtBaslik);
//
//                TextField txtDetay = new TextField("Detay");
//                addComponent(txtDetay);
//
//                CategoryCombo categoryCombo = new CategoryCombo();
//                categoryCombo.setCaption("Kategori");
//                addComponent(categoryCombo);
//
//
//                PropertysetItem itemIcerik1 = new PropertysetItem();
//
//                itemIcerik1.addItemProperty("baslik", new ObjectProperty<String>("")); //New Icerik
//                itemIcerik1.addItemProperty("detay", new ObjectProperty<String>("")); //New Icerik
//                itemIcerik1.addItemProperty("CategoryID", new ObjectProperty<String>("")); //New Icerik
//
//                IcerikAdd icerikAdd = new IcerikAdd();
//                FieldGroup binder = new FieldGroup(itemIcerik1);
//                binder.buildAndBindMemberFields(icerikAdd);
//
//                contentLayout.addComponent(icerikAdd);
//
//                Button btnAdd = new Button(FontAwesome.EDIT);
//                contentLayout.addComponent(btnAdd);

//                btnAdd.addClickListener(new Button.ClickListener() {
//                    @Override
//                    public void buttonClick(Button.ClickEvent clickEvent) {
//                        try {
//                            binder.commit();
//                        } catch (FieldGroup.CommitException e) {
//                            e.printStackTrace();
//                        }
//
//                        Icerik icerik = new Icerik();
//                        Category category1 = (Category) categoryCombo.getValue();
//                        icerik.setCategoryID(category1.getId());
//                        icerik.setBaslik(icerikAdd.baslikField.getValue());
//                        icerik.setDetay(icerikAdd.detayField.getValue());
//                        icerik.setCategoryID(Integer.parseInt(icerikAdd.categoryField.getValue()));
//                        IcerikService icerikService = new IcerikService();
//                        icerikService.addIcerik(icerik);
//                        icerikAdd.addComponents();
//                    }
//                        Icerik icerik = new Icerik();
//                        Category category1 = (Category) categoryCombo.getValue();
//                        icerik.setCategoryID(category1.getId());
//                        icerik.setBaslik(txtBaslik.getValue());
//                        icerik.setDetay(txtDetay.getValue());
//                        IcerikService icerikService = new IcerikService();
//                        icerikService.addIcerik(icerik);
//                });
//              }
//           });

//            MenuBar.MenuItem deleteIcerik = icerik.addItem("İcerik sil", FontAwesome.ERASER, new MenuBar.Command() {
//                @Override
//                public void menuSelected(MenuBar.MenuItem menuItem) {
//                    final FirstUi firstUi = (FirstUi) UI.getCurrent();
//                    ContentLayout contentLayout = firstUi.getContentLayout();
//                    contentLayout.removeAllComponents();
//
//                    TextField txtID = new TextField("ID");
//                    addComponent(txtID);
//
//                    Button btnDelete = new Button(FontAwesome.ERASER);
//                    contentLayout.addComponent(btnDelete);
//
//                    btnDelete.addClickListener(new Button.ClickListener() {
//                        @Override
//                        public void buttonClick(Button.ClickEvent clickEvent) {
//                            Icerik icerik = new Icerik();
//                            icerik.setBaslik(txtID.getValue());
//                            IcerikService icerikService = new IcerikService();
//                            icerikService.deleteIcerik(icerik);
//                        }
//                    });
//
//                }
//            });
//
//
//            MenuBar.MenuItem listIcerik = icerik.addItem("İcerik Listele", FontAwesome.LIST, new MenuBar.Command() {
//                @Override
//                public void menuSelected(MenuBar.MenuItem menuItem) {
//
//                    IcerikGrid icerikGrid = new IcerikGrid(contentLayout);
//                    contentLayout.setContentLayout(icerikGrid);
//
//
//                    IcerikListPage icerikList = new IcerikListPage();
//                    contentLayout.setContentLayout(icerikList);
//
//
//                    Table table = new Table();
//                    table = new Table("ICERIK LISTESI");
//                    table.addContainerProperty("id", Integer.class, null);
//                    table.addContainerProperty("ICERIK_BASLIK", String.class, null);
//                    table.addContainerProperty("DETAY", String.class, null);
//                    table.addContainerProperty("CATEGORY_ID", Integer.class, null);
//                    table.addContainerProperty("", HorizontalLayout.class, null);
//
//                    IcerikDao icerikDao = new IcerikDao();
//                    List<Icerik> icerikListe = icerikDao.listIcerik();
//
//                    for (Icerik icerik : icerikListe) {
//                        Integer itemId = new Integer(icerik.getId());
//                        Object newItemId = table.addItem();
//                        Item row1 = table.getItem(newItemId);
//                        row1.getItemProperty("ICERİK LİSTESİ").setValue(icerik.getId());
//                        row1.getItemProperty("ICERIK_BASLIK").setValue(icerik.getBaslik());
//                        row1.getItemProperty("DETAY").setValue(icerik.getDetay());
//                        row1.getItemProperty("CATEGORY_ID").setValue(icerik.getCategoryID());
//
//                        HorizontalLayout horizontalLayout = new HorizontalLayout();
//
//                        Button guncelleButton = new Button("GUNCELLE");
//                        guncelleButton.setData(itemId);
//                        guncelleButton.addClickListener(new Button.ClickListener() {
//                            @Override
//                            public void buttonClick(Button.ClickEvent event) {
//                                Integer id = (Integer) event.getButton().getData();
//                                Notification.show(id.intValue() + "KAYIT guncellendi");
//                            }
//                        });
//
//                        Button deleteButton = new Button("SİL");
//                        deleteButton.setData(itemId);
//                        deleteButton.addClickListener(new Button.ClickListener() {
//                            @Override
//                            public void buttonClick(Button.ClickEvent event) {
//                                Icerik icerik1 = new Icerik();
//                                IcerikDao icerikDao = new IcerikDao();
//
//                                Integer id = (Integer) event.getButton().getData();
//                                icerikDao.deleteIcerik(icerik1);
//                                Notification.show(id.intValue() + "KAYIT SİLİNDİ");
//                            }
//                        });
//                        horizontalLayout.addComponents(guncelleButton, deleteButton);
//                        row1.getItemProperty("").setValue(horizontalLayout);
//                    }
//                }
//            });
//
//            addComponent(menuBar);
//            //removeAllComponents();
//            //addComponent(menuBar);
//        }
//    }
