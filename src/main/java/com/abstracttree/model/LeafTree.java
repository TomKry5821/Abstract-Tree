package com.abstracttree.model;

import java.util.Locale;

public class LeafTree extends Tree {


    public LeafTree() {
        super(LeafType.LEAF, 2.0f, 2.0f);
    }

    @Override
    public void grow() {
        this.getTrunk().growUp(this.LEAF_GROWTH_RATIO);
    }

    @Override
    public void shedLeaves() {
        this.getTrunk().shedLeaves(LEAF_DROP_RATIO);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Tree type - " + this.getClass().getSimpleName() + "\n").append("Leaf type - " + this.LEAF_TYPE.toString().toLowerCase(Locale.ROOT) + "\n");
        for (Branch branch : this.getTrunk().getBranches()) {
            result.append("BRANCH\n").append("Leaves number - ").append(branch.getLeavesNumber()).append("\n");
        }
        return result.toString();
    }
}
