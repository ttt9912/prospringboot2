package ch103.statepattern.postoffice.context;

import ch103.statepattern.postoffice.state.OrderedState;
import ch103.statepattern.postoffice.state.PostPackageState;
import lombok.Data;

/*
 * State Class
 */
@Data
public class PostPackage {
    private PostPackageState state = new OrderedState();

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}
