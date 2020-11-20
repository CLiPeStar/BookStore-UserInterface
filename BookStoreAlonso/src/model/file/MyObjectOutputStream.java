package model.file;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {

	protected MyObjectOutputStream(OutputStream out) throws IOException, SecurityException {
		super(out);
	}

	protected void writeStreamHeader() throws IOException {
	}
}
