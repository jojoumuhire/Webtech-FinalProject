package com.VillageSafeVisitors.Services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.VillageSafeVisitors.Models.Models;
import com.VillageSafeVisitors.Models.SignUp;

public interface Save {

	public Models saveVisitor(Models Models); 
	public List<Models> getALLVisitor();
	public Models updateUser(Models Models);
	public SignUp createAccount (SignUp Account);
	public Page<Models> getPaginated(int pageNo,int pageSize);
	
	
}
