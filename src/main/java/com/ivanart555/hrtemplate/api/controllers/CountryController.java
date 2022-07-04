package com.ivanart555.hrtemplate.api.controllers;

import com.ivanart555.hrtemplate.entities.Country;
import com.ivanart555.hrtemplate.entities.Position;
import com.ivanart555.hrtemplate.exceptions.ServiceException;
import com.ivanart555.hrtemplate.services.CountryService;
import com.ivanart555.hrtemplate.services.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
@Controller
@RequestMapping("/countries")
public class CountryController {

    private static final String REDIRECT_COUNTRIES = "redirect:/countries";
    private CountryService countryService;

    @GetMapping()
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) throws ServiceException {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(15);

        Pageable sortedById = PageRequest.of(currentPage - 1, pageSize, Sort.by("id").ascending());
        Page<Country> countryPage = countryService.findAll(sortedById);

        model.addAttribute("country", new Country());

        model.addAttribute("countryPage", countryPage);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", countryPage.getTotalPages());
        int totalPages = countryPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "countries/index";
    }

    @PostMapping()
    public String create(@ModelAttribute("position") @Valid Country country, BindingResult bindingResult)
            throws ServiceException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        countryService.save(country);
        return REDIRECT_COUNTRIES;
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("position") @Valid Country country, BindingResult bindingResult)
            throws ServiceException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        countryService.save(country);
        return REDIRECT_COUNTRIES;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) throws ServiceException {
        countryService.deleteById(id);
        return REDIRECT_COUNTRIES;
    }
}
