package com.uniyaz.view;

import com.uniyaz.domain.Icerik;
import com.uniyaz.services.IcerikService;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Date;
import java.util.List;

public class IcerikListPage extends VerticalLayout
{
    Table table;
    IndexedContainer indexedContainer;

    public IcerikListPage() {
        buildTableIndexedContainer();
        buildTable();
        fillTable();
        addComponent(new Label("<h3>Icerik Tablosu</h3>", ContentMode.HTML));
        addComponent(table);
    }
    private void buildTableIndexedContainer() {

        indexedContainer = new IndexedContainer();


//        indexedContainer.addContainerProperty("sil",Button.class,null);
//        indexedContainer.addContainerProperty("izle",Button.class,null);
        indexedContainer.addContainerProperty("guncelle", Button.class,null);
        indexedContainer.addContainerProperty("id", Integer.class, null);
        indexedContainer.addContainerProperty("ICERIK_BASLIK", String.class, null);
        indexedContainer.addContainerProperty("DETAY", String.class, null);
        indexedContainer.addContainerProperty("CATEGORY_ID", Integer.class, null);
      }

    private void buildTable() {
        table = new Table();
        table.setContainerDataSource(indexedContainer);

        table.setWidth("100%");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);
        //Tablo Başlıkları
        table.setColumnHeaders("","ID", "Başlık", "Detay","ID Kategorisi");

        table.setColumnWidth("guncelle",70);
        table.setColumnAlignment("guncelle", Table.Align.LEFT);
    }

    private void fillTable() {
        indexedContainer.removeAllItems();
        IcerikService icerikService = new IcerikService();
        List<Icerik> icerikList = icerikService.icerikList();

        for (Icerik icerik : icerikList) {
            Item item = indexedContainer.addItem(icerik);

            Button editButton=new Button();
            icerikGuncelle(icerik,editButton);

            fillColumns(icerik,item,editButton);
        }

    }

    private void icerikGuncelle(Icerik icerik, Button editButton) {

    }

    private void fillColumns(Icerik icerik, Item item, Button editButton) {
        item.getItemProperty("guncelle").setValue(editButton);

        item.getItemProperty("id").setValue(icerik.getId());
        item.getItemProperty("ICERIK_BASLIK").setValue(icerik.getBaslik());
        item.getItemProperty("DETAY").setValue(icerik.getDetay());
        item.getItemProperty("CATEGORY_ID").setValue(icerik.getCategoryID());
    }
}
