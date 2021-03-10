package com.uniyaz.components;

import com.vaadin.ui.TextField;

import java.awt.*;

public class VaTextField extends TextField
{
    public VaTextField() {
        addStyleName("st-text-field");
        setNullRepresentation("");
    }

    public VaTextField(String caption) {
        this();
        setCaption(caption);
    }
}
