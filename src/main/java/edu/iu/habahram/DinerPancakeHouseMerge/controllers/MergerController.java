package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public MenuItem[] get() {
        MenuItem[] dinerMenu = dinerRepository.getTheMenu();
        List<MenuItem> pancakeHouseMenu = pancakeHouseRepository.getTheMenu();
        MenuItem[] mergedMenu = new MenuItem[dinerMenu.length + pancakeHouseMenu.size()];
        System.arraycopy(dinerMenu, 0, mergedMenu, 0, dinerMenu.length);
        for (int i = 0; i < pancakeHouseMenu.size(); i++) {
            mergedMenu[dinerMenu.length + i] = pancakeHouseMenu.get(i);
        }
        return mergedMenu;
    }
}
