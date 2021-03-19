package com.uniyaz.view;

import com.uniyaz.components.ContentLayout;
import com.uniyaz.domain.Icerik;
import com.uniyaz.services.IcerikService;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import java.util.List;


public class IcerikGrid extends GridLayout
{
    private Icerik icerik;
    private double satirSayisi;

    private ContentLayout contentLayout;

    private IcerikService icerikService = new IcerikService();
    private List<Icerik> icerikList;

    public IcerikGrid(ContentLayout contentLayout) {
        this.contentLayout = contentLayout;
        satirSayisi = Math.ceil(icerikList.size() / 3);
        if (satirSayisi >= 1) {
            buildGrid(satirSayisi);
        }else{
            Notification.show("Kategoriye Ait Makale Bulanamadı !");
        }

    }

    private void buildGrid(double satirSayisi)
    {
        addStyleName("outlined");
        setSizeFull();
        fillItemsGrid((int) satirSayisi, 3);
    }

    private void fillItemsGrid(final int rows, final int columns) {
        removeAllComponents();
        setRows(rows);
        setColumns(columns);
        setWidth(100.0f, Sizeable.Unit.PERCENTAGE);

        int count = 0;
        for (Icerik icerik : icerikList) {

            VerticalLayout icerikItem = new VerticalLayout();

            icerikItem.setWidth("200");
            icerikItem.setHeight("500");

            count += 1;
            com.vaadin.ui.Label labelMakaleBaslikAndCount = new com.vaadin.ui.Label();
            labelMakaleBaslikAndCount.setValue(count + "----------------------" + icerik.getBaslik());

            com.vaadin.ui.Label labelMakaleKisaDetay = new com.vaadin.ui.Label();
            if (icerik.getDetay().length() > 100){
                labelMakaleKisaDetay.setValue(icerik.getDetay().substring(0, 100) + " ...");
            }else{
                labelMakaleKisaDetay.setValue(icerik.getDetay()+ " ...");
            }

            com.vaadin.ui.Button detayaGitButton = new com.vaadin.ui.Button("Devamı");
            detayaGitButton.addClickListener(new com.vaadin.ui.Button.ClickListener() {
                @Override
                public void buttonClick(com.vaadin.ui.Button.ClickEvent clickEvent) {
                    icerikItem.removeComponent(labelMakaleKisaDetay);
                    icerikItem.removeComponent(detayaGitButton);

                    com.vaadin.ui.Label labelMakaleDetay = new com.vaadin.ui.Label();
                    labelMakaleDetay.setValue(icerik.getDetay());

                    icerikItem.addComponent(labelMakaleDetay);

                    icerikItem.setSizeFull();
                    icerikItem.setHeight(null);

                    contentLayout.setContentLayout(icerikItem);
                }
            });
            detayaGitButton.setIcon(FontAwesome.ARROW_CIRCLE_O_RIGHT);

            icerikItem.addComponent(labelMakaleBaslikAndCount);
            icerikItem.addComponent(labelMakaleKisaDetay);
            icerikItem.addComponent(detayaGitButton);

            addComponent(icerikItem);
        }
    }
}
