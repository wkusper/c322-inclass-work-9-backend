package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/merger")

public class MergerController {
    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;

    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }
    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> menuItems = new ArrayList<>();
        Iterator dinerIterator = dinerRepository.getTheMenuIterator();
        while (dinerIterator.hasNext()) {
            menuItems.add((MenuItem) dinerIterator.next());
        }
        Iterator<MenuItem> pancakeIterator = pancakeHouseRepository.getTheMenuIterator();
        menuItems.addAll(breakfastItems);
        return menuItems;
    }
}
