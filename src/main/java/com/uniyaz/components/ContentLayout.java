package com.uniyaz.components;

import com.uniyaz.dao.CategoryDao;
import com.uniyaz.dao.IcerikDao;
import com.uniyaz.domain.Category;
import com.uniyaz.domain.Icerik;
import com.uniyaz.ui.FirstUi;
import com.uniyaz.view.ListCategoryView;
import com.uniyaz.view.TableContact;
import com.vaadin.data.Item;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

/**
 * Created by AKARTAL on 8.3.2021.
 */
public class ContentLayout extends VerticalLayout {
    private ContentLayout contentLayout;

    public ContentLayout getContentLayout() {
        return contentLayout;
    }

    public void setContentLayout(ContentLayout contentLayout) {
        this.contentLayout = contentLayout;
    }

    public ContentLayout() {
        //setSizeFull();
        buildLayout();
    }

    public void setContentLayout(Component component) {
        removeAllComponents();
        addComponent(component);
    }

    @Override
    public void addComponent(Component component) {
        super.addComponent(component);
        setComponentAlignment(component, Alignment.MIDDLE_CENTER);
    }

    private void buildLayout() {
//        final FirstUi firstUi = (FirstUi) UI.getCurrent();
//        TableContact tableContact = firstUi.getTableContact();
//        tableContact.removeAllComponents();

        Label headerLabel = new Label();
        headerLabel.setCaption("HOŞ GELDİNİZZZ");
        headerLabel.setSizeUndefined();
        addComponent(headerLabel);

        setComponentAlignment(headerLabel, Alignment.MIDDLE_CENTER);
    }

    public void ContenIcerikListele() {
        removeAllComponents();

        Table table = new Table("ICERIK LISTESI");
        table.addContainerProperty("id", Integer.class, null);
        table.addContainerProperty("ICERIK_BASLIK", String.class, null);
        table.addContainerProperty("DETAY", String.class, null);
        table.addContainerProperty("CATEGORY_ID", int.class, null);
        table.addContainerProperty("", HorizontalLayout.class, null);

        IcerikDao icerikDao = new IcerikDao();
        List<Icerik> icerikListe = icerikDao.listIcerik();

        for (Icerik icerik : icerikListe) {
            Integer itemId = new Integer(icerik.getId());
            Object newItemId = table.addItem();
            Item row1 = table.getItem(newItemId);
            row1.getItemProperty("id").setValue(icerik.getId());
            row1.getItemProperty("ICERIK_BASLIK").setValue(icerik.getBaslik());
            row1.getItemProperty("DETAY").setValue(icerik.getDetay());
            row1.getItemProperty("CATEGORY_ID").setValue(icerik.getCategoryID());
        }
    }
}
