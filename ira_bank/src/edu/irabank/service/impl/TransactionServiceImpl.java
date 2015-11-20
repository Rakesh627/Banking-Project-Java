package edu.irabank.service.impl; 

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.TransactionDetailsDAO;
import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dao.AccountDetailsDAO;
import edu.irabank.dao.BillpayDAO;
import edu.irabank.dao.UserDAO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.NotificationDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.dto.BillPayDTO;
import edu.irabank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService
{
	
	@Autowired
	private TransactionDetailsDAO transactiondetailsDAO;
	
	@Autowired
	private AccountDetailsDAO accountdetailsDAO;
	
	@Autowired
	private BillpayDAO billpayDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	HttpSession sessionID;
		
	@Transactional
	public boolean getAccountNumber(String accountNO)
	{
		return accountdetailsDAO.getAccountNum(accountNO);
	}
	
	@Override
	@Transactional
	public boolean CreditBalance(String inputAccountNo, Double inputbalance)
	{
		Double userBalance = accountdetailsDAO.getBalance(inputAccountNo);
		Double newBalance = userBalance + inputbalance;
				
			// Set balance to Account table
			boolean isaccountUpdatesuccess = accountdetailsDAO.updateBalance(inputAccountNo, newBalance);
			System.out.println("isaccountUpdatesuccess" + isaccountUpdatesuccess);
			if(isaccountUpdatesuccess)
			{
				// Add row to transaction table
				Date sysDate = new Date();
				TransactionDetailsDTO newTransaction = new TransactionDetailsDTO();
				newTransaction.setTransDate(sysDate);
				newTransaction.setTransAmt(inputbalance);
				newTransaction.setToAcct(inputAccountNo);
				newTransaction.setIsAuthorized(true);
							
				// Add this newly created TransactionDetailsDTO Object into the DB. 
				boolean transDetailsave = transactiondetailsDAO.TransactionDetailsSave(newTransaction);
				return transDetailsave;
			}					
		return false;
	}
	@Override
	@Transactional
	public boolean DebitBalance(String inputAccNo, Double inputbal)
	{
		
		Double userBalance = accountdetailsDAO.getBalance(inputAccNo);
		if(userBalance >= inputbal)
		{
			Double newBalance = userBalance - inputbal;
		
		
				// Set balance to Account table
				boolean isaccountUpdatesuccess = accountdetailsDAO.updateBalance(inputAccNo, newBalance);
				System.out.println("isaccountUpdatesuccess" + isaccountUpdatesuccess);
				if(isaccountUpdatesuccess)
				{
					// Add row to transaction table
					Date sysDate = new Date();
					TransactionDetailsDTO newTransaction = new TransactionDetailsDTO();
					newTransaction.setTransDate(sysDate);
					newTransaction.setTransAmt(inputbal);
					newTransaction.setFromAcct(inputAccNo);
					newTransaction.setIsAuthorized(true);
					// Add this newly created TransactionDetailsDTO Object into the DB.
					
					boolean transDetailsave = transactiondetailsDAO.TransactionDetailsSave(newTransaction);
					return transDetailsave;
				}
			}
		return false;
	}
	
	@Override
	@Transactional
	public String getAccountNumberbyUserID(Integer UserID)
	{
		
		String accountnum = accountdetailsDAO.getAccountNumbyUserID(UserID);
		return accountnum;
		
	}
	@Override
	@Transactional
	public boolean TransferBalance(String toAccount, String fromAccount, Double inputbal)
	{
		Double toBalance = accountdetailsDAO.getBalance(toAccount);
		Double fromBalance = accountdetailsDAO.getBalance(fromAccount);
		if(fromBalance < inputbal)
		{
			return false;
	
		}
		else
		{
			Double newtoBalance = toBalance + inputbal;
			Double newfromBalance = fromBalance - inputbal;
			// Set balance to To Account table
			boolean istoaccountUpdatesuccess = accountdetailsDAO.updateBalance(toAccount, newtoBalance);
			boolean isfromaccountUpdatesuccess = accountdetailsDAO.updateBalance(fromAccount, newfromBalance);
			System.out.println("istoaccountUpdatesuccess" + istoaccountUpdatesuccess);
			System.out.println("isfromaccountUpdatesuccess" + isfromaccountUpdatesuccess);
			if(istoaccountUpdatesuccess && isfromaccountUpdatesuccess)
			{
				// Add row to transaction table
				Date sysDate = new Date();
				TransactionDetailsDTO newTransaction = new TransactionDetailsDTO();
				newTransaction.setTransDate(sysDate);
				newTransaction.setTransAmt(inputbal);
				newTransaction.setFromAcct(fromAccount);
				newTransaction.setToAcct(toAccount);
				newTransaction.setIsAuthorized(true);
				// Add this newly created TransactionDetailsDTO Object into the DB.			
				boolean transDetailsave = transactiondetailsDAO.TransactionDetailsSave(newTransaction);
				return transDetailsave;
			}
			return false;
		}	
	}
	
	@Transactional
	public boolean BillPay(String AccountNo, Double balance, String status)
	{
		Integer userId = (Integer)sessionID.getAttribute("userId");
		System.out.println("userID in  service is:" + userId);
		UserDTO merchantdto = userDAO.getUserDTOByUserId(userId);
		// Add row to BillPay table
		BillPayDTO newBillPay = new BillPayDTO();
		newBillPay.setMerchantId(merchantdto);
		newBillPay.setAcctNumber(AccountNo);
		newBillPay.setAmount(balance);
		newBillPay.setStatus(status);
		
		
		// Add this newly created TransactionDetailsDTO Object into the DB.			
		boolean Billpaysave = billpayDAO.BillpaySave(newBillPay);
		return Billpaysave;
		
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<BillPayDTO> showBillpayInfo() {
		// TODO Auto-generated method stub
		List billpayList = billpayDAO.showbillpayInfo();
		System.out.println("Bill pay List" + billpayList);
		return billpayList;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<NotificationDetailsDTO> showNotificationInfo() {
		// TODO Auto-generated method stub
		List NotificationList = billpayDAO.shownotificationInfo();
		System.out.println("Notification List" + NotificationList);
		return NotificationList;
	}
	
	

	@Transactional
	public boolean BillPayUpdate(Integer billid, String Status)
	{
	    boolean isbillpaystatus = billpayDAO.Billpayupdatestatus(billid, Status);
	    if(isbillpaystatus)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	  }
	
	@Transactional
	public boolean BillpayUpdatekey(Integer billid, String hashedkey)
	{
	    boolean isbillpaystatus = billpayDAO.Billpayupdatekey(billid, hashedkey);
	    if(isbillpaystatus)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	  }
	
	@Transactional
	public boolean BillpayMerchantUpdatekey(Integer billid, String hashedkey)
	{
	    boolean isbillpaystatus = billpayDAO.BillpayMerchantupdatekey(billid, hashedkey);
	    if(isbillpaystatus)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	  }
	
	@Transactional
	public boolean Insertnotification(Integer billid, String status, String descr)
	{
	
		BillPayDTO billpaydtoid = billpayDAO.getBillPayDTOByBillid(billid);
		// Add row to Notification table
		NotificationDetailsDTO newNotification = new NotificationDetailsDTO();
		newNotification.setNotificationBillid(billpaydtoid);
		newNotification.setNotificationDescription(descr);
		newNotification.setNotificationStatus(status);
		
		
		// Add this newly created NotificationDetailsDTO Object into the DB.			
		boolean Billpayinsertsave = billpayDAO.Insertupdate(newNotification);
		System.out.println("Billpayinsertsave" + Billpayinsertsave);
		return Billpayinsertsave;
		
			
	}
	
	@Transactional
	public boolean Updatenotification(Integer billid, String status, String descr)
	{
	    boolean isnotificationstatus = billpayDAO.Notificationupdate(billid, status, descr);
	    if(isnotificationstatus)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
	
	@Transactional
	public boolean Findbybillid(Integer billid)
	{
		boolean isbillexist = billpayDAO.Findbybillid(billid);
		return isbillexist;
	}
	
	@Transactional
	public String getAccountnumberbyBillid(Integer billid)
	{
		String Accountno  = billpayDAO.getaccountnobybillid(billid);
		return Accountno;
	}
	
	@Transactional
	public Integer getMerchantidbyBillid(Integer billid)
	{
		Integer Merchantid  = billpayDAO.getmerchantidbybillid(billid);
		return Merchantid;
	}
		
		
	}
	




