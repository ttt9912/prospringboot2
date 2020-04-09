package ch103.statepattern.postoffice.state;

import ch103.statepattern.postoffice.context.PostPackage;

public class DeliveredState implements PostPackageState {
    @Override
    public void next(final PostPackage postPackage) {
        postPackage.setState(new ReceivedState());
    }

    @Override
    public void prev(final PostPackage postPackage) {
        postPackage.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package delivered to post office, not received yet.");
    }
}
