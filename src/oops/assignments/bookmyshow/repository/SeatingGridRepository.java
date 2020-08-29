package oops.assignments.bookmyshow.repository;

import oops.assignments.bookmyshow.objects.SeatingGrid;

public class SeatingGridRepository extends Repository<SeatingGrid, String> {

    public void save(SeatingGrid seatingGrid) {
        super.save(seatingGrid, seatingGrid.getId());
    }

}
