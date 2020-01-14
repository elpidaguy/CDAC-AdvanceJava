package com.app.service;

import com.app.pojos.ApplicationData;

public interface ApplicationDataService {
	void saveData(ApplicationData data);
	ApplicationData getData(Integer id);
}
