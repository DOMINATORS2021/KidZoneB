package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Bill;

public interface IBillService {

	public String ajout_Bill_To_User(int id_user, int id_kinder, Bill bill);

	public String delete_Bill(int id_kinder, int id_bill);

	public List<Bill> getAllBill();

	public String update_Bill(int kinder_id, int bill_id, Bill bill);

	public long getNumberOfChildForUserInKinderJPQL(int iduser, int idkinder);

	public void calculPrice(Bill b, int idBill);

	public List<Bill> getAllBillByUser(int usertId);

	public List<Bill> getAllBillBykinder(int kinderId);

	public List<Bill> getAllBillForUserInKinder(int kinderId, int userId);

}
