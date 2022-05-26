package com.abstracttree.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BranchTest {

    private Branch branch;

    @BeforeEach
    void setUp() {
        branch = new Branch();
    }

    @ParameterizedTest
    @ValueSource(floats = {1.0f, 2.0f, 3.0f, 10.0f, 35.5f, 100.8f})
    void testGrowUpWithPositiveRatio(float param) {
        int expectedLength = 2;
        int expectedLeavesNumber = (int) param;

        this.branch.growUp(param);

        assertEquals(expectedLength, this.branch.getLength());
        assertEquals(expectedLeavesNumber, this.branch.getLeavesNumber());
    }

    @ParameterizedTest
    @ValueSource(floats = {-1.0f, 0.0f, -3.0f, -13.0f, -55.5f, -170.8f})
    void testGrowUpWithNegativeRatio(float param) {
        int expectedLength = 1;
        int expectedLeavesNumber = 1;

        this.branch.growUp(param);

        assertEquals(expectedLength, this.branch.getLength());
        assertEquals(expectedLeavesNumber, this.branch.getLeavesNumber());
    }

}