package com.abstracttree.model;

public class Branch {

    private static final short MAX_LENGTH_IN_CENTIMETERS = 70;
    private static final short MAX_LEAVES_NUMBER = 20000;
    private int leavesNumber;

    private short length;

    public Branch() {
        this.leavesNumber = 1;
        this.length = 1;
    }

    public int getLeavesNumber() {
        return this.leavesNumber;
    }

    public short getLength() {
        return this.length;
    }

    public void growUp(float leafGrowthRatio) {
        if (leafGrowthRatio <= 0) {
            return;
        }
        this.increaseLength();
        this.increaseLeavesNumber(leafGrowthRatio);
    }

    private void increaseLength() {
        if (!this.reachedMaxLength()) {
            this.length += 1;
        }
    }

    private boolean reachedMaxLength() {
        return this.length >= MAX_LENGTH_IN_CENTIMETERS;
    }

    private void increaseLeavesNumber(float leafGrowthRatio) {
        if (leafGrowthRatio <= 0) {
            return;
        }
        if (!this.reachedMaxLeavesNumber()) {
            this.leavesNumber *= leafGrowthRatio;
        }
    }

    private boolean reachedMaxLeavesNumber() {
        return this.leavesNumber >= MAX_LEAVES_NUMBER;
    }

    public void decreaseLeavesNumber(float leafDropRatio) {
        this.leavesNumber /= leafDropRatio;
    }
}
