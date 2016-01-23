package caesweb.view;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import caesweb.business.AtendimentoBusiness;
import caesweb.model.Atendimento;
import caesweb.util.JsfUtil;

@ManagedBean
@ViewScoped
public class AtendimentoMB {
	
	@EJB
	private AtendimentoBusiness business;
	
	private List<Atendimento> atendimentos;
	
	private Atendimento atendimento;
	
	private ScheduleModel eventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();
	
	@PostConstruct
	private void init() {
		atendimento = new Atendimento();
		eventModel = new DefaultScheduleModel();
		atendimentos = business.listar();
		try{
		for(Atendimento a : atendimentos){
			DefaultScheduleEvent evento = new DefaultScheduleEvent();
			evento.setAllDay(false);
			evento.setEndDate(a.getDataFim());
			evento.setStartDate(a.getDataInicio());
			evento.setTitle(a.getTipo().getDescricao()+" Pac: "+a.getPaciente().getNome()+" Pro: " +a.getProfissional().getNome());
			evento.setEditable(true);
			evento.setDescription(a.getDescricao());
			evento.setData(a.getId().toString());
			eventModel.addEvent(evento);
		}
		}catch(NullPointerException npe){
			
		}
	}
	
	public void quandoNovo(SelectEvent selectEvent){
		ScheduleEvent event = new DefaultScheduleEvent("", (Date)selectEvent.getObject() ,(Date) selectEvent.getObject());
		
		atendimento = new Atendimento();
		
		atendimento.setDataInicio(event.getStartDate());
		atendimento.setDataFim(event.getEndDate());
	}
	
	public void quandoSelecionado(SelectEvent selectEvent){
		ScheduleEvent event = (ScheduleEvent) selectEvent.getObject();
		
		for(Atendimento at : atendimentos){
			if(at.getId()==Long.parseLong(event.getData().toString())){ 
				atendimento = at;
				break;
			}
		}
	}
	
	public void quandoMovido(ScheduleEntryMoveEvent event){
		for(Atendimento at : atendimentos){
			if(at.getId()==Long.parseLong(event.getScheduleEvent().getData().toString())){
				atendimento = at;
				business.salvar(atendimento);
				break;
			}
		}
	}
	
	public void quandoRedimensionado(ScheduleEntryResizeEvent event){
		for(Atendimento at : atendimentos){
			if(at.getId()==Long.parseLong(event.getScheduleEvent().getData().toString())){
				atendimento = at;
				business.salvar(atendimento);
				break;
			}
		}
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}
	

	public void salvar() {
		business.salvar(atendimento);
		atendimento = new Atendimento();
		JsfUtil.showInfoMessage("Atendimento salvo!");
	}


	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}
	
	
	
	
	

}
