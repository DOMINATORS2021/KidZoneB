package tn.esprit.kidzone.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.el.parser.ParseException;

import tn.esprit.kidzone.entity.Bill;
import tn.esprit.kidzone.repository.BillRepository;
import tn.esprit.kidzone.services.IBillService;

@Scope(value = "session")
@Component(value = "BillController")
@ELBeanName(value = "BillController")
@Join(path = "/bill", to = "/SpringMVC/billAll.jsf")
public class BillRestControllerImpl {
	@Autowired
	IBillService bills;

	@Autowired
	BillRepository repository;

	@PostMapping("/ajout_Bill_To_User/{id_user}/{id_kinder}")
	public String ajout_Bill_To_User(@PathVariable("id_user") Long id_user, @PathVariable("id_kinder") int id_kinder,
			@RequestBody Bill bill) throws ParseException {

		return bills.ajout_Bill_To_User(id_user, id_kinder, bill);
	}

	@DeleteMapping("/delete_Bill/{id_kinder}/{id_bill}")
	public ResponseEntity<String> deleteBill(@PathVariable("id_bill") int id_bill) {
bills.deleteBill(id_bill);
return new ResponseEntity<String>("deleted succesfuly", HttpStatus.OK);

	}

	@PutMapping("/update_Bill/{kinder_id}/{bill_id}")
	public String update_Bill(@PathVariable("kinder_id") int kinder_id, @PathVariable("bill_id") int bill_id,
			@RequestBody Bill bill) {

		return bills.update_Bill(kinder_id, bill_id, bill);
	}

	@GetMapping(value = "/listofbill")
	@ResponseBody
	public List<Bill> getAllBill() {
		return bills.getAllBill();
	}
	/*
	 * @PutMapping("/updateBill/{idBill}")
	 * 
	 * @ResponseBody public ResponseEntity<String> updateBill(
	 * 
	 * @RequestBody Bill bill,@PathVariable("idBill")int idBill) {
	 * bills.updateBill(bill,idBill ); return new
	 * ResponseEntity<String>("Bill updated successfully",HttpStatus.OK);
	 * 
	 * }
	 */

	@PutMapping("/calculp/{idBill}")
	@ResponseBody
	public ResponseEntity<String> calculPrice(@RequestBody Bill bill, @PathVariable("idBill") int idBill) {
		bills.calculPrice(bill, idBill);
		return new ResponseEntity<String>("Bill is calculated", HttpStatus.OK);

	}

	@GetMapping("/getAllBillByUser/{iduser}")
	@ResponseBody
	public List<Bill> getAllBillByUser(@PathVariable("iduser") Long usertId) {

		return bills.getAllBillByUser(usertId);
	}

	@GetMapping("/getAllBillForUserInKinder/{idkinder}/{iduser}")
	@ResponseBody
	public List<Bill> getAllBillForUserInKinder(@PathVariable("idkinder") int idkinder,
			@PathVariable("iduser") Long usertId) {

		return bills.getAllBillForUserInKinder(idkinder, usertId);
	}

	@GetMapping("/getAllBillBykinder/{idkinder}")
	@ResponseBody
	public List<Bill> getAllBillBykinder(@PathVariable("idkinder") int idkinder) {

		return bills.getAllBillBykinder(idkinder);
	}

	@GetMapping("/NbreChild/{iduser}/{idkinder}")
	@ResponseBody
	public long getNumberOfChildForUserInKinderJPQL(@PathVariable("iduser") Long iduser,
			@PathVariable("idkinder") int idkinder) {

		return bills.getNumberOfChildForUserInKinderJPQL(iduser, idkinder);
	}

}
