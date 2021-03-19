package com.uniyaz.fields;

import com.uniyaz.dao.CategoryDao;
import com.uniyaz.domain.Category;
import com.uniyaz.services.CategoryService;
import com.vaadin.ui.ComboBox;

import java.util.List;

public class CategoryCombo extends ComboBox
{
    private CategoryDao categoryDao;

    public CategoryCombo()
    {
        this.categoryDao = new CategoryDao();
        this.setDescription("Kategori Seçin: ");
        fillComboBox();
    }

    private void fillComboBox()
    {
        this.removeAllItems();
        List<Category> categoryList = categoryDao.findAllCategory();
        for (Category category : categoryList)
        {
            this.addItem(category);
            setItemCaption(category,category.getCategoryName());
        }
    }
}
