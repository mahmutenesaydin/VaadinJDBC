package com.uniyaz.components;

import com.uniyaz.ui.FirstUi;
import com.uniyaz.view.ListCategoryView;
import com.uniyaz.view.TableContact;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by AKARTAL on 8.3.2021.
 */
public class ContentLayout extends VerticalLayout
{
    private VaTextField ıdTxt;
    private VaTextField nameTxt;
    private VaTextField surnameTxt;
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

    public void setContentLayout(Component component)
    {
        removeAllComponents();
        addComponent(component);
    }

    @Override
    public void addComponent(Component component)
    {
        super.addComponent(component);
        setComponentAlignment(component, Alignment.MIDDLE_CENTER);


    }

    private void buildLayout()
    {
//        final FirstUi firstUi = (FirstUi) UI.getCurrent();
//        TableContact tableContact = firstUi.getTableContact();
//        tableContact.removeAllComponents();

        Label headerLabel = new Label();
        headerLabel.setCaption("HOŞ GELDİNİZZZ");
        headerLabel.setSizeUndefined();
        addComponent(headerLabel);

        setComponentAlignment(headerLabel,Alignment.MIDDLE_CENTER);
    }
}
