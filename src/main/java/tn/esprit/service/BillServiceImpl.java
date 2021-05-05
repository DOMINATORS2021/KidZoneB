package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Bill;
import tn.esprit.entities.Kindergarten;
import tn.esprit.entities.User;
import tn.esprit.repository.BillRepository;
import tn.esprit.repository.KindergartenRepository;
import tn.esprit.repository.UserRepository;

@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	BillRepository bills;
	@Autowired
	UserRepository users;
	@Autowired
	KindergartenRepository kinders;

	public String ajout_Bill_To_User(int id_user, int id_kinder, Bill bill) {
		Kindergarten kinder = kinders.findById(id_kinder).orElse(null);
		User UserId = users.findById(id_user).orElse(null);
		if (kinder.getUserkinder().getRole().toString() != "Director") {
			return (" Que les directeurs peuvent ajouter des factures");
		}
		if (UserId.getRole().toString() == "Parent") {
			bill.setKindergarten(kinder);
			bill.setUser(UserId);
			bill.setTotalPrice(0);

			bills.save(bill);
			return ("   " + bill);

		} else {
			return ("user n'est pas parent");
		}
	}

	public String delete_Bill(int id_kinder, int id_bill) {
		Kindergarten kinder = kinders.findById(id_kinder).orElse(null);
		Bill bill = bills.findById(id_bill).orElse(null);
		if (bill == null) {
			return ("bill n'existe pas");
		}
		if (kinder.getUserkinder().getRole().toString() == "Director") {
			if (kinder.getId() == bill.getKindergarten().getId()) {

				bills.deleteById(bill.getId());
				return ("bill est supprimé");
			}

			else {
				return ("Supprision non autorisée");
			}
		}

		else {
			return ("user n'est pas un directeur");
		}

	}

	@Override
	public List<Bill> getAllBill() {
		return (List<Bill>) bills.findAll();
	}

	@SuppressWarnings("unused")
	public String update_Bill(int kinder_id, int bill_id, Bill bill) {
		Kindergarten kinder = kinders.findById(kinder_id).orElse(null);

		Bill bill_To_Update = bills.findById(bill_id).orElse(null);
		if (bill_To_Update == null) {
			return ("bill n'existe pas");

		}

		if (kinder.getId() == bill_To_Update.getKindergarten().getId()) {
			if (bill_To_Update != null) {

				bill_To_Update.setDateOfBill(bill.getDateOfBill());
				bill_To_Update.setDescription(bill.getDescription());
				bills.save(bill_To_Update);
				return ("bill est bien modifiée ");
			}

		}

		else {
			return ("Modification non autorisée");
		}
		return null;

	}

	@Override
	public List<Bill> getAllBillByUser(int usertId) {
		return bills.getAllBillByUser(usertId);
	}

	@Override
	public List<Bill> getAllBillBykinder(int kinderId) {
		return bills.getAllBillBykinder(kinderId);
	}

	@Override
	public List<Bill> getAllBillForUserInKinder(int kinderId, int userId) {
		return bills.getAllBillForUserInKinder(kinderId, userId);
	}

	@Override
	public void calculPrice(Bill b, int idBill) {
		Bill bill = bills.findById(idBill).get();

		int k = bills.findById(idBill).get().getKindergarten().getId();
		int u = bills.findById(idBill).get().getUser().getId();
		long a = bills.getNumberOfChildForUserInKinderJPQL(u, k);
		float t = bills.findById(idBill).get().getKindergarten().getPricePerChild();

		bill.setTotalPrice(a * t);
		bills.save(bill);
	}

	@Override
	public long getNumberOfChildForUserInKinderJPQL(int iduser, int idkinder) {
		return bills.getNumberOfChildForUserInKinderJPQL(iduser, idkinder);
	}

}
