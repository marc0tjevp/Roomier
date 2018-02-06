package com.yanco.roomier.datalayer.dao;

import java.util.List;
import java.util.UUID;

/**
 * Created by ywillems on 6-2-2018.
 */

public interface DAO {
    List getAll();
    Object getByUUID(UUID id);
    void create(Object o);
    void update(Object o);
    void delete(Object o);
    void deleteById(UUID id);
}
