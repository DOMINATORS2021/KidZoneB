package tn.esprit.kidzone.services;

import java.util.List;

import tn.esprit.kidzone.entity.Appointment;
import tn.esprit.kidzone.entity.Bill;

public interface IBillService {

	public String ajout_Bill_To_User(Long id_user, int id_kinder, Bill bill);

	public void deleteBill(int id_bill);

	public List<Bill> getAllBill();

	public String update_Bill(int kinder_id, int bill_id, Bill bill);

	public long getNumberOfChildForUserInKinderJPQL(Long iduser, int idkinder);

	public void calculPrice(Bill b, int idBill);

	public List<Bill> getAllBillByUser(Long usertId);

	public List<Bill> getAllBillBykinder(int kinderId);

	public List<Bill> getAllBillForUserInKinder(int kinderId, Long userId);

	//JSF
	

	public void ajouterBill(Bill bill);

    public Bill getBillbyId(int bill_Id);
    
    Bill saveBill(Bill bill);
    public int addorupdateBill(Bill bill);

	public void deleteBillbyId(int bill_Id);

}
