package pl.mojaaplikacja.component;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.mojaaplikacja.model.Participant;


@Component
public class EventHolder {

	private List<Participant> participants;

	public EventHolder() {
		participants = new LinkedList<Participant>();
	}

	public List<Participant> getParticipants(){
		return participants;
	}
	
	public void addParticipant(Participant participant) {
		participants.add(participant);
	}
	
	public boolean checkIfRegistered(Participant participant) {
		return participants.contains(participant);
	}
}
