package tn.esprit.kidzone.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.kidzone.entity.User;
import tn.esprit.kidzone.services.IUserService;


@Named("pieChartBean")
@ViewScoped
public class PieChartBean {

		@Autowired
		private IUserService userService;	
		private PieChartModel model;
		private List<User> listUsers;
	  public void setModel(PieChartModel model) {
		this.model = model;
	}
	  

	public PieChartBean() {
	}


	@PostConstruct
	  public void init() {
			listUsers = userService.getAllUsers();
			int numbActif = 0;
			int numNonActif =0;
			for (int i=0; i<listUsers.size();i++){
				if(listUsers.get(i).isActif()){
					
					numbActif++;
				}
				else {
					
					numNonActif++;
				}

			}
			model = new PieChartModel();
			model.set("Enabled Accounts", numbActif);
			model.set("Blocked Accounts", numNonActif);
	      //followings are some optional customizations:
	      //set title
	      model.setTitle("Your KidZone active accounts");
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
	      model.setSeriesColors("aaf,afa,faa,ffa,aff,faf,ddd");
	  }

	  public PieChartModel getModel() {
	      return model;
	  }
	}

