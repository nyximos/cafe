package cafe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StaffStatus {
    WAITING("대기중"),
    MAKING("제조중"),
    CASHIERING("계산중")
    ;

    private final String description;

    public boolean isWaiting() {
        return StaffStatus.WAITING.equals(this);
    }

}
