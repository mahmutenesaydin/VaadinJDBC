package com.uniyaz.services;

import com.uniyaz.dao.CategoryDao;

public class CategoryService
{
    CategoryDao categoryDao = new CategoryDao();

    public void addKategori(String categoryName)
    {
        categoryDao.addCategory(categoryName);
    }

    public void deleteKategori(int id)
    {
        categoryDao.deleteCategory(id);
    }


    public void ListKategori()
    {
       categoryDao.findAllCategory();
    }
}
