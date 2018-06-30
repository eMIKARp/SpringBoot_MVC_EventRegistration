package pl.mojaaplikacja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.mojaaplikacja.component.EventHolder;
import pl.mojaaplikacja.model.Participant;

@Controller
public class EventController {

	private EventHolder eventHolder;

	@Autowired
	public EventController(EventHolder eventHandler) {
		this.eventHolder = eventHandler;
	}

	@PostMapping("/register")
	public String register(@RequestParam String firstName, String lastName) {
		Participant participant = new Participant(firstName, lastName);
		if (eventHolder.checkIfRegistered(participant)) {
			return "redirect:error";
			
		} else {
			eventHolder.addParticipant(participant);
			return "redirect:success";
		}
	}
	
	@GetMapping("/success")
	public String addProduct() {
		return "success";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	@GetMapping("/show")
	public String show() {
		for (Participant participant:eventHolder.getParticipants()) {
			System.out.println(participant);
		}
		return "redirect:/";
	}
}
