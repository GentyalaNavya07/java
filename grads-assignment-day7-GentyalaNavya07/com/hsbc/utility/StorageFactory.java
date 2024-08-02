package com.hsbc.utility;

import com.hsbc.service.Storage;
import com.hsbc.service.StorageFileImpl;

public class StorageFactory {
    private static final Storage storage=new StorageFileImpl();
    private StorageFactory()
    {}
    public static Storage getStorage()
    {

        return storage;
    }
}