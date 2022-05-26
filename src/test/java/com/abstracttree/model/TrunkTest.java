package com.abstracttree.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrunkTest {

    private Trunk trunk;

    @BeforeEach
    void setUp() {
        this.trunk = new Trunk();
    }

    @ParameterizedTest
    @ValueSource(floats = {1.0f, 2.0f, 4.0f, 450.0f, 1000.0f})
    void testGrowUpWithPositiveRatio(float param) {
        int expectedTrunkHeight = (param < 25) ? (int) param + 1 : 25;
        int expectedBranchesNumber = (int) param;

        for (int i = 0; i < param; i++) {
            this.trunk.growUp(param);
        }

        assertEquals(expectedTrunkHeight, this.trunk.getHeight());
        assertEquals(expectedBranchesNumber, this.trunk.getBranches().size());
    }

    @ParameterizedTest
    @ValueSource(floats = {-1.0f, -2.0f, -4.0f, 0.0f})
    void testGrowUpWithNegativeRatio(float param) {
        int expectedTrunkHeight = 1;
        int expectedBranchesNumber = 0;

        for (int i = 0; i < param; i++) {
            this.trunk.growUp(param);
        }

        assertEquals(expectedTrunkHeight, this.trunk.getHeight());
        assertEquals(expectedBranchesNumber, this.trunk.getBranches().size());
    }

}