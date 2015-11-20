package edu.irabank.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import edu.irabank.dto.UserDTO;
import edu.irabank.form.EditProfileFormBean;

public interface EditProfileService {
	public boolean editProfile(EditProfileFormBean editProfileFormBean,HttpSession sessionID);

	
	UserDTO getUserDTOByUserId(Integer reqId);
	
}

