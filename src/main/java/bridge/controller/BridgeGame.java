package bridge.controller;

import bridge.constant.Error;
import bridge.model.BridgeStatus;
import bridge.constant.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge = new ArrayList<>();
    private BridgeStatus bridgeStatus = new BridgeStatus();
    public void setBridge (List<String> bridge) {
        this.bridge = bridge;
    }
    public boolean move(String movement, String space) {
        validate(movement);
        if(movement.equals(space)) {
            bridgeStatus.addStatus(Game.CROSS_SUCCESS);
            return true;
        }
        bridgeStatus.addStatus(Game.CROSS_FAIL);
        return false;
    }
    private void validate(String movement) {
        if(!movement.equals(Game.BRIDGE_GENERATE_DOWN) && !movement.equals(Game.BRIDGE_GENERATE_UP)) {
            throw new IllegalArgumentException(Error.MOVEMENT_VALID.getError());
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
