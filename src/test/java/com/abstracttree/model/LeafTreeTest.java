package com.abstracttree.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeafTreeTest {

    private LeafTree leafTree;

    @BeforeEach
    void setUp() {
        this.leafTree = new LeafTree();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 25, 26, 5, 6, 90, 1000})
    void testTrunkHeightGrow(int param) {
        int expectedTrunkHeight = (param < 25) ? param + 1 : 25;

        for (int i = 0; i < param; i++) {
            this.leafTree.grow();
        }
        int trunkHeight = this.leafTree.getTrunk().getHeight();

        assertEquals(expectedTrunkHeight, trunkHeight);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 34, 55, 69, 70, 71, 100, 1000})
    void testBranchLengthGrow(int param) {
        int expectedBranchLength = (param < 70) ? param : 70;
        for (int i = 0; i < param; i++) {
            this.leafTree.grow();
        }
        int branchLength = this.leafTree.getTrunk().getBranches().get(0).getLength();
        assertEquals(expectedBranchLength, branchLength);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 8, 20, 60, 100, 1000})
    void testShedLeaves(int param) {
        int expectedLeavesNumber = (param < 20) ? ((int) (Math.pow(2, param - 1)) / 2) : 16384;

        for (int i = 0; i < param; i++) {
            this.leafTree.grow();
        }
        this.leafTree.shedLeaves();
        int leavesNumber = this.leafTree.getTrunk().getBranches().get(0).getLeavesNumber();

        assertEquals(expectedLeavesNumber, leavesNumber);
    }
}