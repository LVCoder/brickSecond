package com.pmi.brick.service;

import java.util.Date;

import com.pmi.brick.domain.ForgotenPassword;

public interface ForgotenPasswordService {
public void addForgotenPassword(ForgotenPassword forgotenPassword);
public int getUserId(int id, String hashPassword);

public void delete(ForgotenPassword forgotenPassword);
}
