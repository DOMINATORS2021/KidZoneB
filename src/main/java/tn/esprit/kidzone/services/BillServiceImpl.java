package tn.esprit.kidzone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kidzone.entity.Activity;
import tn.esprit.kidzone.entity.Appointment;
import tn.esprit.kidzone.entity.Bill;
import tn.esprit.kidzone.entity.Kindergarten;
import tn.esprit.kidzone.entity.User;
import tn.esprit.kidzone.repository.BillRepository;
import tn.esprit.kidzone.repository.KindergartenRepository;
import tn.esprit.kidzone.repository.UserRepository;

@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	BillRepository bills;
	@Autowired
	UserRepository users;
	@Autowired
	KindergartenRepository kinders;

	public String ajout_Bill_To_User(Long id_user, int id_kinder, Bill bill) {
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

	@Override
	public void deleteBill(int bill_id) {
		Bill a =bills.findById(bill_id).orElse(null);
		bills.delete(a);

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
	public List<Bill> getAllBillByUser(Long usertId) {
		return bills.getAllBillByUser(usertId);
	}

	@Override
	public List<Bill> getAllBillBykinder(int kinderId) {
		return bills.getAllBillBykinder(kinderId);
	}

	@Override
	public List<Bill> getAllBillForUserInKinder(int kinderId, Long userId) {
		return bills.getAllBillForUserInKinder(kinderId, userId);
	}

	@Override
	public void calculPrice(Bill b, int idBill) {
		Bill bill = bills.findById(idBill).get();

		int k = bills.findById(idBill).get().getKindergarten().getId();
		Long u = bills.findById(idBill).get().getUser().getId();
		long a = bills.getNumberOfChildForUserInKinderJPQL(u, k);
		float t = bills.findById(idBill).get().getKindergarten().getPricePerChild();

		bill.setTotalPrice(a * t);
		bills.save(bill);
	}

	@Override
	public long getNumberOfChildForUserInKinderJPQL(Long iduser, int idkinder) {
		return bills.getNumberOfChildForUserInKinderJPQL(iduser, idkinder);
	}

	//JSF
	
	@Override
	public Bill saveBill(Bill bill) {

		return bills.save(bill);
	}

	@Override
	@javax.transaction.Transactional
	public Bill getBillbyId(int bill_Id) {
		return  bills.findById(bill_Id).get();
	}

	@Override
	public void ajouterBill(Bill bill) {
		bills.save(bill);

	}
	@Override
	public int addorupdateBill(Bill bill) {
		bills.save(bill);
		return bill.getId();
	}
	
	@Override
	public void deleteBillbyId(int bill_Id) {
		Bill a =bills.findById(bill_Id).orElse(null);
		bills.delete(a);

	}

}
