package com.uniyaz.view;

import com.uniyaz.components.ContentLayout;
import com.uniyaz.components.SideBar;
import com.uniyaz.domain.Icerik;
import com.uniyaz.services.IcerikService;
import com.uniyaz.ui.FirstUi;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class IcerikUpdate extends FormLayout
{
        @PropertyId("id")
        TextField idField;

        @PropertyId("ICERIK_BASLIK")
        TextField baslikField;

        @PropertyId("DETAY")
        TextField detayField;

        @PropertyId("CATEGORY_ID")
        TextField categoryField;

        Button btnUpdate;
        SideBar sideBar;
        ContentLayout contentLayout;

        BeanItem<Icerik> icerikBeanItem;
        FieldGroup binder;

    public IcerikUpdate(Icerik icerik)
        {
            FirstUi firstUi = (FirstUi) UI.getCurrent();
            this.sideBar =firstUi.getSideBar();
            this.contentLayout = firstUi.getContentLayout();

            buildLayout();

            icerikBeanItem= new BeanItem<Icerik>(icerik);
            binder = new FieldGroup(icerikBeanItem);
            binder.buildAndBindMemberFields(this);
        }

        private void buildLayout()
        {
            idField = new TextField();
            idField.setCaption("ID");
            idField.setNullRepresentation("");
            addComponent(idField);

            baslikField = new TextField();
            baslikField.setCaption("Başlık");
            baslikField.setNullRepresentation("");
            addComponent(baslikField);

            detayField = new TextField();
            detayField.setCaption("Detay");
            detayField.setNullRepresentation("");
            addComponent(detayField);

            categoryField = new TextField();
            categoryField.setCaption("Kategori");
            categoryField.setNullRepresentation("");
            addComponent(categoryField);

            buildCategoryUpdateLayout();
            addComponent(btnUpdate);
        }


        private void buildCategoryUpdateLayout()
        {
            btnUpdate = new Button("Güncelle");
            btnUpdate.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    try
                    {
                        binder.commit();
                        Icerik icerik = icerikBeanItem.getBean();

                        IcerikService icerikService = new IcerikService();
                        icerikService.updateIcerik(icerik);

                        sideBar.fillSidebar();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }
}
