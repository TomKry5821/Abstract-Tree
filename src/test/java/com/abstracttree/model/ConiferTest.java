package com.abstracttree.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConiferTest {
    private Conifer conifer;

    @BeforeEach
    void setUp() {
        this.conifer = new Conifer();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 25, 26, 5, 6, 90, 1000})
    void testTrunkHeightGrow(int param) {
        int expectedTrunkHeight = (param < 25) ? param + 1 : 25;

        for (int i = 0; i < param; i++) {
            this.conifer.grow();
        }
        int trunkHeight = this.conifer.getTrunk().getHeight();

        assertEquals(expectedTrunkHeight, trunkHeight);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 34, 55, 69, 70, 71, 100, 1000})
    void testBranchLengthGrow(int param) {
        int expectedBranchLength = (param < 70) ? param : 70;
        for (int i = 0; i < param; i++) {
            this.conifer.grow();
        }
        int branchLength = this.conifer.getTrunk().getBranches().get(0).getLength();
        assertEquals(expectedBranchLength, branchLength);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 8, 20, 60, 100, 1000})
    void testShedLeaves(int param) {
        int expectedLeavesNumber = (param < 11) ? ((int) (Math.pow(3, param - 1)) / 3) : 19683;

        for (int i = 0; i < param; i++) {
            this.conifer.grow();
        }
        this.conifer.shedLeaves();
        int leavesNumber = this.conifer.getTrunk().getBranches().get(0).getLeavesNumber();

        assertEquals(expectedLeavesNumber, leavesNumber);
    }
}