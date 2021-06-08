package tn.esprit.kidzone.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.kidzone.entity.Bill;
import tn.esprit.kidzone.services.IBillService;


@Named("billPie")
@ViewScoped
public class BillPie {

		@Autowired
		private IBillService billService;	
		private PieChartModel model;
		private List<Bill> listBills;
	  public void setModel(PieChartModel model) {
		this.model = model;
	}
	  

	public BillPie() {
	}


	@PostConstruct
	  public void init() {
		listBills = billService.getAllBill();
			int numbActif = 0;
			int numNonActif =0;
			for (int i=0; i<listBills.size();i++){
				if(listBills.get(i).getTotalPrice()>1000){

				numbActif++;
			}
			else {
				
				numNonActif++;
			}
		
			}
			model = new PieChartModel();
			model.set("Bills over 200 capacity", numbActif);
			model.set("Bills under 200 capacity", numNonActif);
	      //followings are some optional customizations:
	      //set title

			//set legend position to 'e' (east), other values are 'w', 's' and 'n'
	      model.setLegendPosition("e");
	      //enable tooltips
	      model.setShowDatatip(true);
	      //show labels inside pie chart
	      model.setShowDataLabels(true);
	      //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
	      model.setDataFormat("value");
	      //format: %d for 'value', %s for 'label', %d%% for 'percent'
	      model.setDataLabelFormatString("%d");
	      //pie sector colors
	      model.setSeriesColors("37FF33,F6FF33,faa,ffa,aff,faf,ddd");
	  }

	  public PieChartModel getModel() {
	      return model;
	  }
	}

