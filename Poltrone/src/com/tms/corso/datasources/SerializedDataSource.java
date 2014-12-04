package com.tms.corso.datasources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import com.tms.corso.DataSourceException;
import com.tms.corso.Studente;

public class SerializedDataSource<E> implements DataSource<E> {

	private String filename;
	private String backupFilename;
	private Set<E> elementi;


	public SerializedDataSource(String filename, String backupFilename) {
		this.filename = filename;
		this.backupFilename = backupFilename;
	}
	
	@Override
	public Set<E> load() throws DataSourceException {
		if(!Files.exists(FileSystems.getDefault().getPath(filename)))
		{
			DataSource<Studente> ds = new SerializedDataSource<Studente>(filename, filename);;
			ds.save(new InMemoryStudentDataSource().load());
		}
		try (ObjectInputStream iis = new ObjectInputStream(new FileInputStream(
				filename))) {
			elementi = (Set<E>) iis.readObject();
			return elementi;

		} catch (IOException | ClassNotFoundException e) {
			throw new DataSourceException(e.getMessage(), e.getCause());
		}
	}


	@Override
	public void save(Set<E> toSave) throws DataSourceException {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(backupFilename)))
		{
             oos.writeObject(toSave);
		
		} catch (IOException e) {
			e.printStackTrace();
			throw new DataSourceException(e.getMessage(), e.getCause());
		}

	}

}
