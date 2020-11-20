package model.file;

import java.util.ArrayList;

public interface Storable<T> {
public void createFile();
public boolean stores(T book);
public ArrayList<T> recovers();
public boolean deleteObject(String isbn);
}
