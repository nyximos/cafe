package cafe;

import java.util.List;
import java.util.Optional;

public class StaffSelector {
    private List<Staff> staff;

    public StaffSelector(List<Staff> staff) {
        this.staff = staff;
    }

    public Staff selector(ActionType actionType) throws InterruptedException {
        Optional<Staff> possibleStaff = staff.stream().filter(staff -> staff.isPossible(actionType)).findFirst();
        while (possibleStaff.isEmpty()) {
            Thread.sleep(2000);
            possibleStaff = staff.stream().filter(staff -> staff.isPossible(actionType)).findFirst();
        }
        return possibleStaff.get();
    }
}
