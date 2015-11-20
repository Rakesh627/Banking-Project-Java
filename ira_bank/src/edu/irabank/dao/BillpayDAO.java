package edu.irabank.dao;

import java.util.List;






import edu.irabank.dto.BillPayDTO;
import edu.irabank.dto.NotificationDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;



public interface BillpayDAO {
	
	
	Boolean BillpaySave(BillPayDTO billpayDTO);
	public List<BillPayDTO> showbillpayInfo();
	public List<NotificationDetailsDTO> shownotificationInfo();
	boolean Billpayupdatestatus(Integer billlid, String status);
	boolean BillpayMerchantupdatekey(Integer billid, String merchanthashedkey);
	boolean Billpayupdatekey(Integer billlid, String hashedkey);
	boolean Insertupdate(NotificationDetailsDTO notificationdetailsDTO);
	boolean Notificationupdate(Integer billid, String status,String descr);
	boolean Findbybillid(Integer billid);
	BillPayDTO getBillPayDTOByBillid(Integer billid);
	String getaccountnobybillid(Integer billId);
	Integer getmerchantidbybillid(Integer billId);
	String gethashedKey(Integer billId);
	String getmerchanthashedKey(Integer billId);

}
