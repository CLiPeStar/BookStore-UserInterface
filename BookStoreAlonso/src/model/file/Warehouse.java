package model.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import model.Book;

public class Warehouse<T> implements Storable<T> {

	private File file;
	private FileOutputStream flujoW;
	private FileInputStream flujoR;
	private ObjectInputStream adaptadorR;
	private ObjectOutputStream adaptadorW;
	private boolean estado = false;
	private final String PATH;

	public Warehouse(String path) {
		super();
		this.PATH = path;
		createFile();
	}

	public void createFile() {
		file = new File(PATH);

		if (!file.exists() || file.length() == 0) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean stores(T obj) {
		try {
			flujoW = new FileOutputStream(file, true);
			if (this.file.length() == 0 || !this.file.exists()) {
				createFile();
				adaptadorW = new ObjectOutputStream(flujoW);
			} else {
				adaptadorW = new MyObjectOutputStream(flujoW);
			}
			adaptadorW.writeObject((T) obj);
		} catch (IOException e) {
			estado = false;
			e.printStackTrace();
		}
		try {
			adaptadorW.close();
			flujoW.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return estado;
	}

	public ArrayList<T> recovers() {
		ArrayList<T> books = new ArrayList<T>();
		try {
			flujoR = new FileInputStream(file);
			adaptadorR = new ObjectInputStream(flujoR);
			T object = (T) adaptadorR.readObject();
			while (object != null) {
				books.add((T) object);
				object = (T) adaptadorR.readObject();

			}
		} catch (IOException | ClassNotFoundException e) {
			estado = false;
		}
		try {
			adaptadorR.close();
			flujoR.close();

		} catch (Exception e) {
//			e.printStackTrace();
		}
		return books;
	}

	public boolean deleteObject(Object bookStore) throws SecurityException {
		ArrayList<Book> books = (ArrayList<Book>) bookStore;
		borrarFichero();
		for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
			Book t = (Book) iterator.next();
			stores((T) t);
		}
		return false;
	}

	private void borrarFichero() {
		try {
			file.delete();
			file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
