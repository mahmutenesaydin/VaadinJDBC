package com.uniyaz.view;

import com.uniyaz.components.ContentLayout;
import com.uniyaz.dao.CategoryDao;
import com.uniyaz.domain.Category;
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

       // ListCategoryView();

        fillTable();
    }

    private void fillTable() {

        CategoryDao categoryDao = new CategoryDao();

        List<Category> categoryList = categoryDao.findAllCategory();

        for (Category category : categoryList) {
            Item item = indexedContainer.addItem(category);
            item.getItemProperty("id").setValue(category.getId());
            item.getItemProperty("categoryName").setValue(category.getCategoryName());
        }
    }

    private void buildTableContainer() {

        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Long.class, null);
        indexedContainer.addContainerProperty("categoryName", String.class, null);
    }

    private void buildTable() {
        table = new Table();
        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("id", "categoryName");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);

        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                Category category =(Category) itemClickEvent.getItemId();
            }
        });

    }

    private com.vaadin.ui.Button btnCategoryList;
    private ContentLayout contentLayout1;

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
