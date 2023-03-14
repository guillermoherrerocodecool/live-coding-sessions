package com.codecool.idealpresent.logic.presents.selector;

import com.codecool.idealpresent.data.Profile;

import java.util.Set;

public interface Selector {

    boolean matches(Profile profile);

    Set<String> getPresents(Profile profile);
}
