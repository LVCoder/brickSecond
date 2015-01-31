package com.pmi.brick.dao;



import com.pmi.brick.domain.ForgotenPassword;

public interface ForgotenPasswordDao {
 public int getUserId(int id, String hash_password);
 public void saveForgotenPassword(ForgotenPassword forgotenpassword );
 public void delete(ForgotenPassword forgotenPassword);

}
