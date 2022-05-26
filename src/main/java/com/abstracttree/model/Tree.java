package com.abstracttree.model;

public abstract class Tree {

    protected final LeafType LEAF_TYPE;
    protected final float LEAF_DROP_RATIO;
    protected final float LEAF_GROWTH_RATIO;
    private Trunk trunk;

    public Tree(LeafType LEAF_TYPE, float LEAF_DROP_RATIO, float LEAF_GROWTH_RATIO) {
        this.trunk = new Trunk();
        this.LEAF_TYPE = LEAF_TYPE;
        this.LEAF_DROP_RATIO = LEAF_DROP_RATIO;
        this.LEAF_GROWTH_RATIO = LEAF_GROWTH_RATIO;
    }

    protected Trunk getTrunk() {
        return trunk;
    }

    public abstract void grow();

    public abstract void shedLeaves();

    public void fallDown() {
        this.trunk = new Trunk();
    }

}
