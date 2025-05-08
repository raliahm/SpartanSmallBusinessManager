package com.SpartanSmallBusinessManager.API.review;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public String showReviews(Model model, HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        model.addAttribute("reviews", reviewService.getReviewsForProvider(provider));
        return "review";
    }

    @PostMapping("/reply/{id}")
    public String saveReply(@PathVariable int id,
                            @RequestParam("replyContent") String replyContent,
                            HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        reviewService.saveReply(id, replyContent);
        return "redirect:/reviews";
    }

    @GetMapping("/reply/delete/{id}")
    public String deleteReply(@PathVariable int id, HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        reviewService.deleteReply(id);
        return "redirect:/reviews";
    }
}
