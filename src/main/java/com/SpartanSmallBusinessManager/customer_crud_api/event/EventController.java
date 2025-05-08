package com.SpartanSmallBusinessManager.API.event;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public String showEvents(Model model, HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        List<Event> events = service.getAllEventsForProvider(provider);
        model.addAttribute("events", events);
        return "event";
    }

    @PostMapping("/create")
    public String createEvent(@RequestParam String eventName,
                              @RequestParam String eventDescription,
                              @RequestParam String eventLocation,
                              @RequestParam String eventDate,
                              HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        Event event = new Event(eventName, eventDescription, eventLocation,
                LocalDate.parse(eventDate), provider);

        service.addNewEvent(event);
        return "redirect:/events";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable int id,
                              @RequestParam String eventName,
                              @RequestParam String eventDescription,
                              @RequestParam String eventLocation,
                              @RequestParam String eventDate,
                              HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        Event updated = new Event(eventName, eventDescription, eventLocation,
                LocalDate.parse(eventDate), provider);
        updated.setEventId(id);

        service.updateEvent(id, updated);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable int id, HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        Event event = service.getEventById(id);
        if (event != null && event.getProvider().getProviderId() == provider.getProviderId()) {
            service.deleteEventById(id);
        }

        return "redirect:/events";
    }
}
