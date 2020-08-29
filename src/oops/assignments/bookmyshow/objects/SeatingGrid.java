package oops.assignments.bookmyshow.objects;

import java.util.concurrent.locks.ReentrantLock;

public class SeatingGrid {

    private String id;
    private Boolean[][] grid;
    private ReentrantLock[] locks;

    public SeatingGrid(String id, int rows, int seatsPerRow, Boolean[][] grid) {
        this.id = id;
        this.grid = grid;
        this.locks = new ReentrantLock[rows * seatsPerRow];
        for (int lock = 0; lock < rows * seatsPerRow; lock++) {
            this.locks[lock] = new ReentrantLock();
        }
    }

    public String getId() {
        return id;
    }

    public Boolean[][] getGrid() {
        return grid;
    }

    public void setGrid(Boolean[][] grid) {
        this.grid = grid;
    }

    public boolean vacateSeat(int row, int seatInTheRow) {
        return this.grid[row][seatInTheRow] != null && !this.grid[row][seatInTheRow];
    }

    public boolean bookSeat(int row, int seatInTheRow) {
        if (this.grid[row][seatInTheRow] == null || this.grid[row][seatInTheRow]) {
            throw new IllegalStateException("Either seat is unavailable or already booked.");
        }
        this.grid[row][seatInTheRow] = true;
        return true;
    }

    public boolean cancelSeat(int row, int seatInTheRow) {
        if (this.grid[row][seatInTheRow] == null || !this.grid[row][seatInTheRow]) {
            throw new IllegalStateException("Either seat is unavailable or already booked.");
        }
        this.grid[row][seatInTheRow] = false;
        return true;
    }

    public void attainLock(int row, int seatInTheRow) {
        ReentrantLock lock = locks[row * seatInTheRow];
        lock.lock();
    }

    public void releaseLock(int row, int seatInTheRow) {
        ReentrantLock lock = locks[row * seatInTheRow];
        lock.unlock();
    }

}
