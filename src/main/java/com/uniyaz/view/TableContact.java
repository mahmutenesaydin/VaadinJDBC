package com.uniyaz.view;

import com.uniyaz.components.ContentLayout;
import com.uniyaz.dao.CategoryDao;
import com.uniyaz.dao.IcerikDao;
import com.uniyaz.domain.Category;
import com.uniyaz.domain.Icerik;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.shared.ui.table.TableState;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class TableContact extends VerticalLayout {

    private Table table;
    private IndexedContainer indexedContainer;

    public TableContact() {
        buildTableContainer();

        buildTable();
        addComponent(table);

        fillTable();
    }

    private void fillTable() {

        IcerikDao icerikDao = new IcerikDao();

        List<Icerik> icerikList = icerikDao.listIcerik();

        for (Icerik icerik : icerikList) {
            Item item = indexedContainer.addItem(icerik);
            item.getItemProperty("id").setValue(icerik.getId());
            item.getItemProperty("ICERIK_BASLIK").setValue(icerik.getBaslik());
            item.getItemProperty("DETAY").setValue(icerik.getDetay());
            item.getItemProperty("CATEGORY_ID").setValue(icerik.getCategoryID());
        }
    }

    private void buildTableContainer() {

        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Long.class, null);
        indexedContainer.addContainerProperty("ICERIK_BASLIK", String.class, null);
        indexedContainer.addContainerProperty("DEYAY",String.class,null);
        indexedContainer.addContainerProperty("CATEGORY_ID", String.class, null);
    }

    private void buildTable() {
        table = new Table();
        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("id", "CATEGORY_NAME", "DETAY", "CATEGORY_ID");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);

        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                //Category category =(Category) itemClickEvent.getItemId();
            }
        });

    }

//    private com.vaadin.ui.Button btnCategoryList;
//    private ContentLayout contentLayout1;
//    public void ListCategoryView()
//    {
//        btnCategoryList = new com.vaadin.ui.Button();
//        btnCategoryList.addClickListener(new com.vaadin.ui.Button.ClickListener() {
//            @Override
//            public void buttonClick(com.vaadin.ui.Button.ClickEvent clickEvent) {
//                ListCategoryView listCategoryView = new ListCategoryView();
//                contentLayout1.setContentLayout(listCategoryView);
//            }
//        });
//        addComponent(btnCategoryList);
//    }
}
