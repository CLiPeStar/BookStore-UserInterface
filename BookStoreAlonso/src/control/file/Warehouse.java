package control.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Warehouse {

	private File file;
	private FileOutputStream flujoW;
	private FileInputStream flujoR;
	private ObjectInputStream adaptadorR;
	private ObjectOutputStream adaptadorW;
	private boolean estado = false;

	public Warehouse(String path) {
		super();
		createFile(path);
	}

	private void createFile(String path) {
		file = new File(path);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
	}

	public boolean stores(Object obj) {
		try {
			
			flujoW = new FileOutputStream(file);
			adaptadorW = new ObjectOutputStream(flujoW);
			adaptadorW.writeObject(obj);
			adaptadorW.close();
			flujoW.close();
		} catch (IOException e) {
			estado = false;
//				e.printStackTrace();
		}
		return estado;
	}

	public Object recovers() {
		Object obj = null;
		try {
			flujoR = new FileInputStream(file);
			adaptadorR = new ObjectInputStream(flujoR);
			obj = adaptadorR.readObject();
			adaptadorR.close();
			flujoR.close();
		} catch (IOException | ClassNotFoundException e) {
			estado = false;
//				e.printStackTrace();
		}
		return obj;
	}

	public boolean isEstado() {
		return estado;
	}

}
