package com.abstracttree.model;

import java.util.ArrayList;
import java.util.List;

public class Trunk {

    private static final short MAX_HEIGHT_IN_METERS = 25;

    private short height;

    private List<Branch> branches;

    public Trunk() {
        this.height = 1;
        this.branches = new ArrayList<>();
    }

    public List<Branch> getBranches() {
        return this.branches;
    }

    public short getHeight() {
        return this.height;
    }

    public void growUp(float leafGrowthRatio) {
        if (leafGrowthRatio <= 0) {
            return;
        }

        this.increaseHeight();

        this.branches.forEach(b -> {
            b.growUp(leafGrowthRatio);
        });
        this.increaseBranchesNumber();
    }

    private void increaseHeight() {
        if (!this.reachedMaxHeight()) {
            this.height += 1;
        }
    }

    private void increaseBranchesNumber() {
        this.branches.add(new Branch());
    }

    private boolean reachedMaxHeight() {
        return this.height >= MAX_HEIGHT_IN_METERS;
    }

    public void shedLeaves(float leafDropRatio) {
        if (leafDropRatio <= 0) {
            return;
        }
        this.branches.forEach(b -> {
            b.decreaseLeavesNumber(leafDropRatio);
        });
    }

}
