package com.uniyaz;

import com.uniyaz.components.ContentLayout;
import com.uniyaz.components.Header;
import com.uniyaz.components.SideBar;
import com.uniyaz.dao.IcerikDao;
import com.uniyaz.domain.Icerik;
import com.uniyaz.services.IcerikService;
import com.uniyaz.ui.FirstUi;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.ui.*;

public class IcerikAdd extends FormLayout
{
    @PropertyId("id")
    TextField idField;

    @PropertyId("ICERIK_BASLIK")
    TextField baslikField;

    @PropertyId("DETAY")
    TextField detayField;

    @PropertyId("CATEGORY_ID")
    TextField categoryField;

    Button btnAdd;
    Button btnUpdate;
    SideBar sideBar;
    ContentLayout contentLayout;

    BeanItem<Icerik>icerikBeanItem;
    FieldGroup binder;

    public IcerikAdd(Icerik icerik)
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

        buildCategoryAddLayout();
        addComponent(btnAdd);
    }

    private void buildCategoryAddLayout()
    {
        btnAdd = new Button("Kaydet");
        btnAdd.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try
                {
                    binder.commit();
                    Icerik icerik = icerikBeanItem.getBean();

                    IcerikService icerikService = new IcerikService();
                    icerikService.addIcerik(icerik);

                    sideBar.fillSidebar();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

//    @PropertyId("ICERIK_BASLIK")
//    public TextField baslikField = new TextField("Başlık");
//
//    @PropertyId("DETAY")
//    public TextField detayField = new TextField("Detay");
//
//    @PropertyId("CATEGORY_ID")
////    public TextField categoryField = new TextField("Kategori");
//
//    public IcerikAdd()
//    {
//        addComponents(baslikField,detayField,categoryField);
//    }

//    Icerik icerik = new Icerik();
 //   BeanItem<Icerik> itemIcerik = new BeanItem<Icerik>(new Icerik());
//    TextField getBaslikField = baslikField;
//    TextField getDetayField = detayField;
//    TextField getCategoryField = categoryField;






//    public BeanItem<Icerik> getItemIcerik() {
//        itemIcerik.addItemProperty("baslik", new ObjectProperty<Icerik>(new Icerik())); //New Icerik
//        itemIcerik.addItemProperty("detay", new  ObjectProperty<Icerik>(new Icerik())); //New Icerik
//        itemIcerik.addItemProperty("CategoryID", new ObjectProperty<Icerik>(new Icerik())); //New Icerik
//        return itemIcerik;
//    }

   // PropertysetItem itemIcerik1 = new PropertysetItem();
//
//    IcerikAdd icerikAdd = new IcerikAdd();
//    FieldGroup binder = new FieldGroup(itemIcerik);

//    public FieldGroup getBinder() {
//        binder.buildAndBindMemberFields(icerikAdd);
//        return binder;
//    }
}
