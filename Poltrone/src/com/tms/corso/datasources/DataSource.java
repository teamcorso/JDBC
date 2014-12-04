package com.tms.corso.datasources;

import java.util.Set;

import com.tms.corso.DataSourceException;

public interface DataSource <E>{
     public Set<E> load() throws DataSourceException;
     public void save(Set<E> toSave)throws DataSourceException;
}
