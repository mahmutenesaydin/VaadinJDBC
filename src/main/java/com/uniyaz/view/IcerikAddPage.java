package com.uniyaz.view;

import com.uniyaz.domain.Category;
import com.uniyaz.domain.Icerik;
import com.uniyaz.services.IcerikService;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class IcerikAddPage extends VerticalLayout
{
    TextField txtBaslik;
    TextField txtDetay;
    Button btnAdd;
    ComboBox cmbKategori;
    Icerik icerik;
    Category category;

    private void IcerikAddPage()
    {
        btnAdd.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if (txtBaslik.getValue() != null || txtDetay.getValue() != null || cmbKategori.getValue() != null)
                {
                    icerik = new Icerik(txtBaslik.getValue());
                    icerik = new Icerik(txtDetay.getValue());
                    icerik = new Icerik((String) cmbKategori.getValue());

                    IcerikService icerikService = new IcerikService();
                    icerikService.addIcerik(icerik);
                   // icerikService.addIcerik(txtDetay.getValue(),txtBaslik.getValue(),cmbKategori.getValue());

                    // Icerik icerik1 = new Icerik(txtBaslik.getValue());
                }
            }
        });
        addComponent(btnAdd);
    }
}
