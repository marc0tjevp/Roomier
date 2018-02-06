package com.yanco.roomier.datalayer.factories;

import com.yanco.roomier.datalayer.dao.DAO;

/**
 * Created by ywillems on 6-2-2018.
 */

public interface DAOFactory {
    DAO createDAO();
}
