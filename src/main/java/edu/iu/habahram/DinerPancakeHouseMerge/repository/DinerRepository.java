package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenuIterator;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class DinerRepository {

    public DinerMenuIterator getTheMenuIterator() {
        DinerMenu dinerMenu = new DinerMenu();
        return dinerMenu.createIterator();
    }
}
