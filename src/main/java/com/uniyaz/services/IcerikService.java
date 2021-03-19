package com.uniyaz.services;

import com.uniyaz.dao.IcerikDao;
import com.uniyaz.domain.Category;
import com.uniyaz.domain.Icerik;

import java.util.List;

public class IcerikService {
    IcerikDao icerikDao = new IcerikDao();

    public void addIcerik(Icerik icerik)
    {
        icerikDao.addIcerik(icerik);
    }

    public void deleteIcerik(Icerik icerik)
    {
        icerikDao = new IcerikDao();
        icerikDao.deleteIcerik(icerik);
    }

    public void updateIcerik(Icerik icerik)
    {
        icerikDao = new IcerikDao();
        icerikDao.updateIcerik(icerik);
    }

    public List<Icerik> icerikList(){
        return icerikDao.listIcerik();
    }

}
