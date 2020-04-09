package ch103.statepattern.postoffice.state;

import ch103.statepattern.postoffice.context.PostPackage;

public class ReceivedState implements PostPackageState {

    @Override
    public void next(final PostPackage postPackage) {
        System.out.println("This package is already received by a client.");
    }

    @Override
    public void prev(final PostPackage postPackage) {
        postPackage.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("This package is already received by a client.");
    }
}
