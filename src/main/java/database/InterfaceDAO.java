package database;

import java.util.ArrayList;
import java.util.List;

public interface InterfaceDAO<T> {
	
	public ArrayList<T> selectAll();
	
	public T selectById(T x);
	
	public int insert(T x);
	
	public int insertAll(ArrayList<T> list);
	
	public boolean delete(T x);
	
	public boolean deleteAll();
	
	public boolean update(T x);
}
