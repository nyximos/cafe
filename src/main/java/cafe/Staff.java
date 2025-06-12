package cafe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Staff {
    private String emoji;
    private boolean isCashier;
    private boolean isBarista;
    private StaffStatus status;

    public Staff(String emoji, boolean isCashier, boolean isBarista) {
        this.emoji = emoji;
        this.isCashier = isCashier;
        this.isBarista = isBarista;
        this.status = StaffStatus.WAITING;
    }

    public boolean isPossible(ActionType actionType) {
        boolean possibleStatus = false;
        if (ActionType.ORDER.equals(actionType) && this.status.isWaiting()) {
            possibleStatus = this.isCashier;
        } else if (ActionType.MAKE_COFFEE.equals(actionType) && this.status.isWaiting()) {
            possibleStatus = this.isBarista;
        }
        return possibleStatus;
    }

    public void say(String sentence) {
        System.out.println(this.emoji + " : " + sentence);
    }

    public void updateStatus(StaffStatus status) {
        this.status = status;
    }
}
