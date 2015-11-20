package edu.irabank.service.impl; 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.jmx.snmp.Timestamp;

import edu.irabank.dao.UserDAO;
import edu.irabank.dao.UserRoleDAO;
import edu.irabank.dao.impl.UserDAOImpl;
import edu.irabank.dto.RolesDTO;
import edu.irabank.dto.UserDTO;

import edu.irabank.form.EditProfileFormBean;
import edu.irabank.service.EditProfileService;
@Service
public class EditProfileImpl implements EditProfileService
{
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@Override
	@Transactional
	public UserDTO getUserDTOByUserId(Integer reqId) {
		// TODO Auto-generated method stub
		return userDAO.getUserDTOByUserId(reqId);
	}
	
	@Override
	@Transactional
	// Update Profile
	
	
	public boolean editProfile(EditProfileFormBean EditProfileFormBean, HttpSession sessionID) {
		
		UserDTO updateEntry = new UserDTO();
		updateEntry.setEmailId(EditProfileFormBean.getemailId());
		updateEntry.setUserName(EditProfileFormBean.getuserName());
		updateEntry.setFirstName(EditProfileFormBean.getfirstName());
		updateEntry.setLastName(EditProfileFormBean.getlastName());
		updateEntry.setAddress(EditProfileFormBean.getaddress());
		updateEntry.setContactNum(EditProfileFormBean.getcontactNum());
		Integer userId = (Integer) sessionID.getAttribute("userId");
		
		UserDTO tempUserDTO=getUserDTOByUserId(userId);
		
		updateEntry.setDob(tempUserDTO.getDob());
		updateEntry.setPassword(tempUserDTO.getPassword());
		updateEntry.setUserId(tempUserDTO.getUserId());
		updateEntry.setRoleId(tempUserDTO.getRoleId());
		updateEntry.setSecAns1(tempUserDTO.getSecAns1());
		updateEntry.setSecAns2(tempUserDTO.getSecAns2());
		updateEntry.setSecQue1(tempUserDTO.getSecQue1());
		updateEntry.setSecQue2(tempUserDTO.getSecQue2());
		
		
		//newIssue.setReqUserId(userDTO);
		
	    userDAO.updateUserDetailsSaveorUpdate(updateEntry);
		return true;
		
		

 }

	
}
