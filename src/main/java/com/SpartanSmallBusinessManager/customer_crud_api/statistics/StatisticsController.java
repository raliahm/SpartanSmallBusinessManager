package com.SpartanSmallBusinessManager.API.statistics;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public String showStatistics(Model model, HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        Statistics stats = statisticsService.getStatsForProvider(provider);
        model.addAttribute("statistics", stats != null ? stats : new Statistics(0, 0, provider));

        return "statistics";
    }
}
