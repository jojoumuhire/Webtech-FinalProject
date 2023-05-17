package com.VillageSafeVisitors.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.VillageSafeVisitors.Models.Models;
import com.VillageSafeVisitors.Models.SignUp;
import com.VillageSafeVisitors.Repositorys.Repositorys;
import com.VillageSafeVisitors.Repositorys.SignUpRepo;

@Service
public class Services implements Save{
 @Autowired
 private Repositorys visitorRepository;
 @Autowired
 private SignUpRepo SignUp;
	@Override
	public Models saveVisitor(Models Models) {
		// TODO Auto-generated method stub
		return visitorRepository.save(Models);
	}

	@Override
	public List<Models> getALLVisitor() {
		// TODO Auto-generated method stub
		return visitorRepository.findAll();
	}

	@Override
	public Models updateUser(Models Models) {
		// TODO Auto-generated method stub
		
		Models existingUser = visitorRepository.findById(Models.getId()).get();
		existingUser.setNames(Models.getNames());
		existingUser.setEmail(Models.getEmail());
		existingUser.setPhone(Models.getPhone());
		existingUser.setCurrentVillage(Models.getCurrentVillage());
		existingUser.setNewVillage(Models.getNewVillage());

		
        Models updatedUser = visitorRepository.save(existingUser);
		return updatedUser;
	}

	@Override
	public SignUp createAccount(SignUp Account) {
		// TODO Auto-generated method stub
		return  SignUp.save(Account);
		
	}

	@Override
	public Page<Models> getPaginated(int pageNo, int pageSize) {
		PageRequest pageable= PageRequest.of(pageNo-1,pageSize);
		return this.visitorRepository.findAll(pageable);
	}

	
	

	}
