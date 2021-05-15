package tn.esprit.kidzone.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tn.esprit.kidzone.repository.ReclamationRepository;
import tn.esprit.kidzone.entity.Reclamation;

@Scope(value = "session")
@Component(value = "")
@ELBeanName(value = "")
@Join(path = "/", to = "")
public class ReclamationJsfController {
    @Autowired
    private ReclamationRepository ReclamationRepository;

    private Reclamation reclamation = new Reclamation();

    public String save() {
    	ReclamationRepository.save(reclamation);
        reclamation = new Reclamation();
        return "/SpringMVC/reclamationAll.xhtml?faces-redirect=true";
    }

    public Reclamation getEvent() {
        return reclamation;
    }
}